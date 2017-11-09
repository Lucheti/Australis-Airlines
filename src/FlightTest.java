import org.junit.Test;


public class FlightTest {


@Test
   public void  test01(){

   Date date = new Date(1,1);
   Plane plane = new Plane(2,2,1);
   for (Seat seat: plane.seats){
       System.out.println(seat);
   }

}


}