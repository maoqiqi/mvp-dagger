package com.android.march.mvpdagger.data.source;

import android.content.Context;

import com.android.march.mvpdagger.data.source.local.TasksLocalDataSource;
import com.android.march.mvpdagger.data.source.remote.TasksRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TasksRepositoryModule {

    @Remote
    @Singleton
    @Provides
    TasksDataSource provideTasksRemoteDataSource() {
        return new TasksRemoteDataSource();
    }

    @Local
    @Singleton
    @Provides
    TasksDataSource provideTasksLocalDataSource(Context context) {
        return new TasksLocalDataSource(context);
    }
}