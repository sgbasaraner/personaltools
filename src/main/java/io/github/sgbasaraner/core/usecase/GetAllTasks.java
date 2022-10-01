package io.github.sgbasaraner.core.usecase;

import java.util.List;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class GetAllTasks {
    final TaskRepository repository;

    public GetAllTasks(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> run() {
        return repository.getAllTasks();
    }
}
