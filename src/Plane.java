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


    ArrayList<Seat> availableSeats(Date date){
        ArrayList<Seat> seats = new ArrayList<>();
        for (Seat seat: this.seats){
            if (seat.isFree(date)){
                seats.add(seat);
            }
        }
        return seats;
    }

    void reserveSeats (ArrayList<Seat> seatsSelectedByUser ,Date date , Passenger passenger){
        ArrayList<Seat> freeSeatsOnDate = availableSeats(date);
        for (Seat userSeat: seatsSelectedByUser){
            if (freeSeatsOnDate.contains(userSeat)){
                int index = this.seats.indexOf(userSeat);
                this.seats.get(index).reseveSeat(date,passenger);
            }
        }
    }





    void print(){
        for (Seat seat: seats){
            System.out.println(seat.position);
        }
    }
    void print(Date date){
        for (Seat seat: seats){
            System.out.println(seat.position);
            System.out.println(seat.isFree(date));
        }
    }
}
