package MetroTicket.MachineState;

import MetroTicket.FactoryTicket;
import MetroTicket.Payment.Payment;
import MetroTicket.Payment.PaymentType;
import MetroTicket.Person.TicketPerson;
import MetroTicket.Ticket;
import MetroTicket.Way.TicketWay;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class State {

    protected FactoryTicket factoryTicket;

    public abstract Ticket choosingTicketType(TicketWay t1, TicketPerson t2);
    public abstract Payment choosingPaymentMethod(PaymentType payment);
    public abstract void completed();
}
