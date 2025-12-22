package Java8_pack.Service;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private Pack pack;
    private final List<Product> purchasedProducts;

    // Constructor
    public Customer(String id, String firstName, String lastName, int yearOfBirth, Pack pack) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.pack = pack;
        this.purchasedProducts = new ArrayList<>();
    }

    public double totalPrice() {
        return purchasedProducts
                .stream()
                .mapToDouble(p -> p.payment(pack))
                .sum();
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getAge() {
        return java.time.LocalDate.now().getYear() - yearOfBirth;
    }

    public List<Product> getPurchasedProducts() {
        return new ArrayList<>(purchasedProducts);
    }

    // Setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    // Product management methods
    public void addProduct(Product product) {
        if (product != null && !purchasedProducts.contains(product)) {
            purchasedProducts.add(product);
        }
    }

    public void removeProduct(Product product) {
        purchasedProducts.remove(product);
    }

    public void removeProductById(String productId) {
        purchasedProducts.removeIf(p -> p.getId().equals(productId));
    }

    public int getProductCount() {
        return purchasedProducts.size();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", age=" + getAge() +
                ", productCount=" + getProductCount() +
                '}';
    }
}
