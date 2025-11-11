public class Student {
    String name;
    int rollNumber;
    double gpa;

    public Student(String name, int rollNumber, double gpa) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return name + " (Roll: " + rollNumber + ", GPA: " + gpa + ")";
    }
}