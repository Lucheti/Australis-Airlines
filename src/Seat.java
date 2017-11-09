import java.util.HashMap;

/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Seat {
    String position;
    HashMap<Date,Passenger> reserves = new HashMap<>();
    int price;
    String category;

    public Seat(int price , String position, String category) {

        this.price = price;
        this.position = position;
        this.category = category;
    }

    void reseveSeat(Date date ,Passenger passenger){ reserves.put(date, passenger); }
    void clearSeat(Date date){ reserves.remove(date); }
    boolean isFree(Date date){ return !reserves.containsKey(date); }

    @Override
    public String toString(){return position + " " + category ;}

    public String getPosition() {
        return position;
    }
}
