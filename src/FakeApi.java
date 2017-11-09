import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nicole on 10/20/17.
 */
public class FakeApi {

    ArrayList<Flight> flights = new ArrayList<>();              //Lista con todos los vuelos de Australis
    ArrayList<Plane> planes = new ArrayList<>();                //Lista con todos los aviones de Australis
    HashMap<String,Airport> airports = new HashMap();           //mapa con todos los destinos y sus aeropuertos correspondientes
    HashMap<String,Passenger> passengers = new HashMap<>();     //mapa para guardar a los clientes, se pueden registrar y loguear

    public ArrayList<Flight> getFlights() {
        /* private Plane plane;
        *private Airport from;
        *private Airport to;
        *private Date date;
        */
        Plane a = new Plane(12, 5, 6,"asdasdasdasdas",null);
        Airport from = new Airport("Eze");
        Airport to = new Airport("Mia");
        Date date = new Date();
        Pilot pilot = new Pilot(from);


        Flight flighta = new Flight(a, from, to, date, pilot);
        flights.add(flighta);
        return flights;


    }                        //Getter
    public Airport getAirport (String country){
        Airport airport = new Airport("Eze");
        airports.put("Miami", airport);

        if (airports.containsKey(country)){
            return airports.get(country);
        }
        throw new RuntimeException("Airport not found");
    }                                  //Getter



    public ArrayList<Flight> searchFlight(Airport from , Airport to , Date date) {

        //este array va a ser devuelto al usuraio
        ArrayList<Flight> searchResult = flights;
        return searchResult;

    }


}
