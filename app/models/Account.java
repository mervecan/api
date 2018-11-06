package models;

public class Account {
    private String businessName;
    private String businessUrl;
    private String country;
    private int createdTime;
    private String currency;
    private String email;
    private String id;
    private Customer customer;

    public Account() {

    }

    public Account(String businessName, String businessUrl, String country, int createdTime, String currency, String email, String id, Customer customer) {
        this.businessName = businessName;
        this.businessUrl = businessUrl;
        this.country = country;
        this.createdTime = createdTime;
        this.currency = currency;
        this.email = email;
        this.id = id;
        this.customer = customer;

    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessUrl() {
        return businessUrl;
    }

    public void setBusinessUrl(String businessUrl) {
        this.businessUrl = businessUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(int createdTime) {
        this.createdTime = createdTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "businessName='" + businessName + '\'' +
                ", businessUrl='" + businessUrl + '\'' +
                ", country='" + country + '\'' +
                ", createdTime=" + createdTime +
                ", currency='" + currency + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", customer=" + customer +
                '}';
    }
}
