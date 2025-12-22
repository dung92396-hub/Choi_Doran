package Java8_pack.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerManagementService {
    private final List<Customer> customers;

    // Constructor
    public CustomerManagementService() {
        this.customers = new ArrayList<>();
    }

    // Add customer
    public void addCustomer(Customer customer) {
        if (customer != null && !customers.stream().anyMatch(c -> c.getId().equals(customer.getId()))) {
            customers.add(customer);
            System.out.println("Đã thêm khách hàng: " + customer.getFullName());
        } else {
            System.out.println("Khách hàng với ID này đã tồn tại hoặc dữ liệu không hợp lệ!");
        }
    }

    public List<Customer> filterCustomerByPack(String packName) {
        return customers
                .stream()
                .filter(customer -> customer.getPack().getPackName().equals(packName))
                .toList();
    }



}
