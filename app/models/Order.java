package models;

import java.util.List;

public class Order {
    private String id;
    // private Account account;
    private String amount;
    private List<Product> items;
    private STATUS status;

    public Order() {

    }

    public Order(String id, String amount, List<Product> items, STATUS status) {
        this.id = id;
        //  this.account = account;
        this.amount = amount;
        this.items = items;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
//                ", account=" + account +
                ", amount='" + amount + '\'' +
                ", items=" + items +
                ", status=" + status +
                '}';
    }
}
