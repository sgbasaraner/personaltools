package io.github.sgbasaraner;

import io.github.sgbasaraner.core.repository.TaskRepository;
import io.github.sgbasaraner.platform.DI;
import io.github.sgbasaraner.platform.datasource.InMemoryTaskDataSource;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        System.out.println("Running main method");
        final var ds = new InMemoryTaskDataSource();
        DI.initStatic(new TaskRepository(ds));
        Quarkus.run(args);
    }
}
