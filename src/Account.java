// Account.java
public class Account {
    // Private fields to enforce information hiding
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor to initialize account details
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Getters to access private fields
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            // Update balance account
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            // Handle invalid amounts
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            // Deduct from balance
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            // if amount withdrew is more than in the account
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Method to display account details in the console
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
}
