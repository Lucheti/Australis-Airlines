import java.util.HashMap;

public class Seat {
    private String position;
    private HashMap<Date,Passenger> reserves = new HashMap<>();
    private int price;
    private String category;

    Seat(int price , String position, String category) {

        this.price = price;
        this.position = position;
        this.category = category;
    }

    void reseveSeat(Flight flight ,Passenger passenger){ reserves.put(flight, passenger); }
    void clearSeat(Flight flight){ reserves.remove(flight); }
    boolean isFree(Flight flight){ return !reserves.containsKey(flight); }

    @Override
    public String toString(){return position + " " + category ;}

    String getPosition() {
        return position;
    }

    int getPrice() {
        return price;
    }
}
