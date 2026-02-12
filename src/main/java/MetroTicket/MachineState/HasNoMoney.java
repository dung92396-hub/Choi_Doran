package MetroTicket.MachineState;

import MetroTicket.FactoryTicket;
import MetroTicket.Payment.Payment;
import MetroTicket.Payment.PaymentType;
import MetroTicket.Person.NormalPerson;
import MetroTicket.Person.SpecialPerson;
import MetroTicket.Person.StudentPerson;
import MetroTicket.Person.TicketPerson;
import MetroTicket.Ticket;
import MetroTicket.Way.OneWay;
import MetroTicket.Way.TicketWay;
import MetroTicket.Way.TwoWay;


public class HasNoMoney extends State {
    public HasNoMoney(FactoryTicket factoryTicket) {
        super(factoryTicket);
    }

    @Override
    public Ticket choosingTicketType(TicketWay t1, TicketPerson t2) {
        this.factoryTicket.setCurrentState(factoryTicket.getHasMoney());
        return getTicket(t1, t2);
    }

    @Override
    public Payment choosingPaymentMethod(PaymentType payment) {
        throw new RuntimeException("Chua chon ve");
    }

    @Override
    public void completed() {
        throw new RuntimeException("Chua chon ve");
    }

    public Ticket getTicket(TicketWay t1, TicketPerson t2) {
        return switch (t1) {
            case t1.ONE_WAY -> new OneWay(this.getTicketPerson(t2));
            case t1.TWO_WAY -> new TwoWay(this.getTicketPerson(t2));
        };
    }

    private Ticket getTicketPerson(TicketPerson t2) {
        return switch (t2) {
            case t2.NORMAL -> new NormalPerson();
            case t2.SPECIAL -> new SpecialPerson();
            case t2.STUDENT -> new StudentPerson();
        };
    }
}
