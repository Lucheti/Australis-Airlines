
import java.util.HashMap;

/**
 * Created by Nicole on 11/9/17.
 */
public class Pilot extends Employee {
    String area = "Pilot";
    HashMap<Date, Boolean> availability= new HashMap<>();
    Airport location;

    public Pilot(Airport location) {
        this.location = location;
    }

    public boolean getAvailability(Date date) {
        boolean available = false;
        if (availability.get(date) == true){
            available = true;
        }
        return available;
    }

}

