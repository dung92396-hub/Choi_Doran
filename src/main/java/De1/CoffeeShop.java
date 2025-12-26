package De1;

import java.util.*;
import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CoffeeShop {

    private List<Bill> bills;

    public CoffeeShop(List<Bill> bills) {
        this.bills = bills;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
    // tìm đồ uống giá cao nhất
    public Drink findMostExpensiveDrink() {
        var c = Comparator.comparing(Drink::getPrice);
        return bills
                .stream()
                .flatMap(bill -> bill.getItems().stream())
                .map(BillItem::getDrink)
                .max(c)
                .orElseThrow();
    }

    // thống kê số lượng bán theo đồ uống
    public Map<String, Integer> salesByDrinkType() {
        return this.bills.stream()
                .flatMap(bill -> bill.getItems().stream())
                .collect(Collectors.groupingBy(billItem -> billItem.getDrink().getType(),
                Collectors.summingInt(BillItem::getQuantity)));

    }
    // kiểm tra có hóa đơn nào lập ngoài giờ hành chính không
    public boolean hasBillOutsideWorkingHours(LocalTime start, LocalTime end) {
       return bills
               .stream()
               .anyMatch(bill -> bill.ngoaiGioHanhChinh(start, end));
    }

    // trả về danh sách bill không trùng, dầnsắp xếp giảm
    public Set<Drink> getDistinctDrinksSortedByPriceDesc() {
        var c = Comparator.comparing(Drink::getPrice, Comparator.reverseOrder());
        return bills
                .stream()
                .flatMap(b -> b.getItems().stream())
                .map(BillItem::getDrink)
                .collect(Collectors.toCollection(() -> new TreeSet<>(c)));
    }

    // tra ve bill co thoi gian thanh toan som nhat trong 1 ngay
    public Bill paymentMostEarlyBill() {
        return bills
                .stream()
                .min(Comparator.comparing(Bill::getPaymentTime))
                .orElseThrow();
    }
}