package q1;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // Create a collection of type Student
        SortedGroup<Student> studentGroup = new SortedGroup<>();

        // Add some students to the collection
        studentGroup.add(new Student("Aviv Baruch", "209044361", 01));
        studentGroup.add(new Student("David Levy", "123456789", 85));
        studentGroup.add(new Student("Sarah Cohen", "987654321", 92));
        studentGroup.add(new Student("Michael Levi", "567891234", 55));
        studentGroup.add(new Student("Rachel Ben-David", "234567890", 95));
        studentGroup.add(new Student("Daniel Avraham", "876543219", 70));
        studentGroup.add(new Student("Lea Cohen", "543210987", 32));
        studentGroup.add(new Student("Yosef Levi", "987654320", 20));
        studentGroup.add(new Student("Ruth Shalom", "123456780", 88));
        studentGroup.add(new Student("Benjamin Yitzhak", "135792468", 75));
        studentGroup.add(new Student("Yosef Levi", "987654320", 20));
        studentGroup.add(new Student("Tamar Levi", "987654322", 93));

        // Print the student information before removing elements
        System.out.println("Students before removing elements:");
        for (Student student : studentGroup.getElements()) {
            System.out.println(student);
        }

        // Remove a student
        int removedCount = studentGroup.remove(new Student("Yosef Levi", "987654320", 20));
        System.out.println("\nRemoved " + removedCount + " students.");

        // Print the student information after removing elements
        System.out.println("\nStudents after removing elements:");
        for (Student student : studentGroup.getElements()) {
            System.out.println(student);
        }

        // Reduce the collection based on grade
        SortedGroup<Student> reducedGroup = CollectionReducer.reduce(studentGroup, new Student("", "", 60));

        // Print the reduced student information
        System.out.println("\nStudents after reducing collection:");
        for (Student student : reducedGroup.getElements()) {
            System.out.println(student);
        }

        //Original group afterward reducing collection (to demonstrate the original group wasn't harmed)
        System.out.println("\nOriginal Collection:");
        for (Student student : studentGroup.getElements()) {
            System.out.println(student);
        }
    }
}
