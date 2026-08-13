package domain.entity;

public class Product {
    private Integer id;
    private String name;
    private double price;

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public Product(Integer id, String name, double price) {
        this(name, price);
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        this.price = price;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }



    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Preço: %.2f", id, name, price);
    }
}

