import java.util.HashMap;

/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Plane {

    HashMap<String,Seat> seats = new HashMap<String, Seat>();
    String planeCode;
    int turistClassPrice;
    int buisnessClassPrice;


    public void Plane(int rows, int peoplePerRow, int buisnessRows) {
        for (int i = 1; i <= rows ; i++) {
            for (Integer j = 1; j <= peoplePerRow; j++) {
                if (i <= buisnessRows) {
                    seats.put(i + j.toString(), new Seat(buisnessClassPrice));
                }else {
                    seats.put(i + j.toString() , new Seat(turistClassPrice));
                }
            }
        }
    }


}
