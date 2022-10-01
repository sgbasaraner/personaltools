package io.github.sgbasaraner.core.usecase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.model.Task.Status;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class GetTasksMatching {
    final TaskRepository repository;

    public GetTasksMatching(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> run(Optional<Status> status, Optional<LocalDate> deadline) {
        final var set = new HashSet<Task>();

        status.map(s -> repository.getTasksByStatus(s))
                .map(l -> set.addAll(l));

        deadline.map(d -> repository.getTasksByDeadlineDate(d))
                .map(l -> set.addAll(l));

        return new ArrayList<>(set);
    }
}
