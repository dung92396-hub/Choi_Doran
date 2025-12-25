package OrderManager;

public class Customer {
    private Long id;
    private String name;
    private int tier;//Hạng của khách hàng

    public Customer(Long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-30s | Tier %-2d |",
                id, name, tier);
    }

    public static String getTableHeader() {
        return String.format("| %-5s | %-30s | %-8s |",
                "ID", "Customer Name", "Tier") + "\n" +
               "+-------+--------------------------------+----------+";
    }
}
