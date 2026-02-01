package State;

public class ErrorVending implements State {
    VendingMachine machine;

    ErrorVending(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void ejectCoint() {
        System.out.println("Error vending is not active");
    }

    @Override
    public void insertCoin() {
        System.out.println("Error vending is not active");
    }

    @Override
    public void pressButton() {
        System.out.println("Error vending is not active");
    }
}
