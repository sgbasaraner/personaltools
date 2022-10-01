package io.github.sgbasaraner.core.usecase;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import io.github.sgbasaraner.core.model.Task;

public class GetTodaysTasks {
    final GetTasksMatching getTasksMatching;

    public GetTodaysTasks(GetTasksMatching getTasksMatching) {
        this.getTasksMatching = getTasksMatching;
    }

    public List<Task> run() {
        final var today = LocalDate.now();
        return this.getTasksMatching.run(Optional.empty(), Optional.of(today));
    }

}
