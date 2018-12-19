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

        Order orderRequest = Json.fromJson(request().body().asJson(), Order.class);

        Order order = orderRepository.createOrder(id, orderRequest);
        if(order==null){
            return status(404, "Not Found: Account cannot found");
        }
        else {
            return created(Json.toJson(orderRequest)).as("application/json");
        }
    }

    public Result retrieveOrders(String id) {
            List<Order> orders = orderRepository.retrieveOrders(id);
            if(orders==null){
                return status(404, "account is not found");
            }
            else{
                return ok(Json.toJson(orders)).as("application/json");
            }
    }
}
