package models;


import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderRepository {
    private static final AtomicInteger count = new AtomicInteger(0);
    private List<Order> accountList;

    private static OrderRepository instance = null;

    @Inject
    public AccountRepository accountRepository;


    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }


    public OrderRepository() {
        accountList = new ArrayList<Order>();
    }

    public Order createOrder(String id, Order order) {
        for (Account a : accountRepository.getAccountList()) {
            if (a.getId().equals(id)) {
                a.addOrders(order);
            }
        }
        return null;
    }
}
