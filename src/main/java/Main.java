import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Add imports for OrderManager package
import OrderManager.Customer;
import OrderManager.Order;
import OrderManager.OrderItem;
import OrderManager.OrderManager;
import OrderManager.Product;

public class Main {
    String name;
    int year;

    public Main(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Main{");
        sb.append("name='").append(name).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {  return name; }

    public int getYear() { return year; }

    // Init method to create demo data for OrderManager
    public static OrderManager init() {
        Random rnd = new Random(42); // deterministic for repeatable runs

        // 1) Create 50 products
        List<String> categories = Arrays.asList("Books", "Electronics", "Toys", "Grocery", "Clothing");
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            String category = categories.get(rnd.nextInt(categories.size()));
            String name = category + "-Product-" + i;
            double price = 10 + rnd.nextDouble() * 490; // price between 10 and 500
            products.add(new Product((long) i, name, category, price));
        }

        // 2) Create 100 order items (random products and quantities)
        List<OrderItem> itemsPool = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Product p = products.get(rnd.nextInt(products.size()));
            int quantity = 1 + rnd.nextInt(10); // 1..10
            itemsPool.add(new OrderItem(p, quantity));
        }

        // 3) Create some customers
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            int tier = 1 + rnd.nextInt(3); // 1..3
            customers.add(new Customer((long) i, "Customer-" + i, tier));
        }

        // 4) Create 40 orders, each with 5..15 items from the itemsPool
        List<Order> orders = new ArrayList<>();
        LocalDate baseDate = LocalDate.of(2024, 1, 1);
        for (int i = 1; i <= 40; i++) {
            Customer c = customers.get(rnd.nextInt(customers.size()));
            String status = rnd.nextBoolean() ? "NEW" : "DELIVERED";
            LocalDate orderDate = baseDate.plusDays(rnd.nextInt(365));
            LocalDate deliveryDate = orderDate.plusDays(1 + rnd.nextInt(10));
            Order order = new Order((long) i, status, orderDate, deliveryDate, c);

            int count = 5 + rnd.nextInt(11); // 5..15
            for (int k = 0; k < count; k++) {
                // pick random item from pool; clone to avoid shared references if needed
                OrderItem poolItem = itemsPool.get(rnd.nextInt(itemsPool.size()));
                // create a fresh OrderItem referencing the same Product but possibly different quantity
                int quantity = 1 + rnd.nextInt(10);
                order.addItem(new OrderItem(poolItem.getP(), quantity));
            }
            orders.add(order);
        }

        // 5) Put orders into OrderManager
        OrderManager manager = new OrderManager();
        orders.forEach(manager::add);
        return manager;
    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(nums.stream().collect(Collectors.averagingDouble(Integer::valueOf)));



    }
}
