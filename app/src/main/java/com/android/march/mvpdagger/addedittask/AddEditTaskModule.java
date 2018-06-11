package com.android.march.mvpdagger.addedittask;

import android.support.annotation.Nullable;

import dagger.Module;
import dagger.Provides;

@Module
public class AddEditTaskModule {

    private final AddEditTaskContract.View addEditTaskView;
    private final boolean isDataMissing;

    public AddEditTaskModule(AddEditTaskContract.View addEditTaskView, boolean isDataMissing) {
        this.addEditTaskView = addEditTaskView;
        this.isDataMissing = isDataMissing;
    }

    @Provides
    AddEditTaskContract.View provideAddEditTaskView() {
        return addEditTaskView;
    }

    @Provides
    boolean provideIsDataMissing() {
        return isDataMissing;
    }
}