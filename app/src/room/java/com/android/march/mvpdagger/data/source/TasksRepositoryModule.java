package com.android.march.mvpdagger.data.source;

import android.content.Context;

import com.android.march.mvpdagger.data.source.remote.TasksRemoteDataSource;
import com.android.march.mvpdagger.data.source.room.TasksRoomDataSource;
import com.android.march.mvpdagger.utils.AppExecutors;

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
        return new TasksRoomDataSource(context, new AppExecutors());
    }
}