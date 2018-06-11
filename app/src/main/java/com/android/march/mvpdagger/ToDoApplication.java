package com.android.march.mvpdagger;

import android.app.Application;

import com.android.march.mvpdagger.data.source.DaggerTasksRepositoryComponent;
import com.android.march.mvpdagger.data.source.TasksRepositoryComponent;
import com.android.march.mvpdagger.data.source.TasksRepositoryModule;

public class ToDoApplication extends Application {

    private TasksRepositoryComponent tasksRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        tasksRepositoryComponent = DaggerTasksRepositoryComponent.builder()
                .tasksRepositoryModule(new TasksRepositoryModule())
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .build();
    }

    public TasksRepositoryComponent getTasksRepositoryComponent() {
        return tasksRepositoryComponent;
    }
}