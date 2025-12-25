package OrderManager;

public class OrderItem {
    private Product p;
    private int quantity; // so luong

    public OrderItem(Product p, int quantity) {
        super();
        this.p = p;
        this.quantity = quantity;
    }

    public double cost() {
        return this.p.getPrice() * this.quantity;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("  | %-30s | %-15s | $%-10.2f | x%-3d | $%-10.2f |",
                p.getName(), p.getCategory(), p.getPrice(), quantity, p.getPrice() * quantity);
    }

    public static String getTableHeader() {
        return String.format("  | %-30s | %-15s | %-12s | %-5s | %-12s |",
                "Product Name", "Category", "Unit Price", "Qty", "Subtotal") + "\n" +
               "  +--------------------------------+-----------------+--------------+-------+--------------+";
    }

    public double getSubtotal() {
        return p.getPrice() * quantity;
    }
}
