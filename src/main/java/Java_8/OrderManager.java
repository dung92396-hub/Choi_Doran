package Java_8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderManager {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order o) {
        boolean existed = this.orders
                .stream()
                .anyMatch(order -> order.getId().equals(o.getId()));
        if (existed) return;
        this.orders.add(o);
    }

    public List<Order> getAllOrdersBasedOnCategory(String category) {

        return orders
                .stream()
                .filter(order -> order.isExistedCategory(category))
                .toList();
    }
    // flatMap(): trai du lieu ra: chuyen ma tran thanh mang 1 chieu
    public List<Product> getAllProductsOrderByTierOn(int tier, LocalDate from, LocalDate to) {
        return this.orders
                .stream()
                .filter(item ->
                        item.getCustomer().getTier() == tier &&
                                item.getOrderDate().isAfter(from) &&
                                item.getOrderDate().isBefore(to))
                .flatMap(item -> item.getProducts().stream())
                .toList();
    }


    // sort theo giam dan va lay 3 cai dau tien (dung limit(n))
    // cach nay hieu suat khong cao lam
    public List<Order> get3RecentOrders(int n) {
        return this.orders
                .stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(n)
                .toList();
    }


    public List<Product> getProductsByOrderedDate(LocalDate date) {
        return this.orders
                .stream()
                .filter(order -> order.getOrderDate().equals(date))
                .flatMap(o -> o.getProducts().stream())
                .toList();
    }

    public double costOrderIn(LocalDate date) {
        return this.orders
                .stream()
                .filter(order -> order.getOrderDate().equals(date))
                .map(Order::getCost)
                .reduce(0.0, Double::sum);
    }

    public double getAverageCostOrderOn(LocalDate date) {
        int count = this.orders
                .stream()
                .filter(order -> order.getOrderDate().equals(date))
                .toList()
                .size();

        return this.costOrderIn(date) / count;
    }

    // code nay hoi kho giai thich
    // noi chung la dung collection de chuyen sang hashmap chi voi 1 dong duy nhat toMap(key, value)
    public Map<Long, Integer> getStatisticOrder() {
        return this.orders
                .stream()
                .collect(
                        Collectors.toMap(
                                Order::getId,
                                o -> o.getItems()
                                        .stream()
                                        .map(OrderItem::getQuantity)
                                        .reduce(0, Integer::sum)
                        ));
    }

    // cai nay thi nhom nhung value co key trung lap (nay giong truy van tren SQL)
    public Map<Customer, List<Order>> getStatisticsOrderByCustomers() {
        return this.orders
                .stream()
                .collect(
                        Collectors.groupingBy(Order::getCustomer)
                );
    }
}
