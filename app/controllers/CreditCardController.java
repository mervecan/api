package controllers;

import com.google.inject.Inject;
import models.BankAccount;
import models.BankAccountRepository;
import models.CreditCard;
import models.CreditCardRepository;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Controller.request;
import static play.mvc.Results.created;

public class CreditCardController {

    @Inject
    public CreditCardRepository creditCardRepository;

    public Result createCreditCard(String id) {

        CreditCard creditCardRequest = Json.fromJson(request().body().asJson(), CreditCard.class);

        creditCardRepository.createCreditCard(id, creditCardRequest);

        return created(Json.toJson(creditCardRequest)).as("application/json");
    }
}
