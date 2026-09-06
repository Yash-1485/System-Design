public class HistoryConstraintRule {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        BankAccount account = new FixedDepositAccount(1000);

        try {
            account.withdraw(100); // Throws Exception, Rule Broked
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    // Account Allow To Withdraw Some Amount
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

class FixedDepositAccount extends BankAccount {
    FixedDepositAccount(double balance) {
        super(balance);
    }

    @Override
    void withdraw(double amount) throws Exception {
        throw new Exception("Amount Can't Be Withdrawed Without Approval");
    }
}