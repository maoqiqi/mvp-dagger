package com.android.march.mvpdagger.addedittask;

import com.android.march.mvpdagger.data.TaskBean;
import com.android.march.mvpdagger.data.source.TasksDataSource;
import com.android.march.mvpdagger.data.source.TasksRepository;

import javax.inject.Inject;

public class AddEditTaskPresenter implements AddEditTaskContract.Presenter {

    private String taskId;
    private TasksRepository tasksRepository;
    private AddEditTaskContract.View addEditTaskView;
    private boolean isDataMissing;

    @Inject
    public AddEditTaskPresenter(TasksRepository tasksRepository, AddEditTaskContract.View addEditTaskView, boolean isDataMissing) {
        this.tasksRepository = tasksRepository;
        this.addEditTaskView = addEditTaskView;
        this.isDataMissing = isDataMissing;

        this.addEditTaskView.setPresenter(this);
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void start() {
        if (!isNewTask() && isDataMissing) {
            populateTask();
        }
    }

    @Override
    public void addTask(String title, String description) {
        if (title.equals("") || description.equals("")) {
            addEditTaskView.showMessage("任务不能为空");
            return;
        }

        TaskBean taskBean;
        if (isNewTask()) {
            taskBean = new TaskBean(title, description, false);
            tasksRepository.addTask(taskBean);
        } else {
            taskBean = new TaskBean(taskId, title, description, false);
            tasksRepository.updateTask(taskBean);
        }
        addEditTaskView.showTasks();
    }

    @Override
    public boolean isDataMissing() {
        return isDataMissing;
    }

    private boolean isNewTask() {
        return taskId == null;
    }

    private void populateTask() {
        if (isNewTask()) {
            throw new RuntimeException("populateTask() was called but task is new.");
        }
        tasksRepository.getTask(taskId, new TasksDataSource.GetTaskCallBack() {
            @Override
            public void onTaskLoaded(TaskBean taskBean) {
                if (addEditTaskView.isActive()) {
                    addEditTaskView.setTitle(taskBean.getTitle());
                    addEditTaskView.setDescription(taskBean.getDescription());
                }

                isDataMissing = false;
            }

            @Override
            public void onDataNotAvailable() {
                if (addEditTaskView.isActive()) {
                    addEditTaskView.showMessage("任务不能为空");
                }
            }
        });
    }
}