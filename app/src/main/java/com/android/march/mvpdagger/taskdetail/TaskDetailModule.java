package com.android.march.mvpdagger.taskdetail;

import dagger.Module;
import dagger.Provides;

@Module
public class TaskDetailModule {

    private final String taskId;
    private final TaskDetailContract.View taskDetailView;

    public TaskDetailModule(String taskId, TaskDetailContract.View taskDetailView) {
        this.taskId = taskId;
        this.taskDetailView = taskDetailView;
    }

    @Provides
    String provideTaskId() {
        return taskId;
    }

    @Provides
    TaskDetailContract.View provideTaskDetailView() {
        return taskDetailView;
    }
}