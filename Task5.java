import java.util.*;

class BankAccount {
    private int balance;

    BankAccount() {
        balance = 0;
    }

    void deposit(int amount) {
        balance += amount;
    }

    void withdraw(int amount) {
        balance -= amount;
    }

    int getBalance() {
        return balance;
    }
}

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        BankAccount account = new BankAccount();

        for (int i = 0; i < n; i++) {
            String operation = sc.next();
            int amount = sc.nextInt();

            if (operation.equals("Deposit")) {
                account.deposit(amount);
            } else if (operation.equals("Withdraw")) {
                account.withdraw(amount);
            }
        }

        System.out.println(account.getBalance());

        sc.close();
    }
}