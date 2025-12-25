package OrderManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        init(orderManager);


    }

    public static <U> void printData(List<U> data) {
        data.forEach(System.out::println);
    }

    public static <K, V> void printData(Map<K, V> data) {
        data.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    public static void init(OrderManager orderManager) {
        // 1) Create 50 products with fixed data
        List<Product> products = new ArrayList<>();

        // Books - 10 products
        products.add(new Product(1L, "Java Programming", "Books", 45.99));
        products.add(new Product(2L, "Clean Code", "Books", 39.99));
        products.add(new Product(3L, "Design Patterns", "Books", 52.50));
        products.add(new Product(4L, "Effective Java", "Books", 48.00));
        products.add(new Product(5L, "Spring in Action", "Books", 55.00));
        products.add(new Product(6L, "Head First Java", "Books", 42.00));
        products.add(new Product(7L, "Thinking in Java", "Books", 38.50));
        products.add(new Product(8L, "Java Concurrency", "Books", 60.00));
        products.add(new Product(9L, "Microservices Patterns", "Books", 65.00));
        products.add(new Product(10L, "REST API Design", "Books", 35.00));

        // Electronics - 10 products
        products.add(new Product(11L, "Laptop Dell XPS", "Electronics", 1299.99));
        products.add(new Product(12L, "iPhone 15 Pro", "Electronics", 999.99));
        products.add(new Product(13L, "Samsung Galaxy S24", "Electronics", 899.00));
        products.add(new Product(14L, "MacBook Pro M3", "Electronics", 1999.99));
        products.add(new Product(15L, "iPad Air", "Electronics", 599.00));
        products.add(new Product(16L, "Sony Headphones", "Electronics", 299.99));
        products.add(new Product(17L, "Logitech Mouse", "Electronics", 49.99));
        products.add(new Product(18L, "Mechanical Keyboard", "Electronics", 129.99));
        products.add(new Product(19L, "4K Monitor", "Electronics", 399.99));
        products.add(new Product(20L, "Webcam HD", "Electronics", 79.99));

        // Toys - 10 products
        products.add(new Product(21L, "LEGO Star Wars", "Toys", 89.99));
        products.add(new Product(22L, "Barbie Dreamhouse", "Toys", 199.99));
        products.add(new Product(23L, "Hot Wheels Set", "Toys", 29.99));
        products.add(new Product(24L, "PlayStation 5", "Toys", 499.99));
        products.add(new Product(25L, "Nintendo Switch", "Toys", 299.99));
        products.add(new Product(26L, "Action Figure", "Toys", 24.99));
        products.add(new Product(27L, "Board Game Monopoly", "Toys", 19.99));
        products.add(new Product(28L, "RC Car", "Toys", 59.99));
        products.add(new Product(29L, "Puzzle 1000 pieces", "Toys", 15.99));
        products.add(new Product(30L, "Drone with Camera", "Toys", 249.99));

        // Grocery - 10 products
        products.add(new Product(31L, "Organic Milk", "Grocery", 4.99));
        products.add(new Product(32L, "Fresh Bread", "Grocery", 2.99));
        products.add(new Product(33L, "Eggs (12 pack)", "Grocery", 3.49));
        products.add(new Product(34L, "Chicken Breast", "Grocery", 8.99));
        products.add(new Product(35L, "Pasta Spaghetti", "Grocery", 1.99));
        products.add(new Product(36L, "Tomato Sauce", "Grocery", 2.49));
        products.add(new Product(37L, "Fresh Vegetables", "Grocery", 5.99));
        products.add(new Product(38L, "Fruit Basket", "Grocery", 12.99));
        products.add(new Product(39L, "Coffee Beans", "Grocery", 14.99));
        products.add(new Product(40L, "Green Tea", "Grocery", 9.99));

        // Clothing - 10 products
        products.add(new Product(41L, "Nike Running Shoes", "Clothing", 119.99));
        products.add(new Product(42L, "Adidas T-Shirt", "Clothing", 29.99));
        products.add(new Product(43L, "Levi's Jeans", "Clothing", 79.99));
        products.add(new Product(44L, "Winter Jacket", "Clothing", 149.99));
        products.add(new Product(45L, "Cotton Socks (5 pairs)", "Clothing", 12.99));
        products.add(new Product(46L, "Leather Belt", "Clothing", 34.99));
        products.add(new Product(47L, "Baseball Cap", "Clothing", 19.99));
        products.add(new Product(48L, "Sunglasses", "Clothing", 89.99));
        products.add(new Product(49L, "Dress Shirt", "Clothing", 49.99));
        products.add(new Product(50L, "Sneakers", "Clothing", 99.99));

        // 2) Create 20 customers with fixed data
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "Nguyen Van A", 3));
        customers.add(new Customer(2L, "Tran Thi B", 2));
        customers.add(new Customer(3L, "Le Van C", 1));
        customers.add(new Customer(4L, "Pham Thi D", 3));
        customers.add(new Customer(5L, "Hoang Van E", 2));
        customers.add(new Customer(6L, "Vo Thi F", 1));
        customers.add(new Customer(7L, "Dang Van G", 3));
        customers.add(new Customer(8L, "Bui Thi H", 2));
        customers.add(new Customer(9L, "Do Van I", 1));
        customers.add(new Customer(10L, "Ngo Thi K", 3));
        customers.add(new Customer(11L, "Duong Van L", 2));
        customers.add(new Customer(12L, "Truong Thi M", 1));
        customers.add(new Customer(13L, "Ly Van N", 3));
        customers.add(new Customer(14L, "Mai Thi O", 2));
        customers.add(new Customer(15L, "Vu Van P", 1));
        customers.add(new Customer(16L, "Ha Thi Q", 3));
        customers.add(new Customer(17L, "Cao Van R", 2));
        customers.add(new Customer(18L, "Phan Thi S", 1));
        customers.add(new Customer(19L, "Dinh Van T", 3));
        customers.add(new Customer(20L, "Luu Thi U", 2));

        // 3) Create 40 orders with fixed data (5-15 items each)
        // Order 1 - 8 items
        Order order1 = new Order(1L, "DELIVERED", LocalDate.of(2024, 1, 15), LocalDate.of(2024, 1, 18), customers.get(0));
        order1.addItem(new OrderItem(products.get(0), 2));  // Java Programming
        order1.addItem(new OrderItem(products.get(1), 1));  // Clean Code
        order1.addItem(new OrderItem(products.get(10), 1)); // Laptop Dell
        order1.addItem(new OrderItem(products.get(16), 1)); // Logitech Mouse
        order1.addItem(new OrderItem(products.get(30), 3)); // Organic Milk
        order1.addItem(new OrderItem(products.get(40), 1)); // Nike Shoes
        order1.addItem(new OrderItem(products.get(41), 2)); // Adidas T-Shirt
        order1.addItem(new OrderItem(products.get(38), 1)); // Coffee Beans
        orderManager.add(order1);

        // Order 2 - 5 items
        Order order2 = new Order(2L, "NEW", LocalDate.of(2024, 2, 1), LocalDate.of(2024, 2, 5), customers.get(1));
        order2.addItem(new OrderItem(products.get(20), 1)); // LEGO Star Wars
        order2.addItem(new OrderItem(products.get(21), 1)); // Barbie Dreamhouse
        order2.addItem(new OrderItem(products.get(22), 2)); // Hot Wheels Set
        order2.addItem(new OrderItem(products.get(31), 5)); // Fresh Bread
        order2.addItem(new OrderItem(products.get(32), 12)); // Eggs
        orderManager.add(order2);

        // Order 3 - 10 items
        Order order3 = new Order(3L, "DELIVERED", LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 13), customers.get(2));
        order3.addItem(new OrderItem(products.get(11), 1)); // iPhone 15 Pro
        order3.addItem(new OrderItem(products.get(15), 2)); // Sony Headphones
        order3.addItem(new OrderItem(products.get(2), 1));  // Design Patterns
        order3.addItem(new OrderItem(products.get(3), 1));  // Effective Java
        order3.addItem(new OrderItem(products.get(42), 3)); // Levi's Jeans
        order3.addItem(new OrderItem(products.get(43), 1)); // Winter Jacket
        order3.addItem(new OrderItem(products.get(33), 2)); // Chicken Breast
        order3.addItem(new OrderItem(products.get(34), 3)); // Pasta
        order3.addItem(new OrderItem(products.get(35), 2)); // Tomato Sauce
        order3.addItem(new OrderItem(products.get(39), 2)); // Green Tea
        orderManager.add(order3);

        // Order 4 - 7 items
        Order order4 = new Order(4L, "NEW", LocalDate.of(2024, 3, 5), LocalDate.of(2024, 3, 10), customers.get(3));
        order4.addItem(new OrderItem(products.get(13), 1)); // MacBook Pro M3
        order4.addItem(new OrderItem(products.get(14), 1)); // iPad Air
        order4.addItem(new OrderItem(products.get(17), 1)); // Mechanical Keyboard
        order4.addItem(new OrderItem(products.get(18), 2)); // 4K Monitor
        order4.addItem(new OrderItem(products.get(4), 1));  // Spring in Action
        order4.addItem(new OrderItem(products.get(5), 1));  // Head First Java
        order4.addItem(new OrderItem(products.get(44), 5)); // Cotton Socks
        orderManager.add(order4);

        // Order 5 - 12 items
        Order order5 = new Order(5L, "DELIVERED", LocalDate.of(2024, 3, 20), LocalDate.of(2024, 3, 24), customers.get(4));
        order5.addItem(new OrderItem(products.get(23), 1)); // PlayStation 5
        order5.addItem(new OrderItem(products.get(24), 1)); // Nintendo Switch
        order5.addItem(new OrderItem(products.get(25), 3)); // Action Figure
        order5.addItem(new OrderItem(products.get(26), 2)); // Board Game
        order5.addItem(new OrderItem(products.get(27), 1)); // RC Car
        order5.addItem(new OrderItem(products.get(6), 2));  // Thinking in Java
        order5.addItem(new OrderItem(products.get(7), 1));  // Java Concurrency
        order5.addItem(new OrderItem(products.get(36), 4)); // Fresh Vegetables
        order5.addItem(new OrderItem(products.get(37), 2)); // Fruit Basket
        order5.addItem(new OrderItem(products.get(45), 1)); // Leather Belt
        order5.addItem(new OrderItem(products.get(46), 2)); // Baseball Cap
        order5.addItem(new OrderItem(products.get(47), 1)); // Sunglasses
        orderManager.add(order5);

        // Order 6 - 6 items
        Order order6 = new Order(6L, "NEW", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 5), customers.get(5));
        order6.addItem(new OrderItem(products.get(8), 1));  // Microservices Patterns
        order6.addItem(new OrderItem(products.get(9), 1));  // REST API Design
        order6.addItem(new OrderItem(products.get(12), 1)); // Samsung Galaxy S24
        order6.addItem(new OrderItem(products.get(48), 1)); // Dress Shirt
        order6.addItem(new OrderItem(products.get(49), 2)); // Sneakers
        order6.addItem(new OrderItem(products.get(30), 10)); // Organic Milk
        orderManager.add(order6);

        // Order 7 - 9 items
        Order order7 = new Order(7L, "DELIVERED", LocalDate.of(2024, 4, 15), LocalDate.of(2024, 4, 18), customers.get(6));
        order7.addItem(new OrderItem(products.get(19), 2)); // Webcam HD
        order7.addItem(new OrderItem(products.get(28), 1)); // Puzzle 1000 pieces
        order7.addItem(new OrderItem(products.get(29), 1)); // Drone with Camera
        order7.addItem(new OrderItem(products.get(31), 6)); // Fresh Bread
        order7.addItem(new OrderItem(products.get(32), 6)); // Eggs
        order7.addItem(new OrderItem(products.get(33), 2)); // Chicken Breast
        order7.addItem(new OrderItem(products.get(40), 1)); // Nike Shoes
        order7.addItem(new OrderItem(products.get(41), 3)); // Adidas T-Shirt
        order7.addItem(new OrderItem(products.get(42), 1)); // Levi's Jeans
        orderManager.add(order7);

        // Order 8 - 15 items (max)
        Order order8 = new Order(8L, "NEW", LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 6), customers.get(7));
        order8.addItem(new OrderItem(products.get(0), 1));
        order8.addItem(new OrderItem(products.get(1), 1));
        order8.addItem(new OrderItem(products.get(2), 1));
        order8.addItem(new OrderItem(products.get(10), 1));
        order8.addItem(new OrderItem(products.get(11), 1));
        order8.addItem(new OrderItem(products.get(20), 2));
        order8.addItem(new OrderItem(products.get(21), 1));
        order8.addItem(new OrderItem(products.get(30), 3));
        order8.addItem(new OrderItem(products.get(31), 4));
        order8.addItem(new OrderItem(products.get(32), 6));
        order8.addItem(new OrderItem(products.get(40), 1));
        order8.addItem(new OrderItem(products.get(41), 2));
        order8.addItem(new OrderItem(products.get(42), 1));
        order8.addItem(new OrderItem(products.get(43), 1));
        order8.addItem(new OrderItem(products.get(44), 3));
        orderManager.add(order8);

        // Order 9 - 8 items
        Order order9 = new Order(9L, "DELIVERED", LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 19), customers.get(8));
        order9.addItem(new OrderItem(products.get(3), 2));
        order9.addItem(new OrderItem(products.get(4), 1));
        order9.addItem(new OrderItem(products.get(13), 1));
        order9.addItem(new OrderItem(products.get(14), 1));
        order9.addItem(new OrderItem(products.get(34), 3));
        order9.addItem(new OrderItem(products.get(35), 3));
        order9.addItem(new OrderItem(products.get(45), 1));
        order9.addItem(new OrderItem(products.get(46), 1));
        orderManager.add(order9);

        // Order 10 - 11 items
        Order order10 = new Order(10L, "NEW", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 5), customers.get(9));
        order10.addItem(new OrderItem(products.get(5), 1));
        order10.addItem(new OrderItem(products.get(6), 1));
        order10.addItem(new OrderItem(products.get(15), 2));
        order10.addItem(new OrderItem(products.get(16), 3));
        order10.addItem(new OrderItem(products.get(17), 1));
        order10.addItem(new OrderItem(products.get(22), 2));
        order10.addItem(new OrderItem(products.get(23), 1));
        order10.addItem(new OrderItem(products.get(36), 2));
        order10.addItem(new OrderItem(products.get(37), 1));
        order10.addItem(new OrderItem(products.get(47), 1));
        order10.addItem(new OrderItem(products.get(48), 1));
        orderManager.add(order10);

        // Continue with orders 11-40 (shortened for brevity but following same pattern)
        for (int i = 11; i <= 40; i++) {
            Customer customer = customers.get(i % 20);
            String status = (i % 2 == 0) ? "DELIVERED" : "NEW";
            LocalDate orderDate = LocalDate.of(2024, (i % 12) + 1, ((i % 28) + 1));
            LocalDate deliveryDate = orderDate.plusDays(3 + (i % 5));
            Order order = new Order((long) i, status, orderDate, deliveryDate, customer);

            // Add 5-15 items per order
            int itemCount = 5 + (i % 11);
            for (int j = 0; j < itemCount; j++) {
                int productIndex = (i * 3 + j * 7) % 50;
                int quantity = 1 + (j % 5);
                order.addItem(new OrderItem(products.get(productIndex), quantity));
            }
            orderManager.add(order);
        }

        System.out.println("Initialized OrderManager with 40 orders, 50 unique products (fixed data)");
    }
}
