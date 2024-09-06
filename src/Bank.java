// Bank.java
import java.util.Scanner;

public class Bank {
    // Array to hold multiple accounts
    private Account[] accounts;
    // Counter to keep track of the number of accounts
    private int accountCount;

    // Constructor to initialize the bank with a given size for the account array
    public Bank(int size) {
        // Initialize array with specified size
        accounts = new Account[size];
        // Initialize account counter
        accountCount = 0;
    }

    // Method to add a new account to the bank
    public void addAccount(Account account) {
        // Check if there's space in the array
        if (accountCount < accounts.length) {
            // Add account and increment counter
            accounts[accountCount++] = account;
            System.out.println("Account created successfully.");
        } else {
            // Handle when the bank has reached its maximum
            System.out.println("Bank is at full capacity.");
        }
    }

    // Method to find an account by its account number
    public Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                // Return the account if found
                return accounts[i];
            }
        }
        // Return null if account not found
        return null;
    }

    // Main method to run the banking application and handle user interactions
    public void run() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        // Main method application loop
        while (true) {
            // Display menu options
            System.out.println("\nBank Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Apply Interest");
            System.out.println("5. View Account");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            // Get user choice
            int choice = scanner.nextInt();
            // Consume newline
            scanner.nextLine();

            // Handle menu choice
            switch (choice) {
                case 1:
                    // Create a new account
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter Interest Rate for Savings Account: ");
                    double interestRate = scanner.nextDouble();
                    SavingsAccount account = new SavingsAccount(accountNumber, accountHolderName, balance, interestRate);
                    // Add account to the bank
                    addAccount(account);
                    break;
                case 2:
                    // Deposit money into an existing account
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    Account acc = findAccount(accountNumber);
                    if (acc != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        // Deposit amount To The Account
                        acc.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    // Withdraw money from an existing account
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    acc = findAccount(accountNumber);
                    if (acc != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        // Withdraw amount
                        acc.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    // Apply interest to a savings account
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    acc = findAccount(accountNumber);
                    if (acc instanceof SavingsAccount) {
                        // Apply interest
                        ((SavingsAccount) acc).applyInterest();
                    } else {
                        System.out.println("Account not found or not a savings account.");
                    }
                    break;
                case 5:
                    // View details of an existing account
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    acc = findAccount(accountNumber);
                    if (acc != null) {
                        // Display account information of the user
                        acc.displayAccountDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 6:
                    // Exit the application
                    System.out.println("Exiting...");
                    scanner.close(); // Close the scanner resource
                    return; // Exit the loop
                default:
                    // When the user enters an invalid input
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Main entry point of the application
    public static void main(String[] args) {
        // Create a bank with a maximum for 5 accounts
        Bank bank = new Bank(5);
        // Run the bank application, Refactored main method
        bank.run();
    }
}
