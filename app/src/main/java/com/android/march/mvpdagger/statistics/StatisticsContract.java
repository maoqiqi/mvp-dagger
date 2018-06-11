package com.android.march.mvpdagger.statistics;

import com.android.march.mvpdagger.base.BasePresenter;
import com.android.march.mvpdagger.base.BaseView;

public interface StatisticsContract {

    interface Presenter extends BasePresenter {

        void loadStatistics();
    }

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void setLoadingIndicator(boolean showLoading);

        void showStatistics(int numberOfActiveTasks, int numberOfCompletedTasks);

        void showMessage(String message);
    }
}