package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Account;
import models.AccountRepository;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.inject.Inject;



public class AccountController extends Controller {

    @Inject
    public AccountRepository accountRepository;

    public Result createAccount() {
        JsonNode json = request().body().asJson();
//        String id = json.findPath("id").textValue();
        if(json == null){
            return status(404, "You need define parameters");
        }
        Account accountRequest = Json.fromJson(request().body().asJson(), Account.class);
        accountRepository.createAccount(accountRequest);
        return created(Json.toJson(accountRequest)).as("application/json");
    }

    public Result deleteAccount() {
        JsonNode json = request().body().asJson();
        String id = json.findPath("id").textValue();
        Boolean val = accountRepository.deleteAccount(id);
        if (val.equals(true)) {
            return status(200, "Account deleted successfully");
        } else {
            return status(404, "Account  cannot found");
        }
    }

    public Result updateAccount() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return status(400, "bad request you should give id");
        }
        String id = json.findPath("id").textValue();
        Account account = accountRepository.retrieveAccount(id);
        if (account == null) {
            return status(404, "cannot find this account");
        }else{
            // Json.fromJson(request().body().asJson(), Account.class);
            Account updatedAccount = accountRepository.updateAccount(Json.fromJson(request().body().asJson(), Account.class));
            return status(200, Json.toJson(updatedAccount)).as("application/json");
        }
    }

    public Result retrieveAccount() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return status(400, "Bad request: you should give id");
        }

        String id = json.findPath("id").textValue();
        Account account = accountRepository.retrieveAccount(id);
        if (account == null) {
            return status(404, "Not found: account cannot found");
        }
        return status(200, Json.toJson(account)).as("application/json");
    }

}
