package Strategy;

public class Bank {
    private Payment payment;

    public Bank() {}

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void calc() {
        payment.calculating();
    }
}
