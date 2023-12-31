package store_info;

import java.util.Date;
import java.util.Map;

/**
 * This class represents an incoming transaction in the inventory
 * management system.An incoming transaction is used when adding 
 * new items to the inventory.It extends the base Transaction class, 
 * inheriting its attributes and methods.
 */
public class IncomingTransaction extends Transaction {

    /**
     * Default constructor to initialize an incoming transaction.
     * @param ID   The unique identifier for the incoming transaction.
     * @param date The date of the incoming transaction.
     */
    public IncomingTransaction(int ID, Date date) {
        super(ID, date, "Incoming");
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

        /*
         * Write the incoming transaction details to the "AllIncomingItems.txt" file.
         * This method appends the incoming transaction information, including the
         * transaction ID, date, and the products received, to the specified file.
         */
        @Override
        public void writeToLogFile() {
            StringBuilder transactionDetails = new StringBuilder();
            transactionDetails.append("Incoming Transaction ID: ").append(getID()).append("\n");
            transactionDetails.append("Date: ").append(getDate()).append("\n");
            transactionDetails.append("Products: \n");
            for (Map.Entry<Product, Integer> entry : getProductList().entrySet()) {
                Product product = entry.getKey();
                int numberOfItems = entry.getValue();
                transactionDetails.append(product.getName()).append(" (ID: ").append(product.getID()).
                                   append(") - Quantity: ").append(numberOfItems).append("\n");
            }
            transactionDetails.append("-----------------------------------\n");
    
            TransactionsManager transactionsManager = new TransactionsManager();
            transactionsManager.appendToFile("AllIncomingItems.txt", transactionDetails.toString());
        }

}