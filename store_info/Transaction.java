package store_info;
import java.util.*;

/*This class represents a transaction in the inventory management system.
 * A transaction can be either an incoming or outgoing movement of products.
 * 
 */
public abstract class Transaction {

    /**
     * Default constructor to initialize a new transaction.
     */
    public Transaction() {
        productList = new HashMap<>();
    }

    /**
     * Unique identifier for the transaction
     */
    private int ID;

    /**
     * Date when the transaction occurred.
     */
    private Date date;

    /**A map that holds the products involved in the 
     * transaction and their corresponding quantity. 
     */
    private Map<Product, Integer> productList;

    // Abstract method to be overridden in the subclasses
    public abstract void updateProductStock();

    /**
     * Adds a product and its corresponding quantity to the transaction.
     * @param product The Product object to be added to the transaction.
     * @param numberOfItems The number of items of the specified product 
     * involved in the transaction. 
     */
    public void addProduct(Product product, int numberOfItems) {
        // TODO implement here
    }

    //Getter for productList with package-private access
    Map<Product, Integer> getProductList(){
        return productList;
    }

}