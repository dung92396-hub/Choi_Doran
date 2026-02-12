package MetroTicket.Payment;

public class Visa implements Payment {
    @Override
    public void execute() {
        System.out.println("Phuong thuc thanh toan " + getClass().getSimpleName());
    }
}
