package com.android.march.mvpdagger.addedittask;

import com.android.march.mvpdagger.data.source.TasksRepositoryComponent;
import com.android.march.mvpdagger.di.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(dependencies = TasksRepositoryComponent.class, modules = AddEditTaskModule.class)
public interface AddEditTaskComponent {

    void inject(AddEditTaskActivity activity);
}