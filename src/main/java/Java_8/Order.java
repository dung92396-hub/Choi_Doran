package Java_8;

import java.time.LocalDate;
import java.util.*;

public class Order {
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<OrderItem> items = new ArrayList<>();
    private Customer customer;

    public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
    }

    public void addItem(OrderItem o) {
        this.items.add(o);
    }

    /**
     * 1)
     * tinh tong thanh tien trong bill
     * .map() chi lay thanh tien cua 1 san pham
     * .reduce() tong gia tien voi 0.0 la gia tri khoi tao, ::sum la yeu cau tinh tong
     * @return tong thanh tien trong bill
     */
    public double getCost() {
        return this.items
                .stream()
                .map(OrderItem::getCost)
                .reduce(0.0, Double::sum);
    }

    // lay ra toan bo san pham trong bill
    public List<Product> getProducts() {
        return this.items
                .stream()
                .map(OrderItem::getP)
                .toList();
    }

    // 2)
    // kiem tra danh muc (category) co ton tai trong cac sp
    // .anyMatch(): pthuc nay kiem tra danh muc co ton tai hay khong
    public boolean isExistedCategory(String category) {
        return this.items
                .stream()
                .anyMatch(item -> item.getP().getCategory().equals(category));
    }

    // 3)
    // loc ra san pham co danh muc yeu cau va gia tien > threshold
    public List<Product> getProducts(String category, double threshold) {
        return this.items.stream()
                .map(OrderItem::getP)
                .filter(p -> p.getCategory().equals(category) && p.getPrice() > threshold)
                .toList();
    }

    // 4)
    // peek(): duyet qua cac phan tu va thay doi gia tri
    public List<Product> getProductsByCategory10PercentPrice(String category) {
        return this.items.stream()
                .map(OrderItem::getP)
                .filter(item -> item.getCategory().equals(category))
                .peek(e -> e.setPrice(e.getPrice() * 0.9))
                .toList();
    }

    // 5)
    // map(): chi lay ra san pham de duyet
    // loc ra sp co danh muc yeu cau
    // min(): tim ra san pham co cost re nhat
    public Product getCheapestProduct(String category) {
        return this.items
                .stream()
                .map(OrderItem::getP)
                .filter(item -> item.getCategory().equals(category))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow();
    }

    // 6)
    public Map<String, List<Product>> groupByCategory() {
        Map<String, List<Product>> map = new HashMap<>();
        this.items.stream()
                .map(OrderItem::getP)
                .forEach(product -> {
                    map.putIfAbsent(product.getCategory(), new ArrayList<>());
                    map.get(product.getCategory()).add(product);
                });
        return map;
    }


    // 7)
    public Map<String, Product> getMostExpensiveProductByCategory() {
        Map<String, Product> map = new HashMap<>();
        var group = this.groupByCategory();
        group.forEach((k, v) -> {
            map.put(k, v.stream().max(Comparator.comparing(Product::getPrice)).orElseThrow());
        });
        return map;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
