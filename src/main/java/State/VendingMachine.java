package State;

import lombok.Data;

@Data
public class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State errorVending;

    private State currentState;

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        errorVending = new ErrorVending(this);

        currentState = noCoinState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoint();
    }

    public void pressButton() {
        currentState.pressButton();
    }
}
