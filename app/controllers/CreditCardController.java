package controllers;

import com.google.inject.Inject;
import models.CreditCard;
import models.CreditCardRepository;
import play.libs.Json;
import play.mvc.Result;
import models.Account;
import models.AccountRepository;
import models.CreditCardRepository;
import static play.mvc.Controller.request;
import static play.mvc.Results.created;
import static play.mvc.Results.status;

public class CreditCardController {

    @Inject
    public CreditCardRepository creditCardRepository;

    @Inject
    public AccountRepository accountRepository;

    public Result createCreditCard(String id) {

        CreditCard creditCardRequest = Json.fromJson(request().body().asJson(), CreditCard.class);

        Boolean createProcess = creditCardRepository.createCreditCard(id, creditCardRequest);
            return created(Json.toJson(creditCardRequest)).as("application/json");

    }

    public Result retrieveCreditCards(String id){
//        JsonNode json = request().body().asJson();
//        if (json == null) {
//            return status(400, "Bad request: you should give id");
//        }
//
//        String id = json.findPath("id").textValue();
        Account account = accountRepository.retrieveAccount(id);
        if (account == null) {
            return status(404, "Not found: account cannot found");
        }else {
            return status(200, Json.toJson(account.getCreditCards())).as("application/json");
        }
    }

}

