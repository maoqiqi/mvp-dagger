package com.android.march.mvpdagger.tasks;

import com.android.march.mvpdagger.di.ActivityScoped;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TasksModule {

    @ActivityScoped
    @Binds
    abstract TasksContract.View tasksView(TasksFragment fragment);
}