package com.android.march.mvpdagger;

import com.android.march.mvpdagger.data.source.TasksRepository;
import com.android.march.mvpdagger.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class ToDoApplication extends DaggerApplication {

    @Inject
    TasksRepository tasksRepository;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    public TasksRepository getTasksRepository() {
        return tasksRepository;
    }
}