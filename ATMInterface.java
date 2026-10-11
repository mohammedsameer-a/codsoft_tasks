import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(double openingBalance) {
        balance = openingBalance;
    }

    double getBalance() {
        return balance;
    }

    boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.00); // sample starting balance
        boolean running = true;
        System.out.println("=== ATM Interface ===");

        while (running) {
            System.out.println("\n1. Check balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Choose an option: ");
            if (!input.hasNextInt()) {
                System.out.println("Please enter 1, 2, 3, or 4.");
                input.next();
                continue;
            }
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("Current balance: $%.2f%n", account.getBalance());
                    break;
                case 2:
                    System.out.print("Amount to deposit: $");
                    double deposit = readAmount(input);
                    if (account.deposit(deposit)) System.out.println("Deposit successful.");
                    else System.out.println("Deposit amount must be greater than zero.");
                    break;
                case 3:
                    System.out.print("Amount to withdraw: $");
                    double withdrawal = readAmount(input);
                    if (account.withdraw(withdrawal)) System.out.println("Withdrawal successful.");
                    else System.out.println("Withdrawal must be positive and cannot exceed your balance.");
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 4.");
            }
        }
        input.close();
    }

    private static double readAmount(Scanner input) {
        while (!input.hasNextDouble()) {
            System.out.print("Enter a valid amount: $");
            input.next();
        }
        return input.nextDouble();
    }
}

