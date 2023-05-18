package q1;

import java.util.Objects;

/**
 * Represents a student with a name, ID, and grade.
 */
public class Student implements Comparable<Student> {
    private String name;
    private String id;
    private int grade;

    /**
     * Constructs a Student object with the specified name, ID, and grade.
     *
     * @param name  The name of the student.
     * @param id    The ID of the student.
     * @param grade The grade of the student.
     */
    public Student(String name, String id, int grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    /**
     * Returns the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the student.
     *
     * @return The ID of the student.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the grade of the student.
     *
     * @return The grade of the student.
     */
    public int getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(id, other.id) &&
                grade == other.grade;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.grade, other.grade);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Grade: " + grade;
    }
}
