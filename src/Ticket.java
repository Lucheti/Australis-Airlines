import java.util.ArrayList;

/**
 * Created by lucasgarcia on 12/10/17.
 */
public class Ticket {
    Flight flight;
    ArrayList<Seat> seats;

    public Ticket(Flight flight, ArrayList<Seat> userSeats) {

        this.flight = flight;
        this.seats = userSeats;
    }

    public String toString (){
        String seatList = "";
        for (Seat seat: seats){
            seatList += seat.position + " ";
        }
        return "Flight from " + flight.getFrom() + " to " + flight.getTo() + " the " + flight.getDate() + " " + seatList;
    }
}
