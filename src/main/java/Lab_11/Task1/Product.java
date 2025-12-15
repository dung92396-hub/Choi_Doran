package Lab_11.Task1;

import java.time.LocalDate;

public class Product {
    private String name;
    private String type;
    private int price;
    private LocalDate expiredDate;

    public Product(String name, String type, int price, LocalDate expiredDate) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("name='").append(name).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", price=").append(price);
        sb.append(", expiredDate=").append(expiredDate);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }
}
