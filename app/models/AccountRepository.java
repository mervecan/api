package models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountRepository {
    private static final AtomicInteger count = new AtomicInteger(0);
    private static List<Account> accountList;

    private static AccountRepository instance = null;

    public static AccountRepository getInstance() {
        if (instance == null) {
            instance = new AccountRepository();
        }
        return instance;
    }

    public AccountRepository() {
        accountList = new ArrayList<Account>();
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public Account createAccount(Account account) {
        int id = count.incrementAndGet();
        account.setId(String.valueOf(id));
        account.setId(String.valueOf(id));
        accountList.size();
        accountList.add(account);
        return account;
    }

    public Account retrieveAccount(String id) {
        for (Account a : accountList) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public Account updateAccount(Account account) {
        for (Account a : accountList) {
            if (a.getId().equals(account.getId())) {
                a.setId(String.valueOf(account.getId()));
                a.setCustomer((account.getCustomer()));
                a.setBankAccounts(account.getBankAccounts());
                a.setCreditCards(account.getCreditCards());
                a.setCreatedTime(account.getCreatedTime());
                a.setOrders(account.getOrders());
                return account;
            }else{
                return null;
            }
        }
        return null;
    }

    public boolean deleteAccount(String id) {
        for (Account a : accountList) {
            if (a.getId().equals(id)) {
                accountList.remove(a);
                return true;
            }
        }
        return false;
    }
}

