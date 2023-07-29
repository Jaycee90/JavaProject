package store_info;
//import java.util.*; 
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    private int lastProductID;
    private int lastStoreID;

    private List<Transaction> transactions;

    /**
     * Default constructor that initializes the StockManager.
     */
    public StockManager() {
        products = new ArrayList<Product>();
        stores = new ArrayList<Store>();
        lastProductID = 0;
        lastStoreID = 0;
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

    public int getNextProductID() {
        lastProductID++;
        return lastProductID;
    }

    public int getNextStoreID() {
        lastStoreID++;
        return lastStoreID;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Product getProductByID(int productID) {
        for (Product product : products) {
            if (product.getID() == productID) {
                return product;
            }
        }
        return null;
    }
    
    public Store getStoreByID(int storeID) {
        for (Store store : stores) {
            if (store.getID() == storeID) {
                return store;
            }
        }
        return null;
    }
}