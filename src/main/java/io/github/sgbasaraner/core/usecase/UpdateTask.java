package io.github.sgbasaraner.core.usecase;

import java.time.LocalDateTime;

import javax.ws.rs.BadRequestException;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class UpdateTask {
    final TaskRepository repository;

    public UpdateTask(TaskRepository repository) {
        this.repository = repository;
    }

    public Task run(Task task) {
        final var currentTask = repository.getTask(task.id);
        return repository.updateTask(validate(currentTask, task));
    }

    private Task validate(Task currentTask, Task requestedUpdate) {
        if (requestedUpdate.deadline.isPresent() && requestedUpdate.deadline.get().isBefore(LocalDateTime.now())) {
            throw new BadRequestException("Deadline must be in the future");
        }

        return requestedUpdate;
    }
}
