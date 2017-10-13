import java.util.ArrayList;

/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Airport {
    Location location;
    String airportCode;
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public Airport(Location location, String airportCode) {
        this.location = location;
        this.airportCode = airportCode;
    }
}

