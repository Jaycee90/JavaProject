package store_info;
import java.util.*;

/**
 * 
 */
public class Transaction {

    /**
     * Default constructor
     */
    public Transaction() {
        productList = new HashMap<>();
    }

    /**
     * 
     */
    private int ID;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private Map<Product, Integer> productList;

    /**
     * @param Product product 
     * @param int numberOfItems
     */
    public void addProduct(Product product, int numberOfItems) {
        // TODO implement here
    }

}