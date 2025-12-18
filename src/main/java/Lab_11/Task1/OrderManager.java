package Lab_11.Task1;

import java.util.*;
import java.util.stream.Collectors;

public class OrderManager {
    private final List<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order o) {
        boolean e = orders.stream().anyMatch(order -> order.getId().equals(o.getId()));
        if (e) return;
        orders.add(o);
    }

    public Product maxProduct() {
        return orders
                .stream()
                .map(Order::getItems)
                .flatMap(Collection::stream)
                .map(OrderItem::getItem)
                .max(Comparator.comparingInt(Product::getPrice))
                .orElseThrow();
    }


    public TreeSet<Order> ordersByCost() {
        return orders
                .stream()
                .collect(
                        Collectors.toCollection(() ->
                                new TreeSet<>(Comparator.comparingInt(Order::cost).thenComparing(Order::getDate))
                        )
                );
    }

    public HashMap<String, Integer> productTypesStatistics() {
        return orders
                .stream()
                .flatMap(o -> o.getItems().stream())
                .collect(Collectors.toMap(
                        OrderItem::getType,
                        OrderItem::getAmount,
                        Integer::sum,
                        HashMap::new
                ));
    }


    public List<Order> getOrders() {
        return orders;
    }
}
