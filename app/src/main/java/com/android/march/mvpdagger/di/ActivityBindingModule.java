package com.android.march.mvpdagger.di;

import com.android.march.mvpdagger.addedittask.AddEditTaskActivity;
import com.android.march.mvpdagger.addedittask.AddEditTaskModule;
import com.android.march.mvpdagger.statistics.StatisticsActivity;
import com.android.march.mvpdagger.statistics.StatisticsModule;
import com.android.march.mvpdagger.taskdetail.TaskDetailActivity;
import com.android.march.mvpdagger.taskdetail.TaskDetailModule;
import com.android.march.mvpdagger.tasks.TasksActivity;
import com.android.march.mvpdagger.tasks.TasksModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = TasksModule.class)
    abstract TasksActivity tasksActivityInjector();

    @ActivityScoped
    @ContributesAndroidInjector(modules = AddEditTaskModule.class)
    abstract AddEditTaskActivity addEditTaskActivityInjector();

    @ActivityScoped
    @ContributesAndroidInjector(modules = StatisticsModule.class)
    abstract StatisticsActivity statisticsActivityInjector();

    @ActivityScoped
    @ContributesAndroidInjector(modules = TaskDetailModule.class)
    abstract TaskDetailActivity taskDetailActivityInjector();
}