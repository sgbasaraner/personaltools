package io.github.sgbasaraner.core.usecase;

import java.util.UUID;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class GetTask {
    final TaskRepository repository;

    public GetTask(TaskRepository repository) {
        this.repository = repository;
    }

    public Task run(UUID id) {
        return repository.getTask(id);
    }
}
