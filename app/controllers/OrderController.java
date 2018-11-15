package controllers;

import com.google.inject.Inject;
import models.Order;
import models.OrderRepository;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class OrderController extends Controller {

    @Inject
    public OrderRepository accountRepository;

    public Result createOrder(String id) {

        Order bookRequest = Json.fromJson(request().body().asJson(), Order.class);

        accountRepository.createOrder(id, bookRequest);

        return created(Json.toJson(bookRequest)).as("application/json");
    }

}
