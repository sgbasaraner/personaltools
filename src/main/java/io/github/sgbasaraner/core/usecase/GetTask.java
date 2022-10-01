package io.github.sgbasaraner.core.usecase;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class GetTask {
    final TaskRepository repository;

    public GetTask(TaskRepository repository) {
        this.repository = repository;
    }

    public Task run(String id) {
        return repository.getTask(id);
    }
}
