package com.android.march.mvpdagger.di;

import android.app.Application;

import com.android.march.mvpdagger.ToDoApplication;
import com.android.march.mvpdagger.data.source.TasksRepository;
import com.android.march.mvpdagger.data.source.TasksRepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        TasksRepositoryModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<ToDoApplication> {

    TasksRepository getTasksRepository();

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}