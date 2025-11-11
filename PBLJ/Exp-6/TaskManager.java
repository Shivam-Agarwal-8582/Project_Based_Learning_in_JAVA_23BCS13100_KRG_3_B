// File: Task.java

// File: TaskManager.java
import java.util.*;

public class TaskManager {
    private Collection<Task> tasks = new ArrayList<>();
    private HashSet<String> uniqueDescriptions = new HashSet<>();

    public void addTask(String description, int priority) {
        if (uniqueDescriptions.contains(description)) {
            System.out.println("Duplicate task ignored: " + description);
            return;
        }
        tasks.add(new Task(description, priority));
        uniqueDescriptions.add(description);
    }

    public void sortByPriority() {
        List<Task> sortedList = new ArrayList<>(tasks);
        sortedList.sort(Comparator.comparingInt(t -> t.priority));
        System.out.println("Sorted Tasks by Priority:");
        sortedList.forEach(System.out::println);
    }

    public void printAllTasks() {
        System.out.println("All Tasks:");
        tasks.forEach(System.out::println);
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();

        tm.addTask("Write report", 3);
        tm.addTask("Fix bugs", 1);
        tm.addTask("Team meeting", 2);
        tm.addTask("Update docs", 4);
        tm.addTask("Email client", 1);
        tm.addTask("Fix bugs", 5); // Duplicate

        tm.printAllTasks();
        tm.sortByPriority();

        // Bonus - concurrent additions (no sync)
        Runnable adder = () -> tm.addTask("Quick task " + Thread.currentThread().getName(), 2);
        new Thread(adder, "Thread-A").start();
        new Thread(adder, "Thread-B").start();
    }
}
