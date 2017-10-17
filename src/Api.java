import java.util.ArrayList;
import java.util.HashMap;

public class Api {
    Integer uniquePassengerNumber = 1;

    ArrayList<Flight> flights = new ArrayList<>();  //Una lista con todos los vuelos de Australis

    ArrayList<Plane> planes = new ArrayList<>(); // Lista con todos los aviones de Australis

    HashMap<String,Passenger> passengers = new HashMap<>();  //mapa para guardar a los clientes, se pueden registrar y loguear

    void addFlight(Flight flight){
        flights.add(flight);
    }
    void addAirport(){}
    void addAirplane(Plane plane){ planes.add(plane); }

    void registerNewPassenger(String dni , String name){
        passengers.put(uniquePassengerNumber.toString(), new Passenger(dni,name));
        uniquePassengerNumber++;
    } //Metodo para crear un nuevo usuario

    void validateLogin(String passengerNumber){
        if (passengers.containsKey(passengerNumber)){
            return;
        }
        throw new RuntimeException("User not found");
    } //Metodo que determina si existe o no el usuario



    ArrayList<Flight> searchFlight(Airport from , Airport to , Date date){

        //este array va a ser devuelto al usuraio
        ArrayList<Flight> searchResult = new ArrayList<>();

        //creo un vuelo con los datos del cliente para comprarlo con los de flights (el avion es null pq no se que avion tendra)
        Flight search = new Flight(null,from,to,date);

        for (Flight flight: flights){
            if (search.equals(flight)){
                searchResult.add(flight);
            }
        }
        return searchResult;
    }
    Ticket reserveSeat (Flight flight, int cantidadDePersonas , Passenger passenger){
        Plane reservationPlane = flight.getPlane();
        Seat[] reservationSeat = reservationPlane.reserveSeat(cantidadDePersonas ,passenger);
        return new Ticket();
    }


}
