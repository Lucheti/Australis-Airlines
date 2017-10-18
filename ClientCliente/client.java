package AustralisAirlines.ClientCliente;
import AustralisAirlines.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by agusl on 13/10/2017.
 */


public class client {


    /**BilateralFLigth -> 1 ida y vuelta ;
     *                 -> 2 solo ida;
     */

    public boolean bilateralFligth (){

       int bilateral = Scanner.getChar(" 1- Bilateral Fligth. \n 2- OneWay Fligth.");

       if (bilateral == 1){
           return true;
       }if (bilateral == 2){
           return false;
       }else{
            bilateralFligth();
            throw new RuntimeException("Invalid Number.");

       }
    }


    public String from(List<String>location){

       //print location list;
       for (String  i : location) {
            System.out.println(i);
       }

       //ask from where does the client want to travel;
       String from = Scanner.getString("From: \t");

       try{
            location.contains(from);
       }catch (Exception e){
            throw new RuntimeException("The location does not exist or was misspelled");
       }

       return from;
    }

    public String to(List<String>location){

        for (String  i : location) {
            System.out.println(i);
        }

        String to = Scanner.getString("To: ");

        try{
            location.contains(to);
        }catch (Exception e){
            throw new RuntimeException("The location does not exist or was misspelled");
        }

        return to;
    }

    public boolean stopOverFligth (){

        int stopOver = Scanner.getChar(" 1- StopOver Fligth. \n 2- Direct Fligth.");

        if (stopOver == 1){
            return true;
        }if (stopOver == 2){
            return false;
        }else{
            throw new RuntimeException("Invalid Number.");
            stopOverFligth();
        }
    }


}
