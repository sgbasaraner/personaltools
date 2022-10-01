package io.github.sgbasaraner.core.model;

import java.time.LocalDateTime;

public class Task {

    final String id;
    final String title;
    final String notes;
    final LocalDateTime deadline;

    public Task(String id, String title, String notes, LocalDateTime deadline) {
        this.id = id;
        this.title = title;
        this.notes = notes;
        this.deadline = deadline;
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
