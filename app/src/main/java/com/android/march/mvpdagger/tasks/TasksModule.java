package com.android.march.mvpdagger.tasks;

import dagger.Module;
import dagger.Provides;

@Module
public class TasksModule {

    private final TasksContract.View tasksView;

    public TasksModule(TasksContract.View tasksView) {
        this.tasksView = tasksView;
    }

    @Provides
    TasksContract.View provideTasksView() {
        return tasksView;
    }
}