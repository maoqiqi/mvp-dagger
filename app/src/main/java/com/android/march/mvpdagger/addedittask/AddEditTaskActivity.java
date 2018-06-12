package com.android.march.mvpdagger.addedittask;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.march.mvpdagger.R;
import com.android.march.mvpdagger.ToDoApplication;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class AddEditTaskActivity extends AppCompatActivity {

    public static final String ARGUMENT_EDIT_TASK_ID = "EDIT_TASK_ID";

    public static final int REQUEST_ADD_TASK = 1;

    public static final String SHOULD_LOAD_DATA_FROM_REPO_KEY = "SHOULD_LOAD_DATA_FROM_REPO_KEY";

    private boolean isDataMissing = true;

    @Inject
    AddEditTaskPresenter presenter;
    @Inject
    AddEditTaskFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);

        String taskId = getIntent().getStringExtra(ARGUMENT_EDIT_TASK_ID);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if (taskId == null) {
            toolbar.setTitle("添加任务");
        } else {
            toolbar.setTitle("编辑任务");
        }
        toolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        AddEditTaskFragment addEditTaskFragment = (AddEditTaskFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (addEditTaskFragment == null) {
            addEditTaskFragment = fragment;
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, addEditTaskFragment).commit();
        }

        if (savedInstanceState != null) {
            isDataMissing = savedInstanceState.getBoolean(SHOULD_LOAD_DATA_FROM_REPO_KEY);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putBoolean(SHOULD_LOAD_DATA_FROM_REPO_KEY, presenter.isDataMissing());
        super.onSaveInstanceState(outState, outPersistentState);
    }

    public boolean isDataMissing() {
        return isDataMissing;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}