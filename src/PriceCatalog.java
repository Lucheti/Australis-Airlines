import java.util.HashMap;

/**
 * Created by lucasgarcia on 9/11/17.
 */
public class PriceCatalog {
    HashMap<String,Integer> catalog = new HashMap<>();

    void addCategory(String category , int price){ catalog.put(category,price);}

    void print(String categoria){
        System.out.println(catalog.get(categoria));
    }
}
