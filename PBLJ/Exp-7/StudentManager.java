// File: Student.java


// File: StudentManager.java
import java.util.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, int rollNumber, double gpa) {
        boolean exists = students.stream().anyMatch(s -> s.rollNumber == rollNumber);
        if (exists) {
            System.out.println("Duplicate roll number: " + rollNumber);
            return;
        }
        students.add(new Student(name, rollNumber, gpa));
    }

    public void searchByName(String name) {
        students.stream()
                .filter(s -> s.name.equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    public void removeByRollNumber(int rollNumber) {
        students.removeIf(s -> s.rollNumber == rollNumber);
    }

    public void sortByGpaDescending() {
        students.sort((a, b) -> Double.compare(b.gpa, a.gpa));
    }

    public void displayTop3() {
        sortByGpaDescending();
        System.out.println("Top 3 Students:");
        students.stream().limit(3).forEach(System.out::println);
    }

    public void displayAll() {
        students.forEach(System.out::println);
    }

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.addStudent("Alice", 1, 8.9);
        sm.addStudent("Bob", 2, 9.3);
        sm.addStudent("Charlie", 3, 7.8);
        sm.addStudent("David", 4, 9.5);
        sm.addStudent("Eve", 5, 6.7);
        sm.addStudent("Frank", 6, 8.2);
        sm.addStudent("Grace", 7, 9.1);
        sm.addStudent("Heidi", 8, 8.8);

        System.out.println("All Students:");
        sm.displayAll();

        System.out.println("\nSearch by name 'bob':");
        sm.searchByName("bob");

        System.out.println("\nRemove Roll 5:");
        sm.removeByRollNumber(5);
        sm.displayAll();

        System.out.println("\nSorted by GPA Descending:");
        sm.sortByGpaDescending();
        sm.displayAll();

        System.out.println();
        sm.displayTop3();
    }
}
