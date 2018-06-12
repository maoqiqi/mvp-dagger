package com.android.march.mvpdagger.addedittask;

import android.support.annotation.Nullable;

import com.android.march.mvpdagger.di.ActivityScoped;
import com.android.march.mvpdagger.statistics.StatisticsContract;
import com.android.march.mvpdagger.statistics.StatisticsFragment;
import com.android.march.mvpdagger.taskdetail.TaskDetailActivity;
import com.android.march.mvpdagger.taskdetail.TaskDetailContract;
import com.android.march.mvpdagger.taskdetail.TaskDetailFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AddEditTaskModule {

    @ActivityScoped
    @Binds
    abstract AddEditTaskContract.View statisticsView(AddEditTaskFragment fragment);

    @Provides
    @ActivityScoped
    @Nullable
    static String provideTaskId(AddEditTaskActivity activity) {
        return activity.getIntent().getStringExtra(AddEditTaskActivity.ARGUMENT_EDIT_TASK_ID);
    }

    @Provides
    @ActivityScoped
    static boolean provideDataMissing(AddEditTaskActivity activity) {
        return activity.isDataMissing();
    }
}