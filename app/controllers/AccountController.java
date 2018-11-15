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
//        if(id == null){
//
//        }
        Account accountRequest = Json.fromJson(request().body().asJson(), Account.class);
        accountRepository.createAccount(accountRequest);

        return created(Json.toJson(accountRequest)).as("application/json");
    }

    public Result deleteAccount() {
        JsonNode json = request().body().asJson();
        String id = json.findPath("id").textValue();
        Boolean val = accountRepository.delete(id);
        if (val.equals(true)) {
            return status(200, "resource deleted successfully");
        } else {
            return status(404, "Resource is not found");
        }
    }

    public Result updateAccount() {
        Account bookRequest = Json.fromJson(request().body().asJson(), Account.class);
        accountRepository.updateAccount(bookRequest);
        return ok(Json.toJson(bookRequest)).as("application/json");
    }

    public Result retrieveAccount() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return status(400, "bad request you should give id");
        }

        String id = json.findPath("id").textValue();
        Account account = accountRepository.retrieveAccount(id);
        if (account == null) {
            return status(404, "resource is not found");
        }
        return status(200, Json.toJson(account)).as("application/json");
    }

}
