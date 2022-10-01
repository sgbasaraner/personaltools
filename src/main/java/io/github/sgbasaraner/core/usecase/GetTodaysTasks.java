package io.github.sgbasaraner.core.usecase;

import java.time.LocalDate;
import java.util.List;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class GetTodaysTasks {
    final TaskRepository repository;

    public GetTodaysTasks(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> run() {
        final var today = LocalDate.now();
        return repository.getTasksByDeadlineDate(today);
    }

}
