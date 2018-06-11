package com.android.march.mvpdagger.taskdetail;

import com.android.march.mvpdagger.data.source.TasksRepositoryComponent;
import com.android.march.mvpdagger.di.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(dependencies = TasksRepositoryComponent.class, modules = TaskDetailModule.class)
public interface TaskDetailComponent {

    void inject(TaskDetailActivity activity);
}