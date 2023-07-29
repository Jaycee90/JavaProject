package store_info;
//import java.util.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*This class represents a transaction in the inventory management system.
 * A transaction can be either an incoming or outgoing movement of products.
 * 
 */
public abstract class Transaction {
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

    /**
     * Default constructor to initialize a new transaction.
     */
    public Transaction(int ID, Date date) {
        this.ID = ID;
        this.date = date;
        productList = new HashMap<Product, Integer>();
    }

    // Abstract method to be overridden in the subclasses
    public abstract void updateProductStock();

    /**
     * Adds a product and its corresponding quantity to the transaction.
     * @param product The Product object to be added to the transaction.
     * @param numberOfItems The number of items of the specified product 
     * involved in the transaction. 
     */
    public void addProduct(Product product, int numberOfItems) {
        productList.put(product, numberOfItems);
    }

    //Getter for productList with package-private access
    Map<Product, Integer> getProductList(){
        return productList;
    }

    public int getID(){
        return ID;
    }

    public Date getDate(){
        return date;
    }

}