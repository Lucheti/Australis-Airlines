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

    void reseveSeat(Date date ,Passenger passenger){ reserves.put(date, passenger); }
    void clearSeat(Date date){ reserves.remove(date); }
    boolean isFree(Date date){ return !reserves.containsKey(date); }

    @Override
    public String toString(){return position + " " + category ;}

    String getPosition() {
        return position;
    }

    int getPrice() {
        return price;
    }
}
