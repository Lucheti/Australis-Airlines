/**
 * Created by lucasgarcia on 12/10/17.
 */
public class Ticket {
    Flight flight;

    public Ticket(Flight flight) {
        this.flight = flight;
    }

    public String toString (){
        return "Flight from " + flight.getFrom() + " to " + flight.getTo() + " the " + flight.getTakeOff();
    }
}
