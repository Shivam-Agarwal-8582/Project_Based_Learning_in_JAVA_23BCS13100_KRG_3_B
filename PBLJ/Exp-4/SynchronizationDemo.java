// File: BankAccount.java
class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + " | Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - Insufficient funds!");
        }
    }

    public int getBalance() {
        return balance;
    }
}

// File: SynchronizationDemo.java
public class SynchronizationDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) account.deposit(500);
        }, "Depositor");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) account.withdraw(300);
        }, "Withdrawer");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
