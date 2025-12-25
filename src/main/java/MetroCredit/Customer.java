package MetroCredit;

import java.util.*;
import java.util.stream.Collectors;

public class Customer {
    private Long customerID;
    private String name;
    private int age;
    private final List<Credit> credits;

    public Customer(Long customerID, String name, int age) {
        this.credits = new ArrayList<>();
        this.name = name;
        this.age = age;
        this.customerID = customerID;
    }

    public void addCredit(Long creditID, Type type, Location startPoint, Location endPoint) {
        if (containsCredit(creditID)) return;
        credits.add(new Credit(creditID, type, startPoint, endPoint));
    }

    public boolean containsCredit(Long creditID) {
        return this.credits
                .stream()
                .anyMatch(credit -> credit.getCreditID().equals(creditID));
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
        return credits
                .stream()
                .collect(Collectors.groupingBy(
                        Credit::getType,
                        Collectors.toCollection(TreeSet::new)
                ));
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }
}
