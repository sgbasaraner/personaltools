package io.github.sgbasaraner.platform.controller;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import io.github.sgbasaraner.core.model.Task;
import io.github.sgbasaraner.core.usecase.CreateTask;
import io.github.sgbasaraner.core.usecase.GetTask;
import io.github.sgbasaraner.core.usecase.GetTasksMatching;
import io.github.sgbasaraner.core.usecase.SearchTasks;
import io.github.sgbasaraner.platform.DI;

@Path("/task")
public class TaskResource {

    private static final Logger LOG = Logger.getLogger(TaskResource.class);

    private final GetTask getTask = new GetTask(DI.instance.taskRepository);
    private final GetTasksMatching getTasksMatching = new GetTasksMatching(DI.instance.taskRepository);
    private final SearchTasks searchTasks = new SearchTasks(DI.instance.taskRepository);
    private final CreateTask createTask = new CreateTask(DI.instance.taskRepository);

    @GET
    @Path("/{id}")
    public Task getById(@RestPath String id) {
        LOG.info("Received single task request, id: " + id);

        final UUID uuid;
        if (id == null)
            throw new BadRequestException();
        try {
            uuid = UUID.fromString(id);
        } catch (Exception e) {
            throw new BadRequestException();
        }

        try {
            final var task = getTask.run(uuid);
            return task;
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @GET
    public List<Task> getMatching(
            @RestQuery String status,
            @RestQuery String deadline,
            @RestQuery String query) {
        // TODO
        if (query != null) {
            LOG.info("Received query request, string: " + query);
            return Collections.emptyList();
        }

        LOG.info("Received multiple task request, status: " + status + ", deadline: " + deadline);
        return Collections.emptyList();
    }

    @PUT
    public Task createTask(Task task) {
        // TODO
        LOG.info("Received create task request, id: " + task.id);
        return null;
    }

    @POST
    public Task updateTask(Task task) {
        // TODO
        LOG.info("Received update task request, id: " + task.id);
        return null;
    }

}