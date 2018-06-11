package com.android.march.mvpdagger.tasks;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.march.mvpdagger.R;
import com.android.march.mvpdagger.ToDoApplication;

import javax.inject.Inject;

public class TasksActivity extends AppCompatActivity {

    private static final String CURRENT_FILTERING_KEY = "CURRENT_FILTERING_KEY";

    private Toolbar toolbar;
    private TextView tvApplicationId;

    // 使用@Inject时,不能用private修饰符修饰.
    @Inject
    TasksPresenter tasksPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        toolbar = findViewById(R.id.toolbar);
        tvApplicationId = findViewById(R.id.tvApplicationId);

        setSupportActionBar(toolbar);
        tvApplicationId.setText("AppId:" + getPackageName());

        TasksFragment tasksFragment = (TasksFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            tasksFragment = TasksFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, tasksFragment).commit();
        }

        DaggerTasksComponent.builder()
                .tasksRepositoryComponent(((ToDoApplication) getApplication()).getTasksRepositoryComponent())
                .tasksModule(new TasksModule(tasksFragment))
                .build().inject(this);

        // 加载以前保存的状态
        if (savedInstanceState != null) {
            TasksFilterType currentFiltering = (TasksFilterType) savedInstanceState.getSerializable(CURRENT_FILTERING_KEY);
            tasksPresenter.setFiltering(currentFiltering);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putSerializable(CURRENT_FILTERING_KEY, tasksPresenter.getFiltering());
        super.onSaveInstanceState(outState, outPersistentState);
    }
}