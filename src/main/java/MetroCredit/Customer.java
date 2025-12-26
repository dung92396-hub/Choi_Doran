package MetroCredit;

import java.util.*;
import java.util.stream.Collectors;

public class Customer {
    private final List<Credit> credits;
    private Long customerID;
    private String name;
    private int age;

    public Customer(Long customerID, String name, int age) {
        this.credits = new ArrayList<>();
        this.name = name;
        this.age = age;
        this.customerID = customerID;
    }

    public List<Credit> getCredits() {
        return this.credits;
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
        return this.credits
                .stream()
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
        return this.credits
                .stream()
                .mapToDouble(Credit::cost)
                .sum();
    }

    // 5) Total of credit's cost with any start location and end location
    public double totalCreditWithStartAndEndLocation(Location s, Location e) {
        return this.credits
                .stream()
                .filter(credit -> credit.getStartPoint().equals(s) &&
                        credit.getEndPoint().equals(e))
                .mapToDouble(Credit::cost)
                .sum();
    }

    // 6) Thống kê các credit dựa trên loại tàu
    public Map<Type, List<Credit>> statisticCreditByType() {
        return this.credits
                .stream()
                .collect(Collectors.groupingBy(Credit::getType));
    }

    // 6.1 trả về TreeSet (thành tiên) -> cost
    public Map<Type, Set<Credit>> statisticCreditByType2() {
        Comparator<Credit> comparator = Comparator.comparingDouble(Credit::cost);
        Set<Credit> set = new TreeSet<>(comparator);
        return this.credits
                .stream()
                .collect(Collectors.groupingBy(
                        Credit::getType,
                        Collectors.toCollection(() -> set)
                ));
    }

    // 7) Đếm các vé tàu dựa trên loài tàu
    public Map<Type, Long> coundCreditByType() {
        return this.credits
                .stream()
                .collect(Collectors.groupingBy(
                        Credit::getType,
                        Collectors.counting()
                ));
    }

    // 8) Xắp xếp các vé tàu dựa trên cost
    public List<Credit> sortByCost() {
        var comp = Comparator.comparing(Credit::cost);
        return this.credits
                .stream()
                .sorted(comp)
                .toList();
    }

    public Set<Credit> getTreeSetByCost() {
        var c = Comparator.comparing(Credit::cost);
        var s = new TreeSet<>(c);
        return this.credits
                .stream()
                .collect(Collectors.toCollection(() -> s));
    }

    // 9) thống kê doanh thu khi đặt vé ở start point
    public Map<Location, Double> statisticCostByStartPoint() {
        return this.credits
                .stream()
                .collect(Collectors.groupingBy(
                        Credit::getStartPoint,
                        Collectors.summingDouble(Credit::cost)
                ));
    }

    public Map<Location, Double> statisticCostByStartPoint2() {
        return this.credits
                .stream()
                .collect(Collectors.toMap(
                        Credit::getStartPoint,
                        Credit::cost,
                        Double::sum
                ));
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("┌─────────────────────┬────────────────────────────────┐\n"));
        sb.append(String.format("│ %-19s │ %-30s │\n", "Customer Information", ""));
        sb.append(String.format("├─────────────────────┼────────────────────────────────┤\n"));
        sb.append(String.format("│ %-19s │ %-30d │\n", "Customer ID", this.customerID));
        sb.append(String.format("│ %-19s │ %-30s │\n", "Name", this.name));
        sb.append(String.format("│ %-19s │ %-30d │\n", "Age", this.age));
        sb.append(String.format("│ %-19s │ %-30d │\n", "Total Credits", this.credits.size()));
        sb.append(String.format("│ %-19s │ %-30.2f │\n", "Total Cost", this.totalCredit()));
        sb.append(String.format("└─────────────────────┴────────────────────────────────┘"));
        return sb.toString();
    }
}
