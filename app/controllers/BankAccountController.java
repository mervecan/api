package controllers;

import com.google.inject.Inject;
import models.BankAccount;
import models.BankAccountRepository;
import models.Order;
import play.libs.Json;
import play.mvc.Result;
import models.AccountRepository;
import models.Account;
import play.mvc.Result;

import static play.mvc.Controller.request;
import static play.mvc.Results.created;
import static play.mvc.Results.status;

public class BankAccountController {

    @Inject
    public BankAccountRepository bankAccountRepository;

    @Inject
    public AccountRepository accountRepository;

    public Result createBankAccount(String id) {

        BankAccount bankAccountRequest = Json.fromJson(request().body().asJson(), BankAccount.class);

        Boolean createProcess = bankAccountRepository.createBankAccount(id, bankAccountRequest);

        return created(Json.toJson(bankAccountRequest)).as("application/json");
    }

    public Result retrieveBankAccounts(String id){
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
            return status(200, Json.toJson(account.getBankAccounts())).as("application/json");
        }
    }

}
