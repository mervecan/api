package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.Account;
import models.AccountRepository;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.Util;

import com.google.inject.Inject;

import java.util.List;
import java.util.Set;

public class AccountController extends Controller {

    @Inject
    public AccountRepository accountRepository;

    public Result create() {
        Account bookRequest = Json.fromJson(request().body().asJson(), Account.class);

        accountRepository.addAccount(bookRequest);

        return ok(Json.toJson(bookRequest)).as("application/json");
    }

    public Result retrieveAllAccounts() throws JsonProcessingException {
        List<Account> result = AccountRepository.getInstance().retrieveAllAccounts();
        String json = new Gson().toJson(result);
        return ok(Util.createResponse(json, true));

    }

}
