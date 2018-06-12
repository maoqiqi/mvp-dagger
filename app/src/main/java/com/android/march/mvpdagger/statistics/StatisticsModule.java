package com.android.march.mvpdagger.statistics;

import com.android.march.mvpdagger.di.ActivityScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class StatisticsModule {

    @ActivityScoped
    @Binds
    abstract StatisticsContract.View statisticsView(StatisticsFragment fragment);
}