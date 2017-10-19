package ClientCliente;
import java.util.List;
/**
 * Created by agusl on 13/10/2017.
 */


public class Client{


    public static void main(String[] args){

        System.out.println("Welcome to Australis Airlines \nNot the best place to travel \n \n");
        boolean bilateral = bilateralFligth();
        //En api falso crear getLocationList();
        String fromWhere= from();
    }


    /**BilateralFLigth -> 1 ida y vuelta ;
     *                 -> 2 solo ida;
     */

    public boolean bilateralFligth (){

       System.out.println("Enter the desiered kind of fligth:\n");
       int bilateral = Scanner.getChar(" 1- Bilateral Fligth. \n 2- OneWay Fligth.\n");

       if (bilateral == 1){
           return true;
       }if (bilateral == 2){
           return false;
       }else{
            throw new RuntimeException("Invalid Number.\n");

       }
    }


    // Muestra lista de locations. Luego pide ingresar un from.
    public String from(List<String>location){

       //print location list;
       for (String  i : location) {
            System.out.println(i);
       }

       //ask from where does the client want to travel;
       String from = Scanner.getString("\nFrom: \t");

       try{
            location.contains(from);
       }catch (Exception e){
            throw new RuntimeException("The location does not exist or was misspelled\n");
       }

       return from;
    }

    //muestra lista de locations. Luego pide ingresar un to.
    public String to(List<String>location){

        for (String  i : location) {
            System.out.println(i);
        }
        System.out.println("\nEnter ´No Back´ if you have previusly chose OneWay Fligth.\n");
        String to = Scanner.getString("To: \t ");

        try{
            location.contains(to);
        }catch (Exception e){
            throw new RuntimeException("The location does not exist or was misspelled.\n");
        }

        return to;
    }

    // muestra en pantalla dos opciones: Vuelo directo o con escalas.
    public boolean stopOverFligth (){

        System.out.println("Enter the desiered kind of fligth:\n");
        int stopOver = Scanner.getChar(" 1- StopOver Fligth. \n 2- Direct Fligth.\n");

        if (stopOver == 1){
            return true;
        }if (stopOver == 2){
            return false;
        }else{
            throw new RuntimeException("Invalid Number.\n");
            stopOverFligth();
        }
    }



}
