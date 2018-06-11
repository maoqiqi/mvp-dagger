package com.android.march.mvpdagger.tasks;

import com.android.march.mvpdagger.data.source.TasksRepositoryComponent;
import com.android.march.mvpdagger.di.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(dependencies = TasksRepositoryComponent.class, modules = TasksModule.class)
public interface TasksComponent {

    void inject(TasksActivity activity);
}