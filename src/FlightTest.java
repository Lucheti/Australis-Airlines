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

    Api api = new Api();
    Plane plane1 = new Plane(10,4,2);
    Plane plane2 = new Plane(10,4,1);
    Airport airport1 = new Airport("AAA");
    Airport airport2 = new Airport("BBB");
    Airport airport3 = new Airport("CCC");
    Airport airport4 = new Airport("DDD");

    Date date1 = new Date(10,2);
    Date date2 = new Date(11,5);
    Flight flight1 = new Flight(null,airport1,airport2,date1);
    Flight flight2 = new Flight(null,airport1,airport2,date1);
    Flight flight3 = new Flight(null,airport3,airport1,date1);
    Flight flight4 = new Flight(null,airport2,airport1,date1);
    Flight flight5 = new Flight(null,airport4,airport4,date1);
    Flight flight6 = new Flight(null,airport1,airport3,date1);
    Flight flight7 = new Flight(null,airport2,airport4,date1);


    api.addFlight(flight1);
    api.addFlight(flight2);
    api.addFlight(flight3);
    api.addFlight(flight4);
    api.addFlight(flight5);
    api.addFlight(flight6);
    api.addFlight(flight7);



    ArrayList<Flight> a = api.getFlights();

    a = api.sortByFrom(a,airport1);

//    for (Flight flight: a){
//        System.out.println(flight.toString());
//    }




}


}