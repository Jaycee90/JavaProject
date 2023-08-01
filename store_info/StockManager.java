package store_info;
 
import java.util.ArrayList;
import java.util.List;

/**
 * The StockManager class represents a manager that handles the inventory 
 * of products and manages store information. It allows adding new products 
 * to the inventory and keeps track of the stores available in the system.
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
     * An integer representing the last assigned product ID. 
     * It is used to generate the next available product ID.
     */
    private int lastProductID;

    /**
    * An integer representing the last assigned store ID. 
    * It is used to generate the next available store ID.
    */
    private int lastStoreID;

    /**
     * A list of Transaction objects that keeps track of all transactions 
     * recorded in the inventory management system.
     */
    private List<Transaction> transactions;

   /**
    * Default constructor that initializes the StockManager.
    * It creates empty lists for products and stores and sets the 
    * lastProductID and lastStoreID to 0.
    */
    public StockManager() {
        products = new ArrayList<Product>();
        stores = new ArrayList<Store>();
        lastProductID = 0;
        lastStoreID = 0;
        transactions = new ArrayList<Transaction>();
    }

    /**
     * This method adds a new product to the inventory.
     * @param product The Product object to be added.
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Adds a new store to the list of stores.
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

    /*
     * Retrieves the next available Product ID for adding a new product to the inventory.
     * @return The next available Product ID.
     */
    public int getNextProductID() {
        lastProductID++;
        return lastProductID;
    }

    /**
     * Retrieves the next available Store ID for adding a new store to the list of stores.
     * @return The next available Store ID.
     */
    public int getNextStoreID() {
        lastStoreID++;
        return lastStoreID;
    }

    /**
     * Retrieves a list of all transactions recorded in the inventory management system.
     * @return A List of Transaction objects representing all recorded transactions.
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Retrieves the Product object from the inventory based on its given Product ID.
     * @param productID The ID of the product to be retrieved.
     * @return The Product object with the matching ID, or null if no product with 
     * the given ID is found.
     */
    public Product getProductByID(int productID) {
        for (Product product : products) {
            if (product.getID() == productID) {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Retrieves the Store object from the list of stores based on its given Store ID.
     * @param storeID The ID of the store to be retrieved.
     * @return The Store object with the matching ID, or null if no store with 
     * the given ID is found.
     */
    public Store getStoreByID(int storeID) {
        for (Store store : stores) {
            if (store.getID() == storeID) {
                return store;
            }
        }
        return null;
    }
}