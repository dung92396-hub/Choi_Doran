package MetroCredit;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerManager {
    private final List<Customer> customers = new ArrayList<>();

    public boolean containsCustomer(Long customerID) {
        return this.customers.stream().anyMatch(customer -> customer.getCustomerID().equals(customerID));
    }

    public void addCustomer(Long customerID, String name, int age) {
        if (containsCustomer(customerID)) return;
        customers.add(new Customer(customerID, name, age));
    }

    public Customer getCustomerById(Long customerID) {
        return customers.stream()
                .filter(customer -> customer.getCustomerID().equals(customerID))
                .findFirst()
                .orElse(null);
    }

    // 1) Filter credits by type
    public List<Credit> getCreditsByType(Type type) {
        return null;
    }

    // 2) Find credit by creditID
    public Credit findCredit(Long creditID) {
        return null;
    }

    // 3) Filter credit by start point location
    public List<Credit> getCreditsByStartPoint(Location startPoint) {
        return null;
    }

    // 4) Total of credit's cost
    public double totalCredit() {
        return 0.0;
    }

    // 5) Total of credit's cost with any start location and end location
    public double totalCreditWithStartAndEndLocation(Location s, Location e) {
        return 0.0;
    }

    // 6) Thống kê các credit dựa trên loại tàu
    public Map<Type, List<Credit>> statisticCreditByType() {
        return null;
    }

    // 6.1 trả về TreeSet
    public Map<Type, Set<Credit>> statisticCreditByType2() {
        return null;
    }

    // 7) Đếm các vé tàu dựa trên loài tàu
    public Map<Type, Long> coundCreditByType() {
        return null;
    }

    // 8) Xắp xếp các vé tàu dựa trên cost
    public List<Credit> sortByCost() {
        return null;
    }

    // 9) thống kê doanh thu khi đặt vé ở start point
    public Map<Location, Double> statisticCostByStartPoint() {
        return null;
    }
}
