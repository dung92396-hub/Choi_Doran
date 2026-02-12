package MetroTicket;

import MetroTicket.MachineState.Completed;
import MetroTicket.MachineState.HasMoney;
import MetroTicket.MachineState.HasNoMoney;
import MetroTicket.MachineState.State;
import MetroTicket.Payment.Payment;
import MetroTicket.Payment.PaymentType;
import MetroTicket.Person.TicketPerson;
import MetroTicket.Way.TicketWay;
import lombok.Getter;
import lombok.Setter;

public class FactoryTicket {
    @Getter
    private Ticket ticket;
    @Getter
    private Payment payment;

    @Getter
    private HasNoMoney hasNoMoney;
    @Getter
    private HasMoney hasMoney;
    @Getter
    private Completed completed;

    @Setter
    private State currentState;

    public FactoryTicket() {
        this.hasNoMoney = new HasNoMoney(this);
        this.hasMoney = new HasMoney(this);
        this.completed = new Completed(this);
        this.currentState = hasNoMoney;
    }

    public void choosingTicketType(TicketWay t1, TicketPerson t2) {
        this.ticket = currentState.choosingTicketType(t1, t2);
    }

    public void choosingPaymentMethod(PaymentType payment) {
        this.payment = currentState.choosingPaymentMethod(payment);
    }

    public void completed() {
        currentState.completed();
    }

    public void reset() {
        currentState = hasNoMoney;
    }
}
