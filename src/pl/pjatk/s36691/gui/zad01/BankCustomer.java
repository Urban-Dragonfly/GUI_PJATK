package pl.pjatk.s36691.gui.zad01;

public class BankCustomer {
    private Person person;
    private Account account;

    public BankCustomer(Person person) {
        this.person = person;
        this.account = new Account();
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Klient: " + person + " stan konta " + account;
    }
}
