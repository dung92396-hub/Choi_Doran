package MetroCredit;

public class TestToString {
    public static void main(String[] args) {
        // Test Credit toString
        System.out.println("=== CREDIT TEST ===");
        Credit credit1 = new Credit(1001L, Type.ONE_WAY, Location.BEN_THANH, Location.SUOI_TIEN);
        System.out.println(credit1);
        System.out.println();

        // Test Tram toString
        System.out.println("=== TRAM TEST ===");
        Tram tram1 = new Tram(Location.BEN_THANH, 1);
        System.out.println(tram1);
        System.out.println();

        // Test Customer toString
        System.out.println("=== CUSTOMER TEST ===");
        Customer customer1 = new Customer(1L, "Nguyen Van A", 25);
        customer1.addCredit(1001L, Type.ONE_WAY, Location.BEN_THANH, Location.SUOI_TIEN);
        customer1.addCredit(1002L, Type.TWO_WAYS, Location.THAO_DIEN, Location.BA_SON);
        customer1.addCredit(1003L, Type.ONE_WAY, Location.AN_PHU, Location.VAN_THANH);
        System.out.println(customer1);
        System.out.println();

        // Test CustomerManager toString
        System.out.println("=== CUSTOMER MANAGER TEST ===");
        CustomerManager manager = new CustomerManager();
        manager.addCustomer(1L, "Nguyen Van A", 25);
        manager.addCustomer(2L, "Tran Thi B", 30);
        manager.addCustomer(3L, "Le Van C", 22);

        Customer c1 = manager.getCustomerById(1L);
        c1.addCredit(1001L, Type.ONE_WAY, Location.BEN_THANH, Location.SUOI_TIEN);
        c1.addCredit(1002L, Type.TWO_WAYS, Location.THAO_DIEN, Location.BA_SON);

        Customer c2 = manager.getCustomerById(2L);
        c2.addCredit(2001L, Type.ONE_WAY, Location.BEN_THANH, Location.RACH_CHIEC);
        c2.addCredit(2002L, Type.TWO_WAYS, Location.AN_PHU, Location.VAN_THANH);

        Customer c3 = manager.getCustomerById(3L);
        c3.addCredit(3001L, Type.ONE_WAY, Location.SUOI_TIEN, Location.BEN_THANH);

        System.out.println(manager);
        System.out.println();

        // Display all customers
        System.out.println("=== ALL CUSTOMERS ===");
        System.out.println(c1);
        System.out.println();
        System.out.println(c2);
        System.out.println();
        System.out.println(c3);
    }
}

