package MetroTicket;

import MetroTicket.Payment.PaymentType;
import MetroTicket.Person.TicketPerson;
import MetroTicket.Way.TicketWay;

public class Main {
    public static void main(String[] args) {
        FactoryTicket machine = new FactoryTicket();
        machine.choosingTicketType(TicketWay.TWO_WAY, TicketPerson.NORMAL);
        machine.choosingPaymentMethod(PaymentType.CASH);
        machine.completed();
    }
}
