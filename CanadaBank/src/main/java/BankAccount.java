class BankAccount {
    private BankClient client;
    private double balanceUsd;
    private int pin;
    private String accountNumber;

    public BankAccount(BankClient client, double balanceUsd, int pin, String accountNumber) {
        this.client = client;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    public BankClient getClient() {
        return client;
    }

    public double getBalanceUsd() {
        return balanceUsd;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amountUsd) {
        balanceUsd += amountUsd;
    }

    public boolean withdraw(double amountUsd) {
        if (balanceUsd >= amountUsd) {
            balanceUsd -= amountUsd;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amountUsd, int pinToMatch) {
        if (pin == pinToMatch && balanceUsd >= amountUsd) {
            balanceUsd -= amountUsd;
            return true;
        }
        return false;
    }
}