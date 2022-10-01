package io.github.sgbasaraner.core.usecase;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class CreateTask {
    final TaskRepository repository;

    public CreateTask(TaskRepository repository) {
        this.repository = repository;
    }

    public Task run(Task task) {
        return repository.createTask(task);
    }
}
