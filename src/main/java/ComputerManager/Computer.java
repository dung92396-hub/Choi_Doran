package ComputerManager;

public class Computer {
    private String id;
    private String brand;
    private double price;
    private ComputerConfig config;

    public Computer(String id, String brand, double price, ComputerConfig config) {
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.config = config;
    }

    // Keep old constructor for backward compatibility
    public Computer(String id, String brand, double price) {
        this(id, brand, price, null);
    }

    public boolean isSameId(String id) {
        return this.id.equals(id);
    }

    public boolean isBetweenPrice(double min, double max) {
        return price >= min && price <= max;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public ComputerConfig getConfig() {
        return config;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setConfig(ComputerConfig config) {
        this.config = config;
    }

    @Override
    public String toString() {
        // Table-like row: | id | brand | price | config |
        String cfg = (config == null) ? "-" : String.format("CPU=%s, RAM=%dGB, SSD=%dGB, GPU=%s", config.getCpu(), config.getRamGB(), config.getStorageGB(), config.getGpu());
        return String.format("| %-12s | %-20s | %12.2f | %-40s |", id, brand, price, cfg);
    }
}
