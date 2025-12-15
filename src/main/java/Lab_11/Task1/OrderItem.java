package Lab_11.Task1;

public class OrderItem {
    private Product item;
    private int amount;

    public OrderItem(Product item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public int cost() {
        return amount * item.getPrice();
    }

    public String getType() {
        return item.getType();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderItem{");
        sb.append("item=").append(item);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
