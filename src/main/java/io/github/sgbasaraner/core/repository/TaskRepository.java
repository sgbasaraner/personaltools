package io.github.sgbasaraner.core.repository;

import java.time.LocalDate;
import java.util.List;

import io.github.sgbasaraner.core.datasource.TaskDataSource;
import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.model.Task.Status;

public class TaskRepository {

    final TaskDataSource dataSource;

    public TaskRepository(TaskDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Task createTask(Task task) {
        return dataSource.createTask(task);
    }

    public List<Task> getAllTasks() {
        return dataSource.getAllTasks();
    }

    public List<Task> getTasksByStatus(Status status) {
        return dataSource.getTasksByStatus(status);
    }

    public List<Task> getTasksByDeadlineDate(LocalDate deadlineDate) {
        return dataSource.getTasksByDeadlineDate(deadlineDate);
    }

    public List<Task> getTasksMatching(String string) {
        return dataSource.getTasksMatching(string);
    }
}
