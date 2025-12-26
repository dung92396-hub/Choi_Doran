package De1;

public class BillItem {
    private Drink drink;
    private int quantity;

    public BillItem(Drink drink, int quantity) {
        this.drink = drink;
        this.quantity = quantity;
    }

    public Drink getDrink() { return drink; }
    public void setDrink(Drink drink) { this.drink = drink; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
