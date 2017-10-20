import java.util.ArrayList;
import java.util.HashMap;

public class Api {

    Integer uniquePassengerNumber = 1;
    ArrayList<Flight> flights = new ArrayList<>();              //Lista con todos los vuelos de Australis
    ArrayList<Plane> planes = new ArrayList<>();                //Lista con todos los aviones de Australis
    HashMap<String,Airport> airports = new HashMap();           //mapa con todos los destinos y sus aeropuertos correspondientes
    HashMap<String,Passenger> passengers = new HashMap<>();     //mapa para guardar a los clientes, se pueden registrar y loguear


    public ArrayList<Flight> getFlights() {
        return flights;
    }                        //Getter
    public Airport getAirport (String country){
        if (airports.containsKey(country)){
            return airports.get(country);
        }
        throw new RuntimeException("Airport not found");
    }                                  //Getter

    void addFlight(Plane plane, Airport from, Airport to, Date date){
        flights.add(new Flight(plane, from, to, date));
    }            // Adder
    void addAirport(String country ,String airportCode){
        airports.put(country ,new Airport(airportCode));
    }                         // Adder
    void addAirplane(Plane plane){ planes.add(plane); }                              // Adder

    void registerNewPassenger(String dni , String name){
        passengers.put(uniquePassengerNumber.toString(), new Passenger(dni,name));
        uniquePassengerNumber++;
    }                         //Metodo para crear un nuevo usuario
    void validateLogin(String passengerNumber){
        if (passengers.containsKey(passengerNumber)){
            return;
        }
        throw new RuntimeException("User not found");
    }                                  //Metodo que determina si existe o no el usuario



    ArrayList<Flight> searchFlight(Airport from , Airport to , Date date){

        //este array va a ser devuelto al usuraio
        ArrayList<Flight> searchResult = flights;

        return sortByDate(sortByTo(sortByFrom(searchResult,from),to),date);
    }

    ArrayList<Flight> sortByFrom (ArrayList<Flight> list, Airport from){
        ArrayList<Flight> answer = new ArrayList<>();
        for (Flight flight: list){
            if (flight.getFrom().equals(from)){
                answer.add(flight);
//                System.out.println(flight.toString());
            }
        }
        return from == null? list : answer ;
    }

    ArrayList<Flight> sortByTo (ArrayList<Flight> list, Airport to){
        ArrayList<Flight> answer = new ArrayList<>();
        for (Flight flight: list){
            if (flight.getTo().equals(to)){
                answer.add(flight);
            }
        }
        return to == null? list : answer ;
    }

    ArrayList<Flight> sortByDate (ArrayList<Flight> list, Date date){
        ArrayList<Flight> answer = new ArrayList<>();
        for (Flight flight: list){
            if(flight.getDate().equals(date)){
                answer.add(flight);
            }
        }
        return date == null? list : answer ;
    }

    void sortByStop (ArrayList<Flight> list, int amountOfStops){
        for (Flight flight: list){

        }
    }

    Ticket reserveSeat (Flight flight, int cantidadDePersonas , Passenger passenger){
        Plane reservationPlane = flight.getPlane();
        Seat[] reservationSeat = reservationPlane.reserveSeat(cantidadDePersonas ,passenger);
        return new Ticket(flight);
    }


}
