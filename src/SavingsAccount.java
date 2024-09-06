// SavingsAccount.java
public class SavingsAccount extends Account {
    // Interest rate specific to savings accounts
    private double interestRate;

    // Constructor that calls the base class constructor using super()
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        // Initialize base class fields from the parent class
        super(accountNumber, accountHolderName, initialBalance);
        // Initialize interest rate
        this.interestRate = interestRate;
    }

    // Method to apply interest to the account balance
    public void applyInterest() {
        // Calculate interest
        double interest = getBalance() * interestRate / 100;
        // Deposit the interest to the balance
        deposit(interest);
        // Output the applied interest
        System.out.println("Interest applied: $" + interest);
    }
}
