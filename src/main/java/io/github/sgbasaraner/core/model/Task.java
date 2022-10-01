package io.github.sgbasaraner.core.model;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class Task {

    public enum Status {
        Ready,
        Done,
        InProgress
    }

    public final UUID id;
    public final String title;
    public final String notes;
    public final Status status;
    public final Optional<LocalDateTime> deadline;

    public Task(UUID id, String title, String notes, Optional<LocalDateTime> deadline, Status status) {
        this.id = id;
        this.title = title;
        this.notes = notes;
        this.deadline = deadline;
        this.status = status;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
