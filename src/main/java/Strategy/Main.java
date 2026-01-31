package Strategy;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.setPayment(new BIDV());
        bank.calc();
    }
}
