import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Plane {

    ArrayList<Seat> seats = new ArrayList<>();
    String planeCode;
    int turistClassPrice;
    int buisnessClassPrice;


    public Plane(int rows, int peoplePerRow, int buisnessRows) {
        for (int i = 1; i <= rows ; i++) {
            for (int j = 0; j < peoplePerRow; j++) {
                if (i <= buisnessRows) {
                    seats.add(new Seat(buisnessClassPrice,"" + i + (char)(j+97)));
                }else {
                    seats.add(new Seat(turistClassPrice,"" + i + (char)(j+97)));
                }
            }
        }
    }


    public Seat[] reserveSeat(int cantidadDePersonas , Passenger passenger) {
        Seat[] returnSeats = new Seat[cantidadDePersonas];
        int counter = 0;
        return reserveSeat(cantidadDePersonas,counter,passenger, returnSeats);
    }
    private Seat[] reserveSeat(int cantidadDepersonas, int counter , Passenger passenger, Seat[] returnSeats){
        if (counter < cantidadDepersonas)
        for (Seat seat: seats){
            if (seat.isFree()){
                seat.reseveSeat(passenger);
                returnSeats[counter] = seat;
                counter++;
                return reserveSeat(cantidadDepersonas,counter,passenger,returnSeats);
            }
        }
        return returnSeats;
    }
    void print(){
        for (Seat seat: seats){
            System.out.println(seat.position);
        }
    }
}
