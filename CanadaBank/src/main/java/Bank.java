import java.util.ArrayList;

class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount newAccount) {
        accounts.add(newAccount);
    }

    public void removeAccount(String accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
    }

    public BankAccount[] getAllAccounts() {
        return accounts.toArray(new BankAccount[0]);
    }

    public BankAccount getMaxAccount() {
        BankAccount maxAccount = null;
        double maxBalance = Double.MIN_VALUE;
        for (BankAccount account : accounts) {
            if (account.getBalanceUsd() > maxBalance) {
                maxAccount = account;
                maxBalance = account.getBalanceUsd();
            }
        }
        return maxAccount;
    }

    public BankAccount getAccountFor(String clientId) {
        for (BankAccount account : accounts) {
            if (account.getClient().getClientId().equals(clientId)) {
                return account;
            }
        }
        return null;
    }
}