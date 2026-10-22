public class Product {
    private final int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        setName(name);
        setPrice(price);
        this.id = id;
    }

       @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Nome não pode ser nulo ou em branco");

        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Preço não pode ser negativo");

        this.price = price;
    }
}
