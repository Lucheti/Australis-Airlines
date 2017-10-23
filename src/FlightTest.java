import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by lucasgarcia on 13/10/17.
 */
public class FlightTest {


@Test
   public void  test01(){

    //Setup harcodeado

    Api api = new Api();

    Plane plane1 = new Plane(10,4,2);
    Plane plane2 = new Plane(10,4,1);

    Airport airport1 = new Airport("AAA");
    Airport airport2 = new Airport("BBB");
    Airport airport3 = new Airport("CCC");
    Airport airport4 = new Airport("DDD");

    Date date1 = new Date(10,2);
    Date date2 = new Date(11,5);

    api.addAirport("A","AAA");
    api.addAirport("B","BBB");
    api.addAirport("C","CCC");
    api.addAirport("D","DDD");

    api.addFlight(plane1,api.getAirport("A"),api.getAirport("D"),date1);
    api.addFlight(plane2,api.getAirport("A"),api.getAirport("B"),date2);
    api.addFlight(plane1,api.getAirport("A"),api.getAirport("C"),date1);
    api.addFlight(plane1,api.getAirport("C"),api.getAirport("D"),date1);
    api.addFlight(plane2,api.getAirport("B"),api.getAirport("D"),date1);
    api.addFlight(plane1,api.getAirport("A"),api.getAirport("D"),date2);
    api.addFlight(plane2,api.getAirport("B"),api.getAirport("D"),date2);


    // test




    ArrayList<Flight> a = new ArrayList<>();
    a.add(new Flight(plane1,api.getAirport("A"),api.getAirport("D"),date1));

    ArrayList<ArrayList<Flight>> rta = api.sortByStop(a);

    for (ArrayList<Flight> flight: rta){
        System.out.println(flight.toString());
    }




}


}