import java.util.ArrayList;

/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Airport {

    String country;
    String airportCode;
    ArrayList<Plane> planes = new ArrayList<Plane>();

    public Airport(String airportCode) {
        this.airportCode = airportCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (airportCode != null ? !airportCode.equals(airport.airportCode) : airport.airportCode != null) return false;
        return planes != null ? planes.equals(airport.planes) : airport.planes == null;
    }

    public String toString(){
        return airportCode;
    }
    public String getCountry(){ return country; }

    private void landPlane (Plane plane){ planes.add(plane); }
    private void takeOffPlane (Plane plane) {
        if (planes.contains(plane)) {
            planes.remove(plane);
        }
        throw new RuntimeException("The plane is not in this airport");
    }
}

