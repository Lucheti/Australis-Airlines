import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Plane {

    private ArrayList<Seat> seats = new ArrayList<>();
    private String planeCode;

    Plane(int rows, int peoplePerRow, int buisnessRows , String planeCode , PriceCatalog priceCatalog) {

        this.planeCode = planeCode;

        for (int i = 1; i <= rows ; i++) {
            for (int j = 0; j < peoplePerRow; j++) {
                if (i <= buisnessRows) {
                    seats.add(new Seat(priceCatalog.getPrice("Buisness"),"" + i + (char)(j+97),"Buisness"));
                }else {
                    seats.add(new Seat(priceCatalog.getPrice("Turist"),"" + i + (char)(j+97),"Turist"));
                }
            }
        }
    }


    ArrayList<Seat> availableSeats(Flight flight){
        ArrayList<Seat> seats = new ArrayList<>();
        for (Seat seat: this.seats){
            if (seat.isFree(flight)){
                seats.add(seat);
            }
        }
        return seats;
    }

    void reserveSeats (ArrayList<Seat> seatsSelectedByUser ,Flight flight , Passenger passenger){
        ArrayList<Seat> availableSeatsOnDate = availableSeats(flight);
        if (!validateSeats(seatsSelectedByUser,availableSeatsOnDate)) {
            throw new RuntimeException("Selected a bad seat you bastard");
        }
        for (Seat seat: seatsSelectedByUser){
            int index = this.seats.indexOf(seat);
            this.seats.get(index).reseveSeat(flight, passenger);
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

    public String getPlaneCode() {
        return planeCode;
    }

    void print(){
        for (Seat seat: seats){
            System.out.println(seat.getPosition());
        }
    }
}
