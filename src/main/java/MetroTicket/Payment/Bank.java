package MetroTicket.Payment;

public class Bank implements Payment {
    @Override
    public void execute() {
        System.out.println("Phuong thuc thanh toan: " + this.getClass().getSimpleName());
    }
}
