package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.Account;
import models.Customer;
import models.CustomerRepository;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class CustomerController extends Controller {

    @Inject
    public CustomerRepository customerRepository;

    public Result createCustomer() {
        Customer customerRequest = Json.fromJson(request().body().asJson(), Customer.class);

        customerRepository.createCustomer(customerRequest);

        return created(Json.toJson(customerRequest)).as("application/json");
    }

    public Result deleteCustomer(String id) {
//        JsonNode json = request().body().asJson();
//        String id = json.findPath("id").textValue();
        Boolean val = customerRepository.deleteCustomer(id);
        return ok(String.valueOf(val)).as("application/json");
    }

    public Result updateCustomer() {
        Customer customerRequest = Json.fromJson(request().body().asJson(), Customer.class);
        customerRepository.updateCustomer(customerRequest);
        return ok(Json.toJson(customerRequest)).as("application/json");
    }

    public Result retrieveCustomer(String id) {
//        JsonNode json = request().body().asJson();
//        String id = json.findPath("id").textValue();
        Customer customer = customerRepository.retrieveCustomer(id);
        if (customer == null) {
            return ok("sorry");
        }
        return ok(Json.toJson(customer)).as("application/json");
    }


}

