package Lab_11.Task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String customer;
    private String employee;
    private LocalDate date;
    private List<OrderItem> items;

    public Order(String id, String customer, String employee, LocalDate date) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.date = date;
        this.items = new ArrayList<>();
    }

    public int cost() {
        return items
                .stream()
                .map(OrderItem::cost)
                .reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id='").append(id).append('\'');
        sb.append(", customer='").append(customer).append('\'');
        sb.append(", employee='").append(employee).append('\'');
        sb.append(", date=").append(date);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
