import java.util.ArrayList;

class Passenger extends Persona{

    private String dni;
    private String name;
    private ArrayList<Ticket> flyHistory = new ArrayList<>();

    Passenger(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    String getName() {
        return name;
    }

    String getDni() {
        return dni;
    }

    void addFlightToHistory(Ticket ticket){
        flyHistory.add(ticket);
    }

    String flyHistory(){
        StringBuilder answer = new StringBuilder();
        for (Ticket ticket: flyHistory){
            answer.append(ticket.toString()).append("\n");
        }
        return answer.toString();
    }
}
