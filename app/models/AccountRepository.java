package models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.mvc.Result;
import util.Util;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class AccountRepository {
    private static final AtomicInteger count = new AtomicInteger(1);
    private List<Account> accountList;

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

    public Account addAccount(Account account) {
        int id = count.incrementAndGet();
        account.setId(String.valueOf(id));
        account.setId(String.valueOf(id));
        accountList.add(account);
        return account;
    }

    public Account updateAccount(Account account) {
        int id = Integer.valueOf(account.getId());
//        if (account..containsKey(id)) {
//            accounts.put(id, account);
//            return account;
//        }
        return null;
    }

    public boolean deleteAccount(String id) {
        int index = -1;
        for (Account a : accountList) {
            if (a.getId() == String.valueOf(id)) {
                index = accountList.indexOf(a);
                continue;
            }
        }
        if (index > -1) {
            accountList.remove(index);
        }
        return true;
    }

    // return all accounts
    public List<Account> retrieveAllAccounts() {
        return accountList;
    }


}


