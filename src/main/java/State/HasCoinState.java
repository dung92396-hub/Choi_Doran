package State;

public class HasCoinState implements State {
    VendingMachine machine;

    HasCoinState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Cannot insert the coins becase coins are existed");
    }

    @Override
    public void ejectCoint() {
        System.out.println("Coins have eject");
        machine.setState(machine.getNoCoinState());
    }

    @Override
    public void pressButton() {
        System.out.println("Getting water... successful");
        machine.setState(machine.getNoCoinState());
    }
}
