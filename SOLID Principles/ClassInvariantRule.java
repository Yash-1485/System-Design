class BankAccount {
    double balance;

    // Balance Can't Be Negetive
    BankAccount(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount Can't Be Less Than 0, Inout was " + amount);
        } else if (this.balance - amount < 0) {
            throw new Exception("Insufficient Balance, Current Balance Is Only " + this.balance);
        }

        System.out.println(amount + " Withdrawed Successfully");
        this.balance -= amount;
        System.out.println("Current Balance Is Now: " + this.balance);
    }
}

class CheatAccount extends BankAccount {
    CheatAccount(double balance) {
        super(balance);
    }

    void withdraw(double amount) {
        System.out.println(amount + " Withdrawed Successfully");
        this.balance -= amount;
        System.out.println("Current Balance Is Now: " + this.balance);
    }
}

public class ClassInvariantRule {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        // BankAccount account = new CheatAccount(1000);
        BankAccount account = new CheatAccount(0);

        try {
            account.withdraw(100); // Rule Broke
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
