package OrderManager;

import java.time.LocalDate;
import java.util.*;

public class Order {
    private Long id; // id cua bill
    private String status;
    private LocalDate orderDate;//Ngày lập hóa đơn
    private LocalDate deliveryDate;//Ngày giao hàng
    private List<OrderItem> items = new ArrayList<OrderItem>();
    private Customer customer;
    public Order(Long id, String status, LocalDate orderDate,
                 LocalDate deliveryDate, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
    }

    public List<Product> getProducts(String category, double threshold) {
        return this.items
                .stream()
                .map(OrderItem::getP)
                .filter(product -> product.getCategory().equals(category) && product.getPrice() > threshold)
                .toList();
    }

    public double totalOfPrice() {
        return this.items
                .stream()
                .mapToDouble(OrderItem::cost)
                .sum();
    }

    public int getSizeOfItem() {
        return this.items.size();
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append(String.format("║ ORDER #%-5d                                                                        ║%n", id));
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Customer    : %-68s ║%n", customer.getName() + " (Tier " + customer.getTier() + ")"));
        sb.append(String.format("║ Status      : %-68s ║%n", status));
        sb.append(String.format("║ Order Date  : %-68s ║%n", orderDate));
        sb.append(String.format("║ Delivery    : %-68s ║%n", deliveryDate));
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append("║ ITEMS:                                                                                 ║\n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ %-30s | %-15s | %-12s | %-5s | %-12s ║%n",
                "Product Name", "Category", "Unit Price", "Qty", "Subtotal"));
        sb.append("║--------------------------------+-----------------+--------------+-------+--------------║\n");

        double total = 0;
        for (OrderItem item : items) {
            sb.append("║ ");
            sb.append(String.format("%-30s | %-15s | $%-10.2f | x%-3d | $%-10.2f",
                    item.getP().getName(),
                    item.getP().getCategory(),
                    item.getP().getPrice(),
                    item.getQuantity(),
                    item.getSubtotal()));
            sb.append(" ║\n");
            total += item.getSubtotal();
        }

        sb.append("╠════════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ TOTAL: $%-79.2f ║%n", total));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════════╝");

        return sb.toString();
    }

    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(item -> item.getP().getPrice() * item.getQuantity())
                .sum();
    }

    public static String getTableHeader() {
        return String.format("| %-8s | %-20s | %-12s | %-12s | %-12s | %-10s |",
                "Order ID", "Customer", "Status", "Order Date", "Delivery", "Total") + "\n" +
               "+----------+----------------------+--------------+--------------+--------------+------------+";
    }

    public String toTableRow() {
        return String.format("| %-8d | %-20s | %-12s | %-12s | %-12s | $%-9.2f |",
                id,
                customer.getName().length() > 20 ? customer.getName().substring(0, 17) + "..." : customer.getName(),
                status,
                orderDate,
                deliveryDate,
                getTotalAmount());
    }
}
