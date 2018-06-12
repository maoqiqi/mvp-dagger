package com.android.march.mvpdagger.data.source;

import com.android.march.mvpdagger.data.source.remote.TasksRemoteDataSource;
import com.android.march.mvpdagger.data.source.room.TasksRoomDataSource;
import com.android.march.mvpdagger.utils.AppExecutors;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class TasksRepositoryModule {

    @Remote
    @Singleton
    @Binds
    abstract TasksDataSource provideTasksRemoteDataSource(TasksRemoteDataSource dataSource);

    @Local
    @Singleton
    @Binds
    abstract TasksDataSource provideTasksLocalDataSource(TasksRoomDataSource dataSource);

    @Singleton
    @Provides
    static AppExecutors provideAppExecutors() {
        return new AppExecutors();
    }
}