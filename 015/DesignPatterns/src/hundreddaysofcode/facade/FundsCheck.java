package hundreddaysofcode.facade;

public class FundsCheck {

    private double cashInAccount = 1000.00;

    public double getCashInAccount() {
        return cashInAccount;
    }

    public void decreaseCashInAccount(double cashWithdrawn) {
        cashInAccount -= cashWithdrawn;
    }

    public void increaseCashInAccount(double cashDeposited) {
        cashInAccount += cashDeposited;
    }

    public boolean haveEnoughMoney(double cashToWithdrawal) {
        if (cashToWithdrawal > cashInAccount) {
            System.out.println("You don't have enough money");
            System.out.println("Current balance: " + cashInAccount);
            return false;
        } else {
            decreaseCashInAccount(cashToWithdrawal);
            System.out.println("Withdrawal complete. Current balance: " + cashInAccount);
            return true;
        }
    }

    public void makeDeposit(double cashToDeposit) {
        increaseCashInAccount(cashToDeposit);
        System.out.println("Deposit complete. Current balance: " + cashInAccount);
    }
}
