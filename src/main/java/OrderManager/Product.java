package OrderManager;

public class Product {
    private Long id;
    private String name;
    private String category;
    private double price;

    public Product(Long id, String name, String category,
                   double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-30s | %-15s | $%-10.2f |",
                id, name, category, price);
    }

    public static String getTableHeader() {
        return String.format("| %-5s | %-30s | %-15s | %-12s |",
                "ID", "Name", "Category", "Price") + "\n" +
               "+-------+--------------------------------+-----------------+--------------+";
    }
}
