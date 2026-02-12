package Adapter;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalLib payPalLib;
    public PayPalAdapter(PayPalLib payPalLib) {
        this.payPalLib = payPalLib;
    }

    @Override
    public void processPayment(double amountVND) {
        payPalLib.sendPayment(amountVND);
        System.out.println("Convert completed!");
    }

    public static void main(String[] args) {

    }
}
