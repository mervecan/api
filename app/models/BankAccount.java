package models;

public class BankAccount {
    private String id;
    private Account account;
    private String bankName;
    private String iban;
    private Balance balance;

    public BankAccount() {

    }

    public BankAccount(String id, Account account, String bankName, String iban, Balance balance) {
        this.id = id;
        this.account = account;
        this.bankName = bankName;
        this.iban = iban;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", bankName='" + bankName + '\'' +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}
