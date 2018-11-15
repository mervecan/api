package controllers;

import com.google.inject.Inject;
import models.Order;
import models.OrderRepository;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class OrderController extends Controller {

    @Inject
    public OrderRepository orderRepository;

    public Result createOrder(String id) {

        Order bookRequest = Json.fromJson(request().body().asJson(), Order.class);

        orderRepository.createOrder(id, bookRequest);

        return created(Json.toJson(bookRequest)).as("application/json");
    }

    public Result retrieveOrders(String id) {

        List<Order> orders = orderRepository.retrieveOrders(id);
        return created(Json.toJson(orders)).as("application/json");
    }

}
