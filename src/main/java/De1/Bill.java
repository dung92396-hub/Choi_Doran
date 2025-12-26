package De1;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
public class Bill {
    private int id;
    private LocalDate date;
    private LocalTime paymentTime;
    private String employee;
    private String customer;
    private List<BillItem> items; // cai nay

    public Bill(int id, LocalDate date, String employee, LocalTime paymentTime, String customer, List<BillItem> items) {
        this.id = id;
        this.date = date;
        this.employee = employee;
        this.customer = customer;
        this.items = items;
        this.paymentTime = paymentTime;
    }

    public LocalTime getPaymentTime() {
        return paymentTime;
    }

    public boolean ngoaiGioHanhChinh(LocalTime start, LocalTime end) {
        return paymentTime.isBefore(start) || paymentTime.isAfter(end);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Bill bill = (Bill) obj;
        return id == bill.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getEmployee() { return employee; }
    public void setEmployee(String employee) { this.employee = employee; }

    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }

    public List<BillItem> getItems() { return items; }
    public void setItems(List<BillItem> items) { this.items = items; }
}

