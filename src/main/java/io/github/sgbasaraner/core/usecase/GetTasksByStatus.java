package io.github.sgbasaraner.core.usecase;

import java.util.List;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.model.Task.Status;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class GetTasksByStatus {
    final TaskRepository repository;

    public GetTasksByStatus(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> run(Status status) {
        return repository.getTasksByStatus(status);
    }
}
