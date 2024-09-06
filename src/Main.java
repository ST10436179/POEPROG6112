import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayInitialMenu();
            String choice = scanner.nextLine();
            if (!choice.equals("1")) {
                break;
            }
            processMainMenu();
        }
    }

    private static void displayInitialMenu() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("***************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
    }

    private static void displayMainMenu() {
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application.");
    }

    private static void processMainMenu() {
        while (true) {
            displayMainMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Student.captureStudent(students, scanner);
                    break;
                case "2":
                    Student.searchStudent(students, scanner);
                    break;
                case "3":
                    Student.deleteStudent(students, scanner);
                    break;
                case "4":
                    Student.studentReport(students);
                    break;
                case "5":
                    Student.exitStudentApplication();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            if (!scanner.nextLine().equals("1")) {
                return;
            }
        }
    }
}
