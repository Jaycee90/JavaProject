package store_info;
import java.util.*;

/**
 * 
 */
public class Product {

    private int ID;
    private String name;
    private int numberOfItems;
    //private int quantitySentToStore;
    //to keep track of the quantity of the product sent to each store.
    private Map<Integer, Integer> quantitySentToStores;

    /**
     * Default constructor
     */
    public Product() {
    }

    //Constructor with arguments
    public Product(int ID, String name){
        this.ID = ID;
        this.name = name;
        this.quantitySentToStores = new HashMap<Integer, Integer>();
    }

    /**
     * 
     * @param numberOfItems
     */
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return ID;
    }

    public int getQuantitySentToStore(int storeID){
        // Implement the logic to get the quantity of this product sent
        // to the store with the given storeID, I will access the 
        //stock manager to retrieve this information
        return quantitySentToStores.getOrDefault(storeID, 0);
    }

    public void addToQuantitySentToStore(int storeID, int quantity) {
        int currentQuantity = quantitySentToStores.getOrDefault(storeID, 0);
        quantitySentToStores.put(storeID, currentQuantity + quantity);
    }
}