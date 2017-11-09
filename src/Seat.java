import java.util.HashMap;

/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Seat {
    String position;
    HashMap<Flight,Passenger> reserves = new HashMap<>();
    int price;
    String category;

    public Seat(int price , String position, String category) {

        this.price = price;
        this.position = position;
        this.category = category;
    }

    void reseveSeat(Flight flight ,Passenger passenger){ reserves.put(flight, passenger); }
    void clearSeat(Flight flight){ reserves.remove(flight); }
    boolean isFree(Flight flight){ return !reserves.containsKey(flight); }

    @Override
    public String toString(){return position + " " + category ;}

    public String getPosition() {
        return position;
    }
}
