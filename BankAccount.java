/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;

/**
 *
 * @author Asus
 */
import java.util.*;
public class BankAccount {
  

    private final String accountNumber;
    private final String owner;
    private double balance;
    private final ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            targetAccount.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to " + targetAccount.getAccountNumber());
        } else {
            System.out.println("Insufficient funds for the transfer.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\nOwner: " + owner + "\nBalance: $" + balance;
    }
}



