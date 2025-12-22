package Java8_pack.Service;

import java.time.LocalDate;
import java.time.Period;

public class Product {
    private String id;
    private String name;
    private String category;
    private int price;
    private LocalDate manufactureDate;
    private int expiryDays;

    // Constructor
    public Product(String id, String name, String category, int price, LocalDate manufactureDate, int expiryDays) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.manufactureDate = manufactureDate;
        this.expiryDays = expiryDays;
        this.price = price;
    }

    public double payment(Pack p) {
        return this.price * p.getSale();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public int getExpiryDays() {
        return expiryDays;
    }

    // Setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setExpiryDays(int expiryDays) {
        this.expiryDays = expiryDays;
    }

    // Calculate expiry date
    public LocalDate getExpiryDate() {
        return manufactureDate.plusDays(expiryDays);
    }

    // Check if product is expired
    public boolean isExpired() {
        return LocalDate.now().isAfter(getExpiryDate());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", expiryDays=" + expiryDays +
                ", expiryDate=" + getExpiryDate() +
                ", isExpired=" + isExpired() +
                '}';
    }
}
