package store_info;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a transaction in the inventory management system.
 * A transaction can be either an incoming or outgoing movement of products.
 * 
 */
public abstract class Transaction {
    /**
     * Unique identifier for the transaction
     */
    private int ID;
    private int storeID;
    
    /**
     * Date when the transaction occurred.
     */
    private Date date;
    /*
     * transactionType represent the type of transaction
     */
    private String transactionType;

    /**A map that holds the products involved in the 
     * transaction and their corresponding quantity. 
     */
    private Map<Product, Integer> productList;

    /**
     * Default constructor to initialize a new transaction.
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

    // Getter for productList with package-private access
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
     * Getter for the transaction type
     * @return the type of the transaction.
     */
     public String getTransactionType() {
        return transactionType;
    }

    public int getStoreID() {
        // Implement the logic to get the store ID associated with this transaction.
        // For now, I will assume there is a field called storeID in the Transaction class.
        return storeID;
    }

    /**
     * Update the product stock.
     * This method should be overridden in the subclasses (IncomingTransaction and OutgoingTransaction).
     */
    public abstract void updateProductStock();

    /**
     * Write the transaction details to the log file.
     * This method should be overridden in the subclasses (IncomingTransaction and OutgoingTransaction).
     */
    public abstract void writeToLogFile();
}