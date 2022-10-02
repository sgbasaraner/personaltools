package io.github.sgbasaraner.platform.datasource;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import org.apache.commons.lang3.StringUtils;

import io.github.sgbasaraner.core.datasource.TaskDataSource;
import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.model.Task.Status;

public class InMemoryTaskDataSource implements TaskDataSource {

    private final Map<UUID, Task> taskMap = new ConcurrentHashMap<>();

    @Override
    public Task getTask(UUID id) {
        final var task = taskMap.get(id);

        if (task == null)
            throw new NotFoundException();

        return task;
    }

    @Override
    public Task createTask(Task task) {
        if (taskMap.containsKey(task.id)) {
            throw new BadRequestException("Duplicate task not allowed.");
        }

        return taskMap.put(task.id, task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksByStatus(Status status) {
        return taskMap.values().stream().filter(t -> t.status.equals(status)).collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksByDeadlineDate(LocalDate deadlineDate) {
        return taskMap.values().stream()
                .filter(t -> t.deadline.isPresent())
                .filter(t -> t.deadline.get().toLocalDate().equals(deadlineDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksMatching(String string) {
        return taskMap.values().stream()
                .filter(t -> StringUtils.containsIgnoreCase(t.title, string)
                        || StringUtils.containsIgnoreCase(t.notes, string))
                .collect(Collectors.toList());
    }

    @Override
    public Task updateTask(Task task) {
        return taskMap.put(task.id, task);
    }

}
