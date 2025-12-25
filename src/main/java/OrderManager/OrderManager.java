package OrderManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderManager {
    private final List<Order> orders = new ArrayList<>();
    public List<Order> getOrders() {
        return orders;
    }

    public void add(Order o) {
        this.orders.add(o);
    }

    // 9)
    public List<Product> getProductsByOrderedDate(LocalDate date) {
        return this.orders
                .stream()
                .filter(order -> order.getOrderDate().equals(date))
                .flatMap(order -> order.getItems().stream())
                .map(OrderItem::getP)
                .toList();
    }

    // 12)
    public Map<Long, Integer> getStatisticOrders() {
        return this.orders
                .stream()
                .collect(Collectors.toMap(Order::getId, Order::getSizeOfItem));
    }

    // 2)
    public List<Product> getProducts(String category, double threshold) {
        return this.orders
                .stream()
                .flatMap(order -> order.getItems().stream())
                .map(OrderItem::getP)
                .filter(product -> product.getCategory().equals(category) && product.getPrice() > threshold)
                .toList();
    }

    // 3)
    public Product getCheapestProduct() {
        return this.orders
                .stream()
                .flatMap(order -> order.getItems().stream())
                .map(OrderItem::getP)
                .min(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    public double cost() {
        return this.orders
                .stream()
                .flatMapToDouble(order -> order.getItems()
                        .stream()
                        .mapToDouble(OrderItem::cost))
                .sum();
    }
}
