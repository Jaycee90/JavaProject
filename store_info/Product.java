package store_info;

import java.util.Map;
import java.util.HashMap;

/**
 * This class represents a product in the inventory management system.
 * It contains information about the product, such as ID, name, and quantity.
 */
public class Product {

    private int ID;
    private String name;
    private int numberOfItems;
    private Map<Integer, Integer> quantitySentToStores;

    /**
     * Default constructor
     */
    public Product() {
    }

    /**
     * Constructor with arguments to initialize a new product.
     * @param ID The unique identifier for the product.
     * @param name The name of the product.
     */
    public Product(int ID, String name){
        this.ID = ID;
        this.name = name;
        this.quantitySentToStores = new HashMap<Integer, Integer>();
    }

    /**
     *  Set the number of items in the product.
     * @param numberOfItems The number of items to set.
     */
    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    /**
     * Get the number of items in the product.
     * @return The number of items in the product.
     */
    public int getNumberOfItems() {
        return numberOfItems;
    }

     /**
     * Get the name of the product.
     * @return The name of the product.
     */
    public String getName(){
        return name;
    }

    /**
     * Get the ID of the product.
     * @return The ID of the product.
     */
    public int getID(){
        return ID;
    }

    /**
     * Get the quantity of the product sent to a specific store.
     * @param storeID The ID of the store.
     * @return The quantity of the product sent to the specified store.
     */
    public int getQuantitySentToStore(int storeID){
        return quantitySentToStores.getOrDefault(storeID, 0);
    }

    /**
     * Add or subtract the quantity of the product sent to a specific store.
     * @param storeID The ID of the store.
     * @param quantity The quantity to add or subtract. Use a negative value to subtract.
     */
    public void addToQuantitySentToStore(int storeID, int quantity) {
        int currentQuantity = quantitySentToStores.getOrDefault(storeID, 0);
        quantitySentToStores.put(storeID, currentQuantity + quantity);
    }
}