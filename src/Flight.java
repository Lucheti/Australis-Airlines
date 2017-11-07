/**
 * Created by lucasgarcia on 11/10/17.
 */
public class Flight {

    private Plane plane;
    private Airport from;
    private Airport to;
    private Date date;

    public Flight(Plane plane, Airport from, Airport to, Date day) {
        this.plane = plane;
        this.from = from;
        this.to = to;
        this.date = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (getFrom() != null ? !getFrom().equals(flight.getFrom()) : flight.getFrom() != null) return false;
        if (getTo() != null ? !getTo().equals(flight.getTo()) : flight.getTo() != null) return false;
        return getDate() != null ? getDate().equals(flight.getDate()) : flight.getDate() == null;
    }

    public Plane getPlane() {
        return plane;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

    public String toString (){
        return "Flight from " + from + " to " + to + " the " + getDate();
    }



}
