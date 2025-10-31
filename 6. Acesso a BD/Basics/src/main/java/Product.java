public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Nome não pode ser nulo ou em branco");

        if (price < 0)
            throw new IllegalArgumentException("Preço não pode ser negativo");

        this.id = id;
        this.name = name;
        this.price = price;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
