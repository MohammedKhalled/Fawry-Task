package Model;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean canPay(double amount) {
        return balance >= amount;
    }

    public void pay(double amount) {
        if (!canPay(amount)) throw new IllegalArgumentException("Insufficient balance");
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
