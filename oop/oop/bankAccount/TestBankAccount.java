public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount acct = new BankAccount();
        BankAccount acct2 = new BankAccount();

        acct.displayTotalMoney();
        System.out.println(acct.getCheckingBalance());
        System.out.println(acct.getSavingsBalance());

        acct.depositFunds('C', 502.95);
        acct2.depositFunds('S', 1000.99);

        acct.displayTotalMoney();
        acct2.displayTotalMoney();

        System.out.println(acct2.getAccountNumber());

        System.out.println(BankAccount.getAccountsCreated());
        System.out.println(BankAccount.getTotalMoneyStored());

        if (!acct.withdrawFunds('S', 10)) {
            System.out.println("Insufficient funds.");
        }

        acct.withdrawFunds('C', 500.24);
        acct.displayTotalMoney();
    }
}
