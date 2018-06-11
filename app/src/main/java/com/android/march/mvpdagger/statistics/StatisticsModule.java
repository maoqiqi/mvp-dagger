package com.android.march.mvpdagger.statistics;

import dagger.Module;
import dagger.Provides;

@Module
public class StatisticsModule {

    private final StatisticsContract.View statisticsView;

    public StatisticsModule(StatisticsContract.View statisticsView) {
        this.statisticsView = statisticsView;
    }

    @Provides
    StatisticsContract.View provideStatisticsView() {
        return statisticsView;
    }
}