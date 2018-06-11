package com.android.march.mvpdagger.taskdetail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.march.mvpdagger.R;
import com.android.march.mvpdagger.ToDoApplication;

import javax.inject.Inject;

public class TaskDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TASK_ID = "TASK_ID";

    @Inject
    TaskDetailPresenter taskDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("任务详情");
        toolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        String taskId = getIntent().getStringExtra(EXTRA_TASK_ID);
        TaskDetailFragment taskDetailFragment = (TaskDetailFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (taskDetailFragment == null) {
            taskDetailFragment = TaskDetailFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, taskDetailFragment).commit();
        }

        DaggerTaskDetailComponent.builder()
                .tasksRepositoryComponent(((ToDoApplication) getApplication()).getTasksRepositoryComponent())
                .taskDetailModule(new TaskDetailModule(taskId, taskDetailFragment))
                .build().inject(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}