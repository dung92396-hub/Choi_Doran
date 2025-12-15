package Lab_11.Task1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("A", "a1", 2, LocalDate.of(2022, 10, 11));
        Product p2 = new Product("B", "a2", 8, LocalDate.of(2022, 8, 11));
        Product p3 = new Product("B", "a3", 4, LocalDate.of(2022, 4, 11));
        Product p4 = new Product("C", "a3", 6, LocalDate.of(2022, 11, 11));
        Product p5 = new Product("D", "a2", 7, LocalDate.of(2022, 4, 11));

        OrderItem o1 = new OrderItem(p1, 10);
        OrderItem o2 = new OrderItem(p2, 12);
        OrderItem o3 = new OrderItem(p3, 13);
        OrderItem o4 = new OrderItem(p4, 14);
        OrderItem o5 = new OrderItem(p5, 15);

        Order order1 = new Order("1", "Hoang Phuc", "Phuc Hoang", LocalDate.of(2022, 12, 12));
        order1.addItem(o1);
        order1.addItem(o2);
        order1.addItem(o3);

        Order order2 = new Order("2", "Alex", "Jack", LocalDate.of(2022, 12, 12));
        order1.addItem(o3);
        order1.addItem(o4);
        order1.addItem(o5);

        OrderManager orderManager = new OrderManager();
        orderManager.addOrder(order1);
        orderManager.addOrder(order2);


        System.out.println(orderManager.productTypesStatistics());
    }
}
