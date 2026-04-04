package pl.pjatk.s36691.gui.zad01;

public class Account {

    private double balance;
    private static double interestRate;

    // Constructors
    public Account() {
        balance = 0;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    // Basic operations
    public boolean deposit(double amount) {
        if (amount < 0) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount < 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    public boolean transfer(Account toAccount, double amount) {
        if (withdraw(amount)) {
            if (toAccount.deposit(amount)) {
                return true;
            }
            deposit(amount);
            return false;
        }
        return false;
    }

    // Interest Rate Operations
    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public void addInterest() {
        balance += balance * interestRate / 100;
    }

    @Override
    public String toString() {
        return String.valueOf(balance);
    }
}
