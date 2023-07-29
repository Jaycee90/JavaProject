package store_info;
import java.util.*;

/**
 *  This class represents an outgoing transaction in the inventory
 * management system.An outgoing transaction is used when deducting/
 * removing an items from the inventory.It extends the base 
 * Transaction class, inheriting its attributes and methods.
 * 
 */
public class OutgoingTransaction extends Transaction {

    /**
     * Default constructor to initialize outgoing transactions.
     */
    public OutgoingTransaction(int ID, Date date) {
        super(ID, date);
    }

    /**
     * 
     */
    //private Store store;

    /**
     * This method is overridden from the base Transaction class to update 
     * the product stock.When an outgoing transaction occurs, it removes 
     * items from the inventory.The implementation of this method will handle 
     * updating the inventory stock accordingly.
     * 
     */
    @Override
    public void updateProductStock() {
        for (Map.Entry<Product, Integer> entry : getProductList().entrySet()){
            Product product = entry.getKey();
            int numberOfItems = entry.getValue();
            product.setNumberOfItems(product.getNumberOfItems()-numberOfItems);
        }
    }

}