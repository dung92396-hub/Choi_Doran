package MetroTicket.Way;

import MetroTicket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OneWay extends Ticket {

    private Ticket person;

    @Override
    public double execute() {
        return DEFAULT_PRICE * person.execute();
    }
}
