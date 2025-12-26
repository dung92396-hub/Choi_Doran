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

    public Customer getCustomer(int idx) {
        return this.customers.get(idx);
    }

    public Customer getCustomerById(Long customerID) {
        return customers.stream()
                .filter(customer -> customer.getCustomerID().equals(customerID))
                .findFirst()
                .orElse(null);
    }

    // 1) Filter credits by type
    public List<Credit> getCreditsByType(Type type) {
        return this.customers
                .stream()
                .flatMap(customer -> customer.getCredits().stream())
                .filter(credit -> credit.getType().equals(type))
                .toList();
    }

    // 2) Find credit by creditID
    public Credit findCredit(Long creditID) {
        return this.customers
                .stream()
                .flatMap(customer -> customer.getCredits().stream())
                .filter(credit -> credit.getCreditID().equals(creditID))
                .findFirst()
                .orElseThrow();
    }

    // 3) Filter credit by start point location
    public List<Credit> getCreditsByStartPoint(Location startPoint) {
        return null;
    }

    // 4) Total of credit's cost
    public double totalCredit() {
        return this.customers
                .stream()
                .flatMapToDouble(customer -> customer.getCredits()
                        .stream()
                        .mapToDouble(Credit::cost))
                .sum();
    }

    // 5) Total of credit's cost with any start location and end location
    public double totalCreditWithStartAndEndLocation(Location s, Location e) {
        return this.customers
                .stream()
                .flatMapToDouble(customer -> customer.getCredits()
                        .stream()
                        .filter(credit -> credit.getStartPoint().equals(s) &&
                                credit.getEndPoint().equals(e))
                        .mapToDouble(Credit::cost))
                .sum();
    }

    // 6) Thống kê các credit dựa trên loại tàu
    public Map<Type, List<Credit>> statisticCreditByType() {
        return this.customers
                .stream()
                .flatMap(c -> c.getCredits().stream())
                .collect(Collectors.groupingBy(Credit::getType));
    }

    // 6.1 trả về TreeSet
    public Map<Type, Set<Credit>> statisticCreditByType2() {
        return this.customers
                .stream()
                .flatMap(customer -> customer.getCredits().stream())
                .collect(Collectors.groupingBy(
                        Credit::getType,
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Credit::cost)))
                ));
    }
    // toMap, toSet, toCollection

    // 7) Đếm các vé tàu dựa trên loài tàu
    public Map<Type, Long> countCreditByType() {
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

    // 10) xap xep cac khach hang dua tren thanh tien tang dan va ten giam dan
    public Set<Customer> sortByCostAndName() {
        var comp = Comparator
                .comparing(Customer::totalCredit)
                .thenComparing(Customer::getName,
                        Comparator.reverseOrder());
        var treeSet = new TreeSet<>(comp);
        return this.customers
                .stream()
                .collect(Collectors.toCollection(() -> treeSet));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("┌─────────────────────┬────────────────────────────────┐\n"));
        sb.append(String.format("│ %-19s │ %-30s │\n", "Customer Manager", ""));
        sb.append(String.format("├─────────────────────┼────────────────────────────────┤\n"));
        sb.append(String.format("│ %-19s │ %-30d │\n", "Total Customers", this.customers.size()));
        sb.append(String.format("│ %-19s │ %-30d │\n", "Total Credits",
            this.customers.stream().mapToInt(c -> c.getCredits().size()).sum()));
        sb.append(String.format("│ %-19s │ %-30.2f │\n", "Total Revenue", this.totalCredit()));
        sb.append(String.format("└─────────────────────┴────────────────────────────────┘"));
        return sb.toString();
    }


}
