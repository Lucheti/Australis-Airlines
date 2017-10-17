import java.util.ArrayList;

/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Airport {

    String airportCode;
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public Airport(String airportCode) {
        this.airportCode = airportCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (airportCode != null ? !airportCode.equals(airport.airportCode) : airport.airportCode != null) return false;
        return flights != null ? flights.equals(airport.flights) : airport.flights == null;
    }

    public String toString(){
        return airportCode;
    }
}

