package controllers;

import com.google.inject.Inject;
import models.BankAccount;
import models.BankAccountRepository;
import models.Order;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Controller.request;
import static play.mvc.Results.created;

public class BankAccountController {

    @Inject
    public BankAccountRepository bankAccountRepository;

    public Result createBankAccount(String id) {

        BankAccount bankAccountRequest = Json.fromJson(request().body().asJson(), BankAccount.class);

        bankAccountRepository.createBankAccount(id, bankAccountRequest);

        return created(Json.toJson(bankAccountRequest)).as("application/json");
    }

}
