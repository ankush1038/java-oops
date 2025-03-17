// Abstract class: BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// Interface: Loanable
interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

// Subclass: CurrentAccount
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for current accounts
    }

    @Override
    public void applyForLoan() {
        System.out.println("Loan application submitted for account: " + getAccountNumber());
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; // Example eligibility calculation
    }
}

// Main class to test Banking System
public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SB12345", "Rahul Sharma", 50000, 4);
        CurrentAccount current = new CurrentAccount("CA67890", "Priya Verma", 75000, 20000);

        savings.displayDetails();
        System.out.println("Calculated Interest: " + savings.calculateInterest());
        System.out.println();

        current.displayDetails();
        current.applyForLoan();
        System.out.println("Loan Eligibility: " + current.calculateLoanEligibility());
    }
}
