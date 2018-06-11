package com.android.march.mvpdagger.statistics;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.march.mvpdagger.R;
import com.android.march.mvpdagger.ToDoApplication;
import com.android.march.mvpdagger.taskdetail.DaggerTaskDetailComponent;
import com.android.march.mvpdagger.taskdetail.TaskDetailModule;

import javax.inject.Inject;

public class StatisticsActivity extends AppCompatActivity {

    @Inject
    StatisticsPresenter statisticsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Statistics");
        toolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        StatisticsFragment statisticsFragment = (StatisticsFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (statisticsFragment == null) {
            statisticsFragment = StatisticsFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, statisticsFragment).commit();
        }

        DaggerStatisticsComponent.builder()
                .tasksRepositoryComponent(((ToDoApplication) getApplication()).getTasksRepositoryComponent())
                .statisticsModule(new StatisticsModule(statisticsFragment))
                .build().inject(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}