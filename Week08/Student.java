import java.util.Comparator;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String lastName;
    private double gpa;

    public Student(int id, String name, String lastName, double gpa) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public double getGpa() { return gpa; }

    // Default comparison by ID
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    // Comparators
    public static Comparator<Student> byId() {
        return Comparator.comparingInt(Student::getId);
    }

    public static Comparator<Student> byName() {
        return Comparator.comparing(Student::getName);
    }

    public static Comparator<Student> byLastName() {
        return Comparator.comparing(Student::getLastName);
    }

    public static Comparator<Student> byGpa() {
        return Comparator.comparingDouble(Student::getGpa).reversed();
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s %s, GPA: %.2f", 
            id, name, lastName, gpa);
    }
}
