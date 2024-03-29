package models;


import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderRepository {
    private static final AtomicInteger count = new AtomicInteger(0);
    private List<Order> orderList;

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
        orderList = new ArrayList<Order>();
    }

    public boolean createOrder(String id, Order order) {
        boolean flag=false;
        for (Account a : accountRepository.getAccountList()) {
            if (a.getId().equals(id)) {
                a.addOrders(order);
                flag=true;
            }else{
                flag=false;
            }
        }
        return flag;
    }

    public List<Order> retrieveOrders(String id) {
        for (Account a : accountRepository.getAccountList()) {
            if (a.getId().equals(id)) {
                return a.getOrders();
            }
        }
        return null;
    }
}