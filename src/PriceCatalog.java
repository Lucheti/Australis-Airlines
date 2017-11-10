import java.util.HashMap;

/**
 * Created by lucasgarcia on 9/11/17.
 */
public class PriceCatalog {
    HashMap<String,Integer> catalog = new HashMap<>();

    PriceCatalog(){
        catalog.put("Turist",1000);
        catalog.put("Buisness",5000);
    }
    PriceCatalog(int turistClassPrice, int buisnessClassprice){
        catalog.put("Turist",turistClassPrice);
        catalog.put("Buisness",buisnessClassprice);
    }

    void addCategory(String category , int price) { catalog.put(category,price); }

    Integer getPrice(String category) { return catalog.get(category); }

    void print(String categoria){
        System.out.println(catalog.get(categoria));
    }
}
