package State;

public class NoCoinState implements State {
    VendingMachine machine;

    NoCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coins received");
        machine.setState(machine.getHasCoinState());
    }

    @Override
    public void ejectCoint() {
        System.out.println("Coins not found");
    }

    @Override
    public void pressButton() {
        System.out.println("Please insert coins");
    }
}
