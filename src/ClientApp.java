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

        Date date1 = new Date(19,1,23,00);
        Date date2 = new Date(11,5,01,24);
        Date date3 = new Date(15,7,01,01);

        api.addAirport("A","AAA");
        api.addAirport("B","BBB");
        api.addAirport("C","CCC");
        api.addAirport("D","DDD");

        api.addPilot(api.getAirport("A"));
        api.addPilot(api.getAirport("A"));
        api.addPilot(api.getAirport("A"));
        api.addPilot(api.getAirport("A"));
        api.addPilot(api.getAirport("B"));
        api.addPilot(api.getAirport("B"));
        api.addPilot(api.getAirport("B"));
        api.addPilot(api.getAirport("C"));
        api.addPilot(api.getAirport("C"));
        api.addPilot(api.getAirport("D"));
        api.addPilot(api.getAirport("D"));

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
                int option = Scanner.getInt("1: Login \t2: Register\n\n");
                switch (option) {
                    case 1:
                            passenger = api.login(Scanner.getInt("Enter your passenger ID number: "));
                            System.out.println("Logged in as: " + passenger.getNombre() + "\n\n");
                            passenger= api.login(Scanner.getString("enter your passenger number\n"));
                            System.out.println("logged in as " + passenger.getName());
                            logged = true;
                            break;

                    case 2:
                            int uniquePassengerNumber = api.registerNewPassenger(Scanner.getString("Dni"),Scanner.getString("Name"));
                            System.out.println("Your unique passenger number is: " + uniquePassengerNumber + "\n");
                            passenger = api.login(uniquePassengerNumber);
                            System.out.println("Logged in as: " + passenger.getNombre() +"\n\n");
                            logged = true;
                            break;
                }
            }
            while (logged) {
                int option = Scanner.getInt("Options:\n\n1: Search Fligth\n6:Logout \n7:Quit\n\n");
                //int option = Scanner.getInt("opciones: \n 1: buscar un vuelo\n 2:ver historial de vuelo\n 6:quit\n 7:logout ");
                int option = Scanner.getInt("opciones: \n 1: buscar un vuelo\n 2: ver historial de vuelo\n 6: logout\n 7: quit ");
                switch (option) {
                    case 1:

                        //SE LE PIDE AL USUARIO AEROPUERTO DE SALIDA , LLEGADA , DIA , CANTIDAD DE ESCALAS Y CANTIDAD DE PASAJEROS
                        Airport from = api.getAirport(Scanner.getString("Departure Airport:\t" + api.airportList()).toUpperCase());
                        Airport to = api.getAirport(Scanner.getString("\nArrival Airport: \t" + api.airportList()).toUpperCase());
                        int numberOfstops = Scanner.getInt("How many Stops: \n0- Direct Fligth \n1- One Stop \n2-Two Stops");
                        Date date = new Date(Scanner.getInt("Day:\t"), Scanner.getInt("Month:\t"));
                        int numberOfPassengers = Scanner.getInt("How many passengers?:\t");

                            //BUSQUEDA DE TODAS LAS POSIBLES COMBINACIONES DE VUELOS CON RESPECTO A LOS PARAMETROS INDICADOS
                            ArrayList<ArrayList<Flight>> flightListList = api.searchFlight(from, to, date, numberOfstops);

                            //IMPRIME LOS POSIBLES RESULTADOS
                            for (ArrayList<Flight> flightlist : flightListList) {
                                System.out.print(flightListList.indexOf(flightlist) + 1); //el +1 es para q quede lindo
                                System.out.println(flightlist);
                            }

                        //EL USUARIO ELIGE UN VUELO
                        ArrayList<Flight> wantedFlight = flightListList.get(Scanner.getInt("\n\nWich fligth do you want?\n") - 1); // el -1 es por el +1 de arriba

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
                                String position = Scanner.getString("Wich " + (i + 1) + " seat you desire?: \t").toLowerCase();
                                for (Seat seat : availableSeats) {
                                    if (seat.getPosition().equals(position)) {
                                        wantedSeats.add(seat);
                                        break;
                                    }
                                }
                            }
                            if (wantedSeats.size()<numberOfPassengers){
                                throw new RuntimeException("\nError");
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
                            logged = false;
                            break;
                    case 7:
                            programIsRuning = false;

                }
            }
        }
    }
}
