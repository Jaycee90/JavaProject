package store_info;
//import java.util.*; 
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Stock Manager that 
 * allows adding new products to the inventory 
 * and managing store information.
 */
public class StockManager {
    /**
     * A list of Product objects that stores the 
     * inventory of products.
     */
    private List<Product> products;

    /**A list of Store objects that stores information
     * about different stores.
     * 
     */
    private List<Store> stores;

    /**
     * Default constructor that initializes the StockManager.
     */
    public StockManager() {
        products = new ArrayList<>();
        stores = new ArrayList<>();
    }

    /**
     * This method adds a new product to the inventory.
     * @param product The Product object to be added.
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * This method adds a new store to the list of stores.
     * @param store The Store object to be added.
     */
    public void addStore(Store store) {
        stores.add(store);
    }

    /**
     * Get the list of products in the inventory.
     * @return The list of products.
     */
    public List<Product> getProducts(){
        return products;
    }

    /**
     * Get the list of stores in the system.
     * @return The list of stores.
     */
    public List<Store> getStores(){
        return stores;
    }
}