import java.util.ArrayList;

public class Airport {

    private String airportCode;
    private ArrayList<Plane> planes = new ArrayList<>();

    Airport(String airportCode) {
        this.airportCode = airportCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        return (airportCode != null ? airportCode.equals(airport.airportCode) : airport.airportCode == null) && (planes != null ? planes.equals(airport.planes) : airport.planes == null);
    }

    public String toString(){
        return airportCode;
    }

    private void landPlane (Plane plane){ planes.add(plane); }
    private void takeOffPlane (Plane plane) {
        if (planes.contains(plane)) {
            planes.remove(plane);
        }
        throw new RuntimeException("The plane is not in this airport");
    }
}

