import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;

    private static int accountsCreated = 0;
    private static double totalMoneyStored = 0.0;

    public BankAccount() {
        checkingBalance = savingsBalance = 0.0;
        accountsCreated++;
        accountNumber = generateAccountNumber();
    }

    public static int getAccountsCreated() {
        return accountsCreated;
    }

    public static double getTotalMoneyStored() {
        return totalMoneyStored;
    }

    private String generateAccountNumber() {
        String accountNumber = "";
        char[] digits = new char[10];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (char) (48 + i);
        }
        Random randMachine = new Random();
        for (int i = 0; i < 10; i++) {
            accountNumber += digits[randMachine.nextInt(digits.length)];
        }

        return accountNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Deposits the amount specified into the user's account
     * @param account 'C' for checking or 'S' for savings
     * @param amount The funds to deposit
     */
    public boolean depositFunds(char account, double amount) {
        switch (account) {
            case 'C':
                checkingBalance += amount;
                break;
            case 'S':
                savingsBalance += amount;
                break;
            default:
                return false;
        }

        totalMoneyStored += amount;
        return true;
    }

    public boolean withdrawFunds(char account, double amount) {
        switch (account) {
            case 'C':
                if (checkingBalance - amount > 0.0) {
                    checkingBalance -= amount;
                }
                else {
                    return false;
                }
                break;
            case 'S':
                if (savingsBalance - amount > 0.0) {
                    savingsBalance -= amount;
                }
                else {
                    return false;
                }
                break;
            default:
                return false;
        }

        totalMoneyStored -= amount;
        return true;
    }

    public void displayTotalMoney() {
        System.out.format("Checking Balance: $%.2f\n", checkingBalance);
        System.out.format("Savings Balance: $%.2f\n", savingsBalance);
        System.out.format("Total Balance: $%.2f\n\n", checkingBalance + savingsBalance);
    }
}