package MetroTicket.MachineState;

import MetroTicket.FactoryTicket;
import MetroTicket.Payment.Payment;
import MetroTicket.Payment.PaymentType;
import MetroTicket.Person.TicketPerson;
import MetroTicket.Ticket;
import MetroTicket.Way.TicketWay;

public class Completed extends State {
    public Completed(FactoryTicket factoryTicket) {
        super(factoryTicket);
    }

    @Override
    public Ticket choosingTicketType(TicketWay t1, TicketPerson t2) {
        throw new RuntimeException("Vui long xac nhan de mua ve tiep");
    }

    @Override
    public Payment choosingPaymentMethod(PaymentType payment) {
        throw new RuntimeException("Vui long xac nhan de mua ve tiep");
    }

    @Override
    public void completed() {
        System.out.println("Hoan tat mua ve!");
        System.out.println("Loai ve: " +
                this.factoryTicket
                .getTicket()
                .getClass()
                .getSimpleName() +
                ", " +
                this.factoryTicket
                        .getPayment()
                        .getClass()
                        .getSimpleName());
        System.out.println("Da thanh toan; " + this.factoryTicket.getTicket().execute() + "VND");
    }
}
