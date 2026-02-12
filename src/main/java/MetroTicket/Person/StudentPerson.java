package MetroTicket.Person;

import MetroTicket.Ticket;

public class StudentPerson extends Ticket {
    @Override
    public double execute() {
        return 0.64;
    }
}
