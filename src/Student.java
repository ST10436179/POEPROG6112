import java.util.ArrayList;
import java.util.Scanner;

class Student {
    // Student properties
    public String studentId;
    public String name;
    public int age;
    public String email;
    public String course;


    // Student Constructor with the student properties
    public Student(String studentId, String name, int age, String email, String course) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }


    // capture student details method
    public static void captureStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("************************");
        System.out.print("Enter the student id: ");

        // age input
        String studentId = scanner.nextLine();
        // name input
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age = 0;

        /// while loop validation for age property
        while (true) {
            System.out.print("Enter the student age: ");

            /// TRY Catch exemption to catch error for age
            try {
                age = Integer.parseInt(scanner.nextLine());

                /// If age is less than 16
                if (age < 16) {
                    System.out.println("You have entered an incorrect student age!!!");
                    System.out.println("Please re-enter the student age >>");
                } else {
                    break;
                }

                /// Catch if is age is not a number
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect student age!!!");
                System.out.println("Please re-enter the student age >>");
            }
        }

        // Enter email
        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        // Enter Course
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        // Create a new class constructor for a student
        students.add(new Student(studentId, name, age, email, course));
        System.out.println("Student details have been successfully saved.");
    }

    //  Search a Student method
    public static void searchStudent(ArrayList<Student> students, Scanner scanner) {
        // Enter student ID
        System.out.print("Enter the id to search: ");
        String searchId = scanner.nextLine();


        /// Loop through each student in the students array
        for (Student student : students) {
            /// check if entered ID is equal to Student ID
            if (student.studentId.equals(searchId)) {
                // Print Student details
                System.out.println("----------------------------------");
                System.out.println("STUDENT ID: " + student.studentId);
                System.out.println("STUDENT NAME: " + student.name);
                System.out.println("STUDENT AGE: " + student.age);
                System.out.println("STUDENT EMAIL: " + student.email);
                System.out.println("STUDENT COURSE: " + student.course);
                System.out.println("---------------------------------------");
                return;
            }
        }

        /// IF Student ID IS NOT Found

        System.out.println("----------------------------------");
        System.out.println("Student with Student Id: " + searchId + " was not found!");
        System.out.println("----------------------------------");
    }


    /// Delete student method
    public static void deleteStudent(ArrayList<Student> students, Scanner scanner) {
        // enter ID
        System.out.print("Enter the student id to delete: ");
        String deleteId = scanner.nextLine();


        // Loop Through Students array for each student
        for (int i = 0; i < students.size(); i++) {
            /// Check Student ID If is == to StudentID
            if (students.get(i).studentId.equals(deleteId)) {
                System.out.print("Are you sure you want to delete student " + deleteId + " from the system? Yes (y) to delete No (n) to cancel: ");
                String confirmation = scanner.nextLine().toLowerCase();
                // If Y is entered then proceed to delete student
                if (confirmation.equals("y")) {
                    students.remove(i);
                    System.out.println("--------------------------------------------");
                    System.out.println("Student with STUDENT ID: " + deleteId + " WAS DELETED!!");
                    System.out.println("--------------------------------------------");

                    /// Else cancel
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }

        /// If ID is NOt found

        System.out.println("Student with Student Id: " + deleteId + " was not found!");
    }


    // Student Report Method
    public static void studentReport(ArrayList<Student> students) {
        // Loop Though the array of students to display
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("STUDENT " + (i + 1));
            System.out.println("---------------------------------------");
            System.out.println("STUDENT ID: " + student.studentId);
            System.out.println("STUDENT NAME: " + student.name);
            System.out.println("STUDENT AGE: " + student.age);
            System.out.println("STUDENT EMAIL: " + student.email);
            System.out.println("STUDENT COURSE: " + student.course);
            System.out.println("---------------------------------------");
        }
    }


    /// This is a helper method to exit application
    public static void exitStudentApplication() {
        System.out.println("Exiting application.");
        System.exit(0);
    }
}