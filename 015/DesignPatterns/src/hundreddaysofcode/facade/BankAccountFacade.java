package hundreddaysofcode.facade;

public class BankAccountFacade {

    private int accountNumber;
    private int securityNumber;

    private AccountNumberCheck accountChecker;
    private SecurityCodeCheck securityChecker;
    private FundsCheck fundsChecker;

    private WelcomeToBank bankWelcome;

    public BankAccountFacade(int newAccountNumber, int newSecurityCode) {
        accountNumber = newAccountNumber;
        securityNumber = newSecurityCode;

        accountChecker = new AccountNumberCheck();
        securityChecker = new SecurityCodeCheck();
        fundsChecker = new FundsCheck();
        bankWelcome = new WelcomeToBank();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getSecurityNumber() {
        return securityNumber;
    }

    public void withdrawCash(double cashToGet) {
        if (accountChecker.accountActive(accountNumber) &&
            securityChecker.isCodeCorrect(securityNumber) &&
            fundsChecker.haveEnoughMoney(cashToGet)) {
            System.out.println("Transaction complete");
        } else {
            System.out.println("Transaction failed");
        }
    }

    public void depositCash(double cashToDeposit) {
        if (accountChecker.accountActive(accountNumber) &&
            securityChecker.isCodeCorrect(securityNumber)) {
            fundsChecker.makeDeposit(cashToDeposit);
            System.out.println("Transaction complete");
        } else {
            System.out.println("Transaction failed");
        }
    }
}
