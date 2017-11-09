
import java.util.HashMap;

class Pilot extends Employee {
    private String area = "Pilot";
    private HashMap<Date, Boolean> availability= new HashMap<>();
    private Airport location;

    Pilot(Airport inicialPilotAirport) {
        this.location = inicialPilotAirport;
    }



    boolean isAvailable(Date date) {
        boolean available = false;
        if (availability.get(date)){
            available = true;
        }
        return available;
    }

    public Airport getLocation() {
        return location;
    }
}

