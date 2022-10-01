package io.github.sgbasaraner.core.usecase;

import java.util.List;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class SearchTasks {
    final TaskRepository repository;

    public SearchTasks(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> run(String stringToMatch) {
        return repository.getTasksMatching(stringToMatch);
    }

}
