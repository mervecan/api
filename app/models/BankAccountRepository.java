package models;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountRepository {
    private static final AtomicInteger count = new AtomicInteger(0);
    private List<BankAccount> bankAccountList;

    private static BankAccountRepository instance = null;

    @Inject
    public AccountRepository accountRepository;

    public static BankAccountRepository getInstance() {
        if (instance == null) {
            instance = new BankAccountRepository();
        }
        return instance;
    }


    public BankAccountRepository() {
        bankAccountList = new ArrayList<BankAccount>();
    }

    public BankAccount createBankAccount(String id, BankAccount bankAccount) {
        for (Account a : accountRepository.getAccountList()) {
            if (a.getId().equals(id)) {
                a.addBankAccount(bankAccount);
                return bankAccount;
            }
        }
        return null;
    }
}
