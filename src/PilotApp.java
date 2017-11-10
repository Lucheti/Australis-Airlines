import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

/**
 * Created by agusl on 9/11/2017.
 */
public class PilotApp {

    public static void main(String[]args) {

        Api api = new Api();
        boolean programIsRunning = true;
        boolean logged = false;
        Employee pilot = new Pilot(null);

        System.out.println("\t\t\tWelcome to Australis~Airlines PilotApp\n\n");

        while (programIsRunning) {
            while (!logged) {
                int option = Scanner.getInt("1: Login.\n2: Register\n\n");
                switch (option) {
                    case 1:
                        pilot = api.loginEmployee(Scanner.getString("Enter your employee ID number: "));
                        System.out.println("\nLogged in as: " + pilot.getName());
                        logged = true;
                        break;

                    case 2:
                        api.registerNewPassenger(Scanner.getString("Dni\n"), Scanner.getString("name\n"));
                        System.out.println("Register succesfull\n");
                        break;
                }
            }
            while (logged) {
                int option = Scanner.getInt("\nOptions: \n 1:My Fligths.\n6:Logout.\n7:Quit.");
                switch (option) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        logged = false;
                        break;
                    case 7:
                        programIsRunning = false;

                }
            }
        }
    }
}
