package models;

public class Product {
    private String id;
    private String name;
    private String definition;
    private String price;

    public Product() {

    }

    public Product(String id, String name, String definition, String price) {
        this.id = id;
        this.name = name;
        this.definition = definition;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", definition='" + definition + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
