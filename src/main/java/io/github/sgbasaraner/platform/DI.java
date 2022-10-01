package io.github.sgbasaraner.platform;

import io.github.sgbasaraner.core.repository.TaskRepository;

public class DI {
    public final TaskRepository taskRepository;

    private DI(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public static DI instance;

    public static void initStatic(TaskRepository repository) {
        if (instance != null) {
            throw new IllegalCallerException();
        }

        instance = new DI(repository);
    }
}
