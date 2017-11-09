import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Plane {

    private ArrayList<Seat> seats = new ArrayList<>();
    private String planeCode;
    private int turistClassPrice;
    private int buisnessClassPrice;


    Plane(int rows, int peoplePerRow, int buisnessRows) {
        for (int i = 1; i <= rows ; i++) {
            for (int j = 0; j < peoplePerRow; j++) {
                if (i <= buisnessRows) {
                    seats.add(new Seat(buisnessClassPrice,"" + i + (char)(j+97),"Buisness"));
                }else {
                    seats.add(new Seat(turistClassPrice,"" + i + (char)(j+97),"Turist"));
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
        ArrayList<Seat> availableSeatsOnDate = availableSeats(date);
        if (!validateSeats(seatsSelectedByUser,availableSeatsOnDate)) {
            throw new RuntimeException("Selected a bad seat you bastard");
        }
        for (Seat seat: seatsSelectedByUser){
            int index = this.seats.indexOf(seat);
            this.seats.get(index).reseveSeat(date, passenger);
            System.out.println(seat + "asd");
        }
    }

    //DEVUELVE TRUE SI TODOS LOS ASIENTOS EN "seatsSelectesByUser" ESTAN EN "freeSeatsOnDate" Y SI ENCUENTRA UNO QUE NO ESTA DEVUELVE FALSE
    private boolean validateSeats(ArrayList<Seat> seatsSelectedByUser , ArrayList<Seat> freeSeatsOnDate ){
        for (Seat seat: seatsSelectedByUser){
            if (!freeSeatsOnDate.contains(seat)){
                return false;
            }
        }
        return true;
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
