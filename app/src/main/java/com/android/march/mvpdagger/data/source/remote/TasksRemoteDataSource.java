package com.android.march.mvpdagger.data.source.remote;

import android.os.Handler;

import com.android.march.mvpdagger.data.TaskBean;
import com.android.march.mvpdagger.data.source.TasksDataSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TasksRemoteDataSource implements TasksDataSource {

    private static final int SERVICE_LATENCY_IN_MILLIS = 5000;

    private final static Map<String, TaskBean> TASKS_SERVICE_DATA;

    static {
        TASKS_SERVICE_DATA = new LinkedHashMap<>(2);
        addTask("Build tower in Pisa", "Ground looks good, no foundation work required.");
        addTask("Finish bridge in Tacoma", "Found awesome girders at half the cost!");
    }

    @Inject
    public TasksRemoteDataSource() {

    }

    @Override
    public void loadTasks(final TasksDataSource.LoadTasksCallBack callBack) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callBack.onTasksLoaded(new ArrayList<>(TASKS_SERVICE_DATA.values()));
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void getTask(String taskId, final GetTaskCallBack callBack) {
        final TaskBean taskBean = TASKS_SERVICE_DATA.get(taskId);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callBack.onTaskLoaded(taskBean);
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void clearCompletedTasks() {
        Iterator<Map.Entry<String, TaskBean>> iterator = TASKS_SERVICE_DATA.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, TaskBean> entry = iterator.next();
            if (entry.getValue().isCompleted()) {
                iterator.remove();
            }
        }
    }

    @Override
    public void refreshTasks() {

    }

    @Override
    public void addTask(TaskBean taskBean) {
        TASKS_SERVICE_DATA.put(taskBean.getId(), taskBean);
    }

    @Override
    public void updateTask(TaskBean taskBean) {
        TASKS_SERVICE_DATA.put(taskBean.getId(), taskBean);
    }

    @Override
    public void completeTask(TaskBean completedTaskBean) {
        TaskBean taskBean = new TaskBean(completedTaskBean.getId(), completedTaskBean.getTitle(), completedTaskBean.getDescription(), true);
        TASKS_SERVICE_DATA.put(completedTaskBean.getId(), taskBean);
    }

    @Override
    public void completeTask(String taskId) {

    }

    @Override
    public void activateTask(TaskBean activeTaskBean) {
        TaskBean taskBean = new TaskBean(activeTaskBean.getId(), activeTaskBean.getTitle(), activeTaskBean.getDescription(), false);
        TASKS_SERVICE_DATA.put(activeTaskBean.getId(), taskBean);
    }

    @Override
    public void activateTask(String taskId) {

    }

    @Override
    public void deleteAllTasks() {
        TASKS_SERVICE_DATA.clear();
    }

    @Override
    public void deleteTask(String taskId) {
        TASKS_SERVICE_DATA.remove(taskId);
    }

    private static void addTask(String title, String description) {
        TaskBean taskBean = new TaskBean(title, description, false);
        TASKS_SERVICE_DATA.put(taskBean.getId(), taskBean);
    }
}