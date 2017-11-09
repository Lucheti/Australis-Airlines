/**
 * Created by lucasgarcia on 9/11/17.
 */
public class CodeGenerator {
    Integer uniquePlaneCode = 1000;
    String uniqueFlightCode;


    String getUniquePlaneCode() {
        return "AA" +(uniquePlaneCode+=5).toString();
    }

    public String getUniqueFlightCode(Plane plane, Airport from, Airport to) {
        return plane.getPlaneCode() + from + to;
    }
}
