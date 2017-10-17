/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Seat {
    String position;
    Passenger passenger;
    int price;

    public Seat(int price , String position) {

        this.price = price;
        this.position = position;
    }

    void reseveSeat(Passenger passenger){this.passenger = passenger;}
    void clearSeat(){this.passenger = null;}
    boolean isFree(){ return this.passenger == null ; }

}
