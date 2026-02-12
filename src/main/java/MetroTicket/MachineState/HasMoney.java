package MetroTicket.MachineState;

import MetroTicket.FactoryTicket;
import MetroTicket.Payment.*;
import MetroTicket.Person.TicketPerson;
import MetroTicket.Ticket;
import MetroTicket.Way.TicketWay;


public class HasMoney extends State {

    public HasMoney(FactoryTicket factoryTicket) {
        super(factoryTicket);
    }

    @Override
    public Ticket choosingTicketType(TicketWay t1, TicketPerson t2) {
        System.out.println("Da chon ve roi, moi chon thanh toan");
        return null;
    }

    @Override
    public Payment choosingPaymentMethod(PaymentType payment) {
        this.factoryTicket.setCurrentState(factoryTicket.getCompleted());
        return getPaymentMethod(payment);
    }

    @Override
    public void completed() {
        throw new RuntimeException("Vui long hoan tat thanh toan");
    }

    public Payment getPaymentMethod(PaymentType type) {
        return switch (type) {
            case BANK -> new Bank();
            case CASH -> new Cash();
            case MOMO -> new Momo();
            case CREDIT-> new Credit();
            case VISA -> new Visa();
        };
    }
}
