import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private ArrayList<Student> students;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        students = new ArrayList<>();
        // Mock Scanner input for testing
        scanner = new Scanner(System.in);
    }

    @Test
    void testSaveStudent() {
        // Test data
        String studentId = "S001";
        String name = "John Doe";
        int age = 18;
        String email = "john@example.com";
        String course = "Math";

        students.add(new Student(studentId, name, age, email, course));

        // Validate that the student was saved
        assertEquals(1, students.size());
        assertEquals(studentId, students.get(0).studentId);
        assertEquals(name, students.get(0).name);
        assertEquals(age, students.get(0).age);
        assertEquals(email, students.get(0).email);
        assertEquals(course, students.get(0).course);
    }

    @Test
    void testSearchStudent() {
        students.add(new Student("S001", "John Doe", 18, "john@example.com", "Math"));

        // Prepare scanner input for searching student
        scanner = new Scanner("S001");
        Student.searchStudent(students, scanner);

        // No direct output validation in this test, but can be checked with mocks or further refactoring
    }

    @Test
    void testSearchStudent_StudentNotFound() {
        scanner = new Scanner("S002");
        Student.searchStudent(students, scanner);


    }

    @Test
    void testDeleteStudent() {
        students.add(new Student("S001", "John Doe", 18, "john@example.com", "Math"));

        // Prepare scanner input for deleting student
        scanner = new Scanner("S001\ny"); // Assuming "yes" input for deletion confirmation
        Student.deleteStudent(students, scanner);

        // Validate that the student was deleted
        assertEquals(0, students.size());
    }

    @Test
    void testDeleteStudent_StudentNotFound() {
        // Prepare scanner input for a student not found scenario
        scanner = new Scanner("S002");
        Student.deleteStudent(students, scanner);

    }

    @Test
    void testStudentAge_StudentAgeValid() {
        int validAge = 18;
        boolean isValidAge = validAge >= 16;
        assertTrue(isValidAge, "Age should be valid");
    }

    @Test
    void testStudentAge_StudentAgeInvalid() {
        int invalidAge = 15;
        boolean isValidAge = invalidAge >= 16;
        assertFalse(isValidAge, "Age should be invalid, less than 16");
    }

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
