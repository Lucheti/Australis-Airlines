import java.util.ArrayList;

/**
 * Created by lucasgarcia on 2/11/17.
 */
public class ClientApp {
    public static void main(String[] args) {

        Api api = new Api();
        boolean programIsRuning = true;
        boolean logged = false;
        Passenger passenger = new Passenger("default","default");

        api.addPlane(10,4,2);
        api.addPlane(10,4,1);



        Date date4 = new Date(19,1);
        Date date1 = new Date(19,1);
        Date date2 = new Date(11,5);
        Date date3 = new Date(15,7);

        api.addAirport("A","AAA");
        api.addAirport("B","BBB");
        api.addAirport("C","CCC");
        api.addAirport("D","DDD");

        api.addFlight(api.getPlane(0),api.getAirport("A"),api.getAirport("D"),date1);
        api.addFlight(api.getPlane(0),api.getAirport("A"),api.getAirport("B"),date1);
        api.addFlight(api.getPlane(0),api.getAirport("A"),api.getAirport("C"),date1);
        api.addFlight(api.getPlane(0),api.getAirport("C"),api.getAirport("D"),date3);
        api.addFlight(api.getPlane(1),api.getAirport("B"),api.getAirport("D"),date1);
        api.addFlight(api.getPlane(0),api.getAirport("A"),api.getAirport("C"),date2);
        api.addFlight(api.getPlane(1),api.getAirport("B"),api.getAirport("C"),date2);
        api.addFlight(api.getPlane(1),api.getAirport("C"),api.getAirport("B"),date2);
        api.addFlight(api.getPlane(1),api.getAirport("B"),api.getAirport("D"),date2);

        while (programIsRuning) {
            while (!logged) {
                int option = Scanner.getInt("1: login \n2: register\n");
                switch (option) {
                    case 1:
                            passenger= api.login(Scanner.getString("enter your passenger number"));
                            System.out.println("logged in as " + passenger.getName());
                            logged = true;
                            break;

                    case 2: api.registerNewPassenger(Scanner.getString("Dni\n"),Scanner.getString("name\n"));
                            System.out.println("Register succesfull\n");
                            break;
                }
            }
            while (logged) {
                int option = Scanner.getInt("opciones: \n 1: buscar un vuelo\n 2:ver historial de vuelo\n 6:quit\n 7:logout ");
                switch (option) {
                    case 1:
                            //SE LE PIDE AL USUARIO AEROPUERTO DE SALIDA , LLEGADA , DIA , CANTIDAD DE ESCALAS Y CANTIDAD DE PASAJEROS
                            Airport from = api.getAirport(Scanner.getString("Aeropuerto de salida:\n" + api.airportList()).toUpperCase());
                            Airport to = api.getAirport(Scanner.getString("\nAeropuerto de llegada: \n" + api.airportList()).toUpperCase());
                            int numberOfstops = Scanner.getInt("Numero de escalas: \n0 (Vuelo directo) \n1 \n2 \n3 (Me es indiferente) ");
                            Date date = new Date(Scanner.getInt("dia"), Scanner.getInt("mes"));
                            int numberOfPassengers = Scanner.getInt("Cuantas personas viajan?\n");

                            //BUSQUEDA DE TODAS LAS POSIBLES COMBINACIONES DE VUELOS CON RESPECTO A LOS PARAMETROS INDICADOS
                            ArrayList<ArrayList<Flight>> flightListList = api.searchFlight(from, to, date, numberOfstops);

                            //IMPRIME LOS POSIBLES RESULTADOS
                            for (ArrayList<Flight> flightlist : flightListList) {
                                System.out.print(flightListList.indexOf(flightlist) + 1); //el +1 es para q quede lindo
                                System.out.println(flightlist);
                            }

                            //EL USUARIO ELIGE UN VUELO
                            ArrayList<Flight> wantedFlight = flightListList.get(Scanner.getInt("Que vuelo desea?\n") - 1); // el -1 es por el +1 de arriba

                            //POR CADA VUELO EN EL ARREGLO SELECCIONADO (PUEDE SER 1 , 2 O 3 DEPENDIENDO DE LAS ESCALAS) EL USUARIO SELECCIONA LOS ASIENTOS
                            for (Flight flight : wantedFlight) {
                                System.out.println(flight);
                                //ARREGLO CON LOS ASIENTOS DISPONIBLES PARA ESTE VUELO
                                ArrayList<Seat> availableSeats = api.availableSeats(flight);

                                //ARREGLO VACIO QUE SERA LLENADO Y LUEGO ENVIADO AL API PARA POSTERIORMENTE SER RESERVADOS
                                ArrayList<Seat> wantedSeats = new ArrayList<>();

                                System.out.println(availableSeats);
                                for (int i = 0; i < numberOfPassengers; i++) {
                                    //ACA EL USUARIO SELECCIONA EL ASIENTO QUE DESEA (UNO POR CADA PASAJERO)
                                    String position = Scanner.getString("indique el " + (i + 1) + " asiento que desea\n").toLowerCase();
                                    for (Seat seat : availableSeats) {
                                        if (seat.getPosition().equals(position)) {
                                            wantedSeats.add(seat);
                                            break;
                                        }
                                    }
                                }
                                if (wantedSeats.size()<numberOfPassengers){
                                    throw new RuntimeException("Error");
                                }
                                System.out.println(api.reserveSeats(flight, wantedSeats, passenger));
                            }
                            break;
                    case 2:
                            System.out.println(passenger.flyHistory());
                            break;
                    case 3:

                    case 4:
                    case 5:
                    case 6:
                            programIsRuning = false;

                    case 7:
                            logged = false;

                }
            }

        }
    }
}
