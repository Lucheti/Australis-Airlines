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

    ArrayList<ArrayList<Flight>> sortByStop (ArrayList<Flight> list ){
        // stop_To --> desde la escala hasta el destino.
        // from_Stop --> desde el aeropuerto de salida hasta la escala.
        ArrayList<ArrayList<Flight>> answer = new ArrayList<>();
       // para 1 escala:
        //logica: agarro todos los vuelos que lleguen a destino y pregunto que vuelos salen del origen y llegan al punto de escala.
        for (Flight flight: list){
            ArrayList<Flight> stop_To = searchFlight(null,flight.getTo(),null);
            for (Flight stopTo: stop_To){
                ArrayList<Flight> from_Stop = searchFlight(flight.getFrom(),stopTo.getFrom(),null);
                    for (Flight fromStop: from_Stop) {
                        ArrayList<Flight> preAnswer = new ArrayList<>();
                        // si el destino del primer vuelo es el mismo que el de salida del segundo
                        // y si ambos vuelos son el mismo dia entonces se agregan los 2 vuelos a una lista
                        //y se la manda a "answer" que es la que sera devuelta al usuraio.
                        if ((fromStop.getTo().equals(stopTo.getFrom()))&&(fromStop.getDate().equals(stopTo.getDate()))){
                            preAnswer.add(fromStop);
                            preAnswer.add(stopTo);
                            answer.add(preAnswer);
                        }
                    }
            }


        }
        return answer;
    }

    Ticket reserveSeat (Flight flight, int cantidadDePersonas , Passenger passenger){
        Plane reservationPlane = flight.getPlane();
        Seat[] reservationSeat = reservationPlane.reserveSeat(cantidadDePersonas ,passenger);
        return new Ticket(flight);
    }


}
