package pl.pjatk.s36691.gui.zad40;

import java.util.Arrays;

public class Bank {
    private final int [] accounts;

    public Bank(int n, int initialBalance) {
        this.accounts = new int[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = initialBalance;
        }
    }

    public synchronized int getTotalBalance() {
        return Arrays.stream(accounts).sum();
    }

    public int getBalance(int index) {
        return accounts[index];
    }

    public void deposit(int account, int amount) {
        accounts[account] += amount;
    }

    public void withdraw(int account, int amount) {
        accounts[account] -= amount;
    }

    public boolean sufficientFunds(int account, int amount) {
        return accounts[account] >= amount;
    }

    public synchronized void transfer(int from, int to, int amount) {
        if (!sufficientFunds(from, amount)) {
            return;
        }
        withdraw(from, amount);
        deposit(to, amount);
    }
}
