package MetroTicket.Way;

import MetroTicket.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class TwoWay extends Ticket {

    private Ticket person;

    @Override
    public double execute() {
        return (DEFAULT_PRICE * 2 * 0.8) * person.execute();
    }
}
