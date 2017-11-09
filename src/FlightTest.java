import org.junit.Test;

import java.util.ArrayList;


public class FlightTest {


@Test
   public void  test01(){

    Api api = new Api();
    boolean programIsRuning = true;
    boolean logged = false;
    Passenger passenger = new Passenger("default","default");

    api.addPlane(10,4,2);
    api.addPlane(10,4,1);

    Date date1 = new Date(19,1,23,00);
    Date date2 = new Date(21,5,06,24);
    Date date3 = new Date(15,7,01,01);
    Date date4 = new Date(21,1,23,00);
    Date date5 = new Date(21,5,04,00);


    api.addAirport("A","AAA");
    api.addAirport("B","BBB");
    api.addAirport("C","CCC");
    api.addAirport("D","DDD");

    api.addFlight(api.getPlane(0),api.getAirport("A"),api.getAirport("D"),date1);
    api.addFlight(api.getPlane(0),api.getAirport("A"),api.getAirport("B"),date1);
    api.addFlight(api.getPlane(0),api.getAirport("A"),api.getAirport("C"),date1);
    api.addFlight(api.getPlane(0),api.getAirport("C"),api.getAirport("D"),date3);
    api.addFlight(api.getPlane(1),api.getAirport("B"),api.getAirport("D"),date5);
    api.addFlight(api.getPlane(0),api.getAirport("A"),api.getAirport("C"),date2);
    api.addFlight(api.getPlane(1),api.getAirport("B"),api.getAirport("C"),date2);
    api.addFlight(api.getPlane(1),api.getAirport("C"),api.getAirport("B"),date2);
    api.addFlight(api.getPlane(1),api.getAirport("B"),api.getAirport("D"),date2);
    api.addFlight(api.getPlane(1),api.getAirport("D"),api.getAirport("C"),date2);


    for (ArrayList<Flight> flight: api.searchFlight(api.getAirport("A"),null,date2,2)){
        System.out.println(flight);
    }
    for (Flight flight: api.flights){
        System.out.println(flight);
    }
   }

}


