package Task2;

import java.util.*;

public class OnlineBankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create two sample accounts
        BankAccount account1 = new BankAccount("12345", "John Doe");
        BankAccount account2 = new BankAccount("54321", "Alice Smith");

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Enter account number:");
                    String accountNumber = scanner.next();
                    System.out.println("Enter owner's name:");
                    String owner = scanner.next();
                    BankAccount newAccount = new BankAccount(accountNumber, owner);
                    System.out.println("Account created successfully.");
                }

                case 2 -> {
                    System.out.println("Enter account number for deposit:");
                    String depositAccountNumber = scanner.next();
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    if (account1.getAccountNumber().equals(depositAccountNumber)) {
                        account1.deposit(depositAmount);
                    } else if (account2.getAccountNumber().equals(depositAccountNumber)) {
                        account2.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                }

                case 3 -> {
                    System.out.println("Enter account number for withdrawal:");
                    String withdrawAccountNumber = scanner.next();
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    if (account1.getAccountNumber().equals(withdrawAccountNumber)) {
                        account1.withdraw(withdrawAmount);
                    } else if (account2.getAccountNumber().equals(withdrawAccountNumber)) {
                        account2.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                }

                case 4 -> {
                    System.out.println("Enter source account number for transfer:");
                    String sourceAccountNumber = scanner.next();
                    System.out.println("Enter target account number for transfer:");
                    String targetAccountNumber = scanner.next();
                    System.out.println("Enter amount to transfer:");
                    double transferAmount = scanner.nextDouble();
                    if (account1.getAccountNumber().equals(sourceAccountNumber)
                            && account2.getAccountNumber().equals(targetAccountNumber)) {
                        account1.transfer(account2, transferAmount);
                    } else if (account2.getAccountNumber().equals(sourceAccountNumber)
                            && account1.getAccountNumber().equals(targetAccountNumber)) {
                        account2.transfer(account1, transferAmount);
                    } else {
                        System.out.println("Invalid account numbers for transfer.");
                    }
                }

                case 5 -> {
                    System.out.println("Select an account to view transaction history (1 or 2):");
                    int accountChoice = scanner.nextInt();
                    BankAccount selectedAccount = (accountChoice == 1) ? account1 : account2;
                    ArrayList<String> transactionHistory = selectedAccount.getTransactionHistory();
                    System.out.println("Transaction History for " + selectedAccount.getAccountNumber());
                    for (String transaction : transactionHistory) {
                        System.out.println(transaction);
                    }
                }

                case 6 -> {
                    System.out.println("Exiting the system.");
                    System.exit(0);
                }

                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
