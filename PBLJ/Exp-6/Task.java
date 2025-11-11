public class Task {
    String description;
    Integer priority;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority; // Autoboxing
    }

    @Override
    public String toString() {
        return "[Task: " + description + ", Priority: " + priority + "]";
    }
}
