package Lab_11.Task1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Bánh mì", "Bánh", 25000, LocalDate.of(2025, 12, 31));
        Product p2 = new Product("Sữa chua", "Sữa", 15000, LocalDate.of(2025, 12, 25));
        Product p3 = new Product("Nước cam", "Nước", 12000, LocalDate.of(2025, 12, 20));
        Product p4 = new Product("Kem", "Kem", 50000, LocalDate.of(2025, 12, 15));
        Product p5 = new Product("Bánh donut", "Bánh", 20000, LocalDate.of(2025, 12, 28));
        Product p6 = new Product("Nước dâu", "Nước", 18000, LocalDate.of(2025, 12, 22));
        Product p7 = new Product("Sữa tươi", "Sữa", 20000, LocalDate.of(2025, 12, 27));
        Product p8 = new Product("Bánh cookie", "Bánh", 15000, LocalDate.of(2025, 12, 30));

        OrderItem item1 = new OrderItem(p1, 2);
        OrderItem item2 = new OrderItem(p2, 3);
        OrderItem item3 = new OrderItem(p3, 1);
        OrderItem item4 = new OrderItem(p4, 1);
        OrderItem item5 = new OrderItem(p5, 2);
        OrderItem item6 = new OrderItem(p6, 4);
        OrderItem item7 = new OrderItem(p7, 1);
        OrderItem item8 = new OrderItem(p8, 3);

        Order order1 = new Order("ORD001", "Nguyễn Văn A", "Nhân viên 1", LocalDate.of(2025, 12, 1));
        order1.addItem(item1);
        order1.addItem(item2);

        Order order2 = new Order("ORD002", "Trần Thị B", "Nhân viên 2", LocalDate.of(2025, 12, 2));
        order2.addItem(item3);
        order2.addItem(item4);

        Order order3 = new Order("ORD003", "Lê Văn C", "Nhân viên 3", LocalDate.of(2025, 12, 3));
        order3.addItem(item1);
        order3.addItem(item3);

        Order order4 = new Order("ORD004", "Phạm Thị D", "Nhân viên 1", LocalDate.of(2025, 12, 4));
        order4.addItem(item5);
        order4.addItem(item6);

        Order order5 = new Order("ORD005", "Hoàng Văn E", "Nhân viên 2", LocalDate.of(2025, 12, 5));
        order5.addItem(item7);
        order5.addItem(item8);

        Order order6 = new Order("ORD006", "Vũ Thị F", "Nhân viên 3", LocalDate.of(2025, 12, 6));
        order6.addItem(item2);
        order6.addItem(item4);
        order6.addItem(item5);

        OrderManager manager = new OrderManager();
        manager.addOrder(order1);
        manager.addOrder(order2);
        manager.addOrder(order3);
        manager.addOrder(order4);
        manager.addOrder(order5);
        manager.addOrder(order6);

        System.out.println("Max product");
        System.out.println(manager.maxProduct());
        System.out.println("Order by cost");
        var set = manager.ordersByCost();
        set.forEach(System.out::println);
        System.out.println("Product types statistics");
        var hashmap = manager.productTypesStatistics();
        hashmap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
