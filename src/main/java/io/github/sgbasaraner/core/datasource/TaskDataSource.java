package io.github.sgbasaraner.core.datasource;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.model.Task.Status;

public interface TaskDataSource {
    public Task getTask(UUID id);

    public Task createTask(Task task);

    public List<Task> getAllTasks();

    public List<Task> getTasksByStatus(Status status);

    public List<Task> getTasksByDeadlineDate(LocalDate deadlineDate);

    public List<Task> getTasksMatching(String string);

    public Task updateTask(Task task);
}