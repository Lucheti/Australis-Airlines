import java.util.ArrayList;
import java.util.HashMap;

public class Api {

    Integer uniquePassengerNumber = 0;
    ArrayList<Flight> flights = new ArrayList<>();              //Lista con todos los vuelos de Australis
    ArrayList<Plane> planes = new ArrayList<>();                //Lista con todos los aviones de Australis
    HashMap<String,Airport> airports = new HashMap();           //mapa con todos los destinos y sus aeropuertos correspondientes
    HashMap<String,Passenger> passengers = new HashMap<>();     //mapa para guardar a los clientes, se pueden registrar y loguear


    public ArrayList<Flight> getFlights() {
        return flights;
    }
    public Airport getAirport (String country){
        if (airports.containsKey(country)){
            return airports.get(country);
        }
        throw new RuntimeException("Airport not found");
    }
    public Plane getPlane ( int index ){return planes.get(index); }

    void addFlight(Plane plane, Airport from, Airport to, Date date){
        flights.add(new Flight(plane, from, to, date));
    }
    void addAirport(String country ,String airportCode){
        airports.put(country ,new Airport(airportCode));
    }
    void addPlane(int rows,int peoplePerRow,int buisnessRows){
        planes.add(new Plane(rows,peoplePerRow,buisnessRows));
    }

    Integer registerNewPassenger(String dni , String name){
        uniquePassengerNumber++;
        passengers.put(uniquePassengerNumber.toString(), new Passenger(dni,name));
        return uniquePassengerNumber;
    }
    Passenger login(Integer passengerNumber){
        if (validateLogin(passengerNumber)){
            return passengers.get(passengerNumber.toString());
        }
        throw new RuntimeException();
    }
    boolean validateLogin(Integer passengerNumber){
        return passengers.containsKey(passengerNumber.toString());
    }

    String airportList(){
        String answer = "";
        for (String country: airports.keySet()){
            answer += country + "\n";
        }
        return answer;
    }


    ArrayList<ArrayList<Flight>> searchFlight(Airport from , Airport to , Date date , int numberOfStops){

        //este array va a ser devuelto al usuraio
        ArrayList<Flight> searchResult = flights;

        return sortByStop(sortByDate(sortByTo(sortByFrom(searchResult,from),to),date),numberOfStops);
    }
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

    ArrayList<ArrayList<Flight>> sortByStop (ArrayList<Flight> list , int numberOfStops){

        ArrayList<ArrayList<Flight>> answer = new ArrayList<>();
        if (numberOfStops == 2){
            for (Flight flight: list) {
                ArrayList<Flight> stop2_To = searchFlight(null, flight.getTo(), null);
                for (Flight stop_To: stop2_To){
                    //todos los que salgan del origen
                    ArrayList<Flight> from_stop1 = searchFlight(flight.getFrom(), null, null);
                    for (Flight from_stop: from_stop1){
                        ArrayList<Flight> stop2 = searchFlight(from_stop.getTo(),stop_To.getFrom(),null);
                        for (Flight stop: stop2){
                            if((from_stop.getDate().isBefore(stop.getDate()))&&(stop.getDate().isBefore(stop_To.getDate()))) {
                                ArrayList<Flight> preAnswer = new ArrayList<>();
                                preAnswer.add(from_stop);
                                preAnswer.add(stop);
                                preAnswer.add(stop_To);
                                answer.add(preAnswer);
                            }
                        }

                    }
                }

            }
            numberOfStops--;
        }
        if (numberOfStops == 1){
            for (Flight flight: list){
                ArrayList<Flight> stop_To = searchFlight(null,flight.getTo(),null);
                for (Flight stopTo: stop_To){
                    ArrayList<Flight> from_Stop = searchFlight(flight.getFrom(),stopTo.getFrom(),null);
                    for (Flight fromStop: from_Stop) {
                        ArrayList<Flight> preAnswer = new ArrayList<>();
                        // si el destino del primer vuelo es el mismo que el de salida del segundo
                        // y si ambos vuelos son el mismo dia entonces se agregan los 2 vuelos a una lista
                        //y se la manda a "answer" que es la que sera devuelta al usuraio.
                        if ((fromStop.getTo().equals(stopTo.getFrom()))&&(fromStop.getDate().isBefore(stopTo.getDate()))){
                            preAnswer.add(fromStop);
                            preAnswer.add(stopTo);
                            answer.add(preAnswer);
                        }
                    }
                }


            }
        }
        if (answer.size() == 0 ){
            answer.add(list);
            return answer;
        }
        return answer;
    }

//    ArrayList<ArrayList<Flight>> sortByStop1 (ArrayList<Flight> list ){
//        // stop_To --> desde la escala hasta el destino.
//        // from_Stop --> desde el aeropuerto de salida hasta la escala.
//        ArrayList<ArrayList<Flight>> answer = new ArrayList<>();
//       // para 1 escala:
//        //logica: agarro todos los vuelos que lleguen a destino y pregunto que vuelos salen del origen y llegan al punto de escala.
//        for (Flight flight: list){
//            ArrayList<Flight> stop_To = searchFlight(null,flight.getTo(),null);
//            for (Flight stopTo: stop_To){
//                ArrayList<Flight> from_Stop = searchFlight(flight.getFrom(),stopTo.getFrom(),null);
//                    for (Flight fromStop: from_Stop) {
//                        ArrayList<Flight> preAnswer = new ArrayList<>();
//                        // si el destino del primer vuelo es el mismo que el de salida del segundo
//                        // y si ambos vuelos son el mismo dia entonces se agregan los 2 vuelos a una lista
//                        //y se la manda a "answer" que es la que sera devuelta al usuraio.
//                        if (fromStop.getDate().isBefore(stopTo.getDate())){
//                            preAnswer.add(fromStop);
//                            preAnswer.add(stopTo);
//                            answer.add(preAnswer);
//                        }
//                    }
//            }
//
//
//        }
//        return answer;
//    }
//    ArrayList<ArrayList<Flight>> sortByStop2 (ArrayList<Flight> list ) {
//        ArrayList<ArrayList<Flight>> answer = new ArrayList<>();
//        //todos los vuelos q lleguen a destino
//        for (Flight flight: list) {
//            ArrayList<Flight> stop2_To = searchFlight(null, flight.getTo(), null);
//            for (Flight stop_To: stop2_To){
//            //todos los que salgan del origen
//            ArrayList<Flight> from_stop1 = searchFlight(flight.getFrom(), null, null);
//            for (Flight from_stop: from_stop1){
//                ArrayList<Flight> stop2 = searchFlight(from_stop.getTo(),stop_To.getFrom(),null);
//                    for (Flight stop: stop2){
//                        if((from_stop.getDate().isBefore(stop.getDate()))&&(stop.getDate().isBefore(stop_To.getDate()))) {
//                            ArrayList<Flight> preAnswer = new ArrayList<>();
//                            preAnswer.add(from_stop);
//                            preAnswer.add(stop);
//                            preAnswer.add(stop_To);
//                            answer.add(preAnswer);
//                        }
//                    }
//
//                }
//            }
//
//        }
//        return answer;
//    }


//        Ticket reserveSeat (Flight flight, int cantidadDePersonas , Passenger passenger){
//            Plane reservationPlane = flight.getPlane();
//            Seat[] reservationSeat = reservationPlane.reserveSeat(cantidadDePersonas, flight.getDate(), passenger);
//            return new Ticket(flight, reservationSeat);
//        }

    ArrayList<Seat> availableSeats(Flight flight){
        return flight.getPlane().availableSeats(flight.getDate());
    }

    Ticket reserveSeats(Flight flight , ArrayList<Seat> userSeats, Passenger passengerId){
        flight.getPlane().reserveSeats(userSeats,flight.getDate(),passengerId);
        return new Ticket(flight,userSeats);
    }

}
