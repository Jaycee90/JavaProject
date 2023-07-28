package store_info;
import java.util.*;

/**
 * 
 */
public class Product {

    private int ID;
    private String name;
    private int numberOfItems;

    /**
     * Default constructor
     */
    public Product() {
    }

    //Constructor with arguments
    public Product(int ID, String name){
        this.ID = ID;
        this.name = name;
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
        // just return 0 for now.
        return 0;
    }
}