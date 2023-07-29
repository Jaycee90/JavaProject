package store_info;
import java.util.*;

/**
 * This class represents an incoming transaction in the inventory
 * management system.An incoming transaction is used when adding 
 * new items to the inventory.It extends the base Transaction class, 
 * inheriting its attributes and methods.
 */
public class IncomingTransaction extends Transaction {

    /**
     * Default constructor to initialize an incoming transaction.
     */
    public IncomingTransaction(int ID, Date date) {
        super(ID, date);
    }

    /**
     * This method is overridden from the base Transaction class to update 
     * the product stock.When an incoming transaction occurs, it adds new 
     * items to the inventory.The implementation of this method will handle 
     * updating the inventory stock accordingly.
     */
    @Override
    public void updateProductStock() {
        for (Map.Entry<Product, Integer> entry : getProductList().entrySet()) {
            Product product = entry.getKey();
            int numberOfItems = entry.getValue();
            product.setNumberOfItems(product.getNumberOfItems() + numberOfItems);
        }
    }

}