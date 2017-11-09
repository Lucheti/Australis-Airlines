/**
 * Created by Nicole on 11/9/17.
 */
public class Administrator extends Employee{
    String area = "Administrator";
    private boolean capabilityToSell = false;
    public String location;


    public boolean validateSell(){
        boolean validator = false;
        if (location.equals("ventas")){
            validator = true;
        }
        return validator;
    }

}
