package models;

import com.google.inject.Inject;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CreditCardRepository {
    private static final AtomicInteger count = new AtomicInteger(0);
    @Inject
    public AccountRepository accountRepository;

    private List<CreditCard> creditCardList;

    private static CreditCardRepository instance = null;

    public static CreditCardRepository getInstance() {
        if (instance == null) {
            instance = new CreditCardRepository();
        }
        return instance;
    }

    public CreditCardRepository() {
        creditCardList = new ArrayList<CreditCard>();
    }

    public CreditCard createCreditCard(String id, CreditCard creditCard) {
        for (Account a : accountRepository.getAccountList()) {
            if (a.getId().equals(id)) {
                int creditCardId = count.incrementAndGet();
                creditCard.setCreditCardId(String.valueOf(creditCardId));
                a.addCreditCard(creditCard);
                return creditCard;
            }
        }
        return null;
    }

}
