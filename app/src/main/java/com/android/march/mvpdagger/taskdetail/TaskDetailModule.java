package com.android.march.mvpdagger.taskdetail;

import com.android.march.mvpdagger.di.ActivityScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class TaskDetailModule {

    @ActivityScoped
    @Binds
    abstract TaskDetailContract.View taskDetailView(TaskDetailFragment fragment);

    @Provides
    @ActivityScoped
    static String provideTaskId(TaskDetailActivity activity) {
        return activity.getIntent().getStringExtra(TaskDetailActivity.EXTRA_TASK_ID);
    }
}