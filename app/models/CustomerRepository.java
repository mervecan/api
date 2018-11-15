package models;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerRepository {
    private static final AtomicInteger count = new AtomicInteger(0);
    private static List<Customer> customerList;

    private static CustomerRepository instance = null;

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public Customer createCustomer(Customer customer) {
        int id = count.incrementAndGet();
        customer.setId(String.valueOf(id));
        customer.setId(String.valueOf(id));
        customerList.size();
        customerList.add(customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer) {
        return null;
    }

    public Customer retrieveCustomer(String id) {
        for (Customer a : customerList) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public boolean deleteCustomer(String id) {
        for (Customer a : customerList) {
            if (a.getId().equals(id)) {
                customerList.remove(a);
                return true;
            }
        }
        return false;
    }
}
