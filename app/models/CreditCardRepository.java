package models;

import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

public class CreditCardRepository {

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

    public Result create() {
        return null;
    }

    public Result delete() {
        return null;
    }

    public Result update() {
        return null;
    }

    public Result retrieveAccount() {
        return null;
    }
}
