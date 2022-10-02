package io.github.sgbasaraner.core.usecase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.ws.rs.BadRequestException;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.model.Task.Status;
import io.github.sgbasaraner.core.repository.TaskRepository;

public class CreateTask {
    final TaskRepository repository;

    public CreateTask(TaskRepository repository) {
        this.repository = repository;
    }

    public Task run(Task task) {
        return repository.createTask(validate(task));
    }

    private Task validate(Task task) {
        if (task.title == null || task.title.isEmpty()) {
            throw new BadRequestException("Task title can't be empty.");
        }

        if (task.deadline.isPresent() && task.deadline.get().isBefore(LocalDateTime.now())) {
            throw new BadRequestException("Deadline must be in the future");
        }

        return new Task(UUID.randomUUID(), task.title, task.notes, task.deadline, Status.Ready);
    }
}
