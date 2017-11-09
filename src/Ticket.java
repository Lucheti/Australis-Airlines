import java.util.ArrayList;

public class Ticket {
    private Flight flight;
    private ArrayList<Seat> seats;
    private Passenger passenger;

    Ticket(Flight flight, ArrayList<Seat> userSeats,Passenger passenger) {

        this.flight = flight;
        this.seats = userSeats;
        this.passenger = passenger;
    }

    public String toString (){
        StringBuilder seatList = new StringBuilder();
        for (Seat seat: seats){
            seatList.append(seat.position).append(" ");
        }
        return "Flight from " + flight.getFrom() + " to " + flight.getTo() + " the " + flight.getDate() + " " + seatList + " " + passenger.getName();
    }
}
