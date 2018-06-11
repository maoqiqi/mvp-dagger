package com.android.march.mvpdagger.data.source;

import com.android.march.mvpdagger.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TasksRepositoryModule.class, ApplicationModule.class})
public interface TasksRepositoryComponent {

    TasksRepository getTasksRepository();
}