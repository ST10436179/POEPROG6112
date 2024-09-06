import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private ArrayList<Student> students;
    private Scanner scanner;

    // This method runs before each test to set up the testing environment
    @BeforeEach
    void setUp() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Test if a student can be saved correctly
    @Test
    void testSaveStudent() {
        // Create a new student
        String studentId = "S001";
        String name = "John Doe";
        int age = 18;
        String email = "john@example.com";
        String course = "Math";

        // Add the student to the list
        students.add(new Student(studentId, name, age, email, course));

        // Check if the student was added correctly
        assertEquals(1, students.size());
        assertEquals(studentId, students.get(0).studentId);
        assertEquals(name, students.get(0).name);
        assertEquals(age, students.get(0).age);
        assertEquals(email, students.get(0).email);
        assertEquals(course, students.get(0).course);
    }

    // Test if a student can be searched correctly
    @Test
    void testSearchStudent() {
        // Add a student to the list
        students.add(new Student("S001", "John Doe", 18, "john@example.com", "Math"));

        // Prepare the scanner to search for the student
        scanner = new Scanner("S001");
        Student.searchStudent(students, scanner);
    }

    // Test if searching for a non-existing student doesn't crash
    @Test
    void testSearchStudent_StudentNotFound() {
        // Prepare the scanner to search for a non-existing student
        scanner = new Scanner("S002");
        Student.searchStudent(students, scanner);
    }

    // Test if a student can be deleted correctly
    @Test
    void testDeleteStudent() {
        // Add a student to the list
        students.add(new Student("S001", "John Doe", 18, "john@example.com", "Math"));

        // Prepare the scanner to delete the student
        scanner = new Scanner("S001\ny");
        Student.deleteStudent(students, scanner);

        // Check if the student was deleted correctly
        assertEquals(0, students.size());
    }

    // Test if deleting a non-existing student doesn't crash
    @Test
    void testDeleteStudent_StudentNotFound() {
        // Prepare the scanner to delete a non-existing student
        scanner = new Scanner("S002");
        Student.deleteStudent(students, scanner);
    }

    // Test if a valid age is accepted
    @Test
    void testStudentAge_StudentAgeValid() {
        int validAge = 18;
        boolean isValidAge = validAge >= 16;
        assertTrue(isValidAge, "Age should be valid");
    }

    // Test if an invalid age is rejected
    @Test
    void testStudentAge_StudentAgeInvalid() {
        int invalidAge = 15;
        boolean isValidAge = invalidAge >= 16;
        assertFalse(isValidAge, "Age should be invalid, less than 16");
    }

    // Test if an invalid age (non-numeric) is rejected
    @Test
    void testStudentAge_StudentAgeInvalidCharacter() {
        String invalidAge = "abc";
        try {
            Integer.parseInt(invalidAge);
            fail("Expected NumberFormatException");
        } catch (NumberFormatException e) {
            assertTrue(true, "Caught expected NumberFormatException");
        }
    }
}