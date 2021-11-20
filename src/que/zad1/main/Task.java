package que.zad1.main;

import java.util.Objects;

public class Task implements Comparable<Task> {

    private String name;
    private String description;
    private Priority priority;

    public Task(String name, String description, Priority priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description) && priority == task.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, priority);
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }

    @Override
    public int compareTo(Task o) {
        return priority.compareTo(o.priority);
    }
}
