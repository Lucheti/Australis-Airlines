/**
 * Created by Nicole on 11/9/17.
 */
public class Administrator extends Employee{
    String area = "Administrator";

    public boolean validateSell(){
        boolean validator = false;
        if (Employee.area.equals("Ventas")){
            validator = true;
        }
        return validator;
    }

}
