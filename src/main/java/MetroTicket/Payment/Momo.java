package MetroTicket.Payment;

public class Momo implements Payment {
    @Override
    public void execute() {
        System.out.println("Phuong thuc thanh toan: " + this.getClass().getSimpleName());
    }
}
