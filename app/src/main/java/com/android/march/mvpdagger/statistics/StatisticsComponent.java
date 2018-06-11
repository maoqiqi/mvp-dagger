package com.android.march.mvpdagger.statistics;

import com.android.march.mvpdagger.data.source.TasksRepositoryComponent;
import com.android.march.mvpdagger.di.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(dependencies = TasksRepositoryComponent.class, modules = StatisticsModule.class)
public interface StatisticsComponent {

    void inject(StatisticsActivity activity);
}