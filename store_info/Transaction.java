package store_info;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The Transaction class represents a transaction in the inventory management system.
 * A transaction can be either an incoming or outgoing movement of products.
 * 
 */
public abstract class Transaction {
    /**
     * Unique identifier for the transaction
     */
    private int ID;

    /*
     * Unique identifier of the store involved in the transaction.
     */
    private int storeID;
    
    /**
     * Date when the transaction occurred.
     */
    private Date date;
    /*
     * The type of transaction (Incoming or Outgoing).
     */
    private String transactionType;

    /**A map that holds the products involved in the 
     * transaction and their corresponding quantity. 
     */
    private Map<Product, Integer> productList;

    /**
     * Default constructor to initialize a new transaction.
     * @param ID The unique identifier for the transaction.
     * @param date The date when the transaction occurred.
     * @param transactionType The type of transaction (Incoming or Outgoing).
     */
    public Transaction(int ID, Date date, String transactionType) {
        this.ID = ID;
        this.date = date;
        this.transactionType = transactionType;
        productList = new HashMap<Product, Integer>();
    }

    /**
     * Adds a product and its corresponding quantity to the transaction.
     * @param product The Product object to be added to the transaction.
     * @param numberOfItems The number of items of the specified product 
     * involved in the transaction. 
     */
    public void addProduct(Product product, int numberOfItems) {
        productList.put(product, numberOfItems);
    }

     /**
     * Getter for the product list involved in the transaction.
     * This method has package-private access, meaning it can be accessed
     * by other classes within the same package but not from outside the package.
     * @return The map containing the products and their corresponding 
     * quantities in the transaction.
     */
    Map<Product, Integer> getProductList(){
        return productList;
    }

    /**
     * Get the unique identifier of the transaction.
     * @return The unique identifier of the transaction.
     */
    public int getID(){
        return ID;
    }

    /**
     * Get the date when the transaction occurred.
     * @return The date of the transaction.
     */
    public Date getDate(){
        return date;
    }
    
     /**
     * Get the type of the transaction (Incoming or Outgoing).
     * @return The type of the transaction.
     */
     public String getTransactionType() {
        return transactionType;
    }

    /**
     * Get the unique identifier of the store involved in the transaction.
     * @return The unique identifier of the store.
     */
    public int getStoreID() {
        return storeID;
    }

    /**
     * Update the product stock.
     * This method should be overridden in the subclasses 
     * (IncomingTransaction and OutgoingTransaction).
     */
    public abstract void updateProductStock();

    /**
     * Write the transaction details to the log file.
     * This method should be overridden in the subclasses 
     * (IncomingTransaction and OutgoingTransaction).
     */
    public abstract void writeToLogFile();
}