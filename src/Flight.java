/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Flight {

    private Plane plane;
    private Airport from;
    private Airport to;
    private Date date;
    private Pilot pilot;

    Flight(Plane plane, Airport from, Airport to, Date day) {
        this.plane = plane;
        this.from = from;
        this.to = to;
        this.date = day;
        this.pilot = pilot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        return (getFrom() != null ? getFrom().equals(flight.getFrom()) : flight.getFrom() == null) && (getTo() != null ? getTo().equals(flight.getTo()) : flight.getTo() == null) && (getDate() != null ? getDate().equals(flight.getDate()) : flight.getDate() == null);
    }

    Plane getPlane() {
        return plane;
    }

    Airport getFrom() {
        return from;
    }

    Airport getTo() {
        return to;
    }

    Date getDate() {
        return date;
    }

    public String toString (){
        return "Flight from " + from + " to " + to + " the " + getDate();
    }



}
