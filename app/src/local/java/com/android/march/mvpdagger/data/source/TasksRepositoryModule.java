package com.android.march.mvpdagger.data.source;

import com.android.march.mvpdagger.data.source.local.TasksLocalDataSource;
import com.android.march.mvpdagger.data.source.remote.FakeTasksRemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TasksRepositoryModule {

    @Remote
    @Singleton
    @Binds
    abstract TasksDataSource provideTasksRemoteDataSource(FakeTasksRemoteDataSource dataSource);

    @Local
    @Singleton
    @Binds
    abstract TasksDataSource provideTasksLocalDataSource(TasksLocalDataSource dataSource);
}