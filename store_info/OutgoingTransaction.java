package store_info;

import java.util.Date;
import java.util.Map;

/**
 * This class represents an outgoing transaction in the inventory
 * management system.An outgoing transaction is used when deducting/
 * removing an items from the inventory.It extends the base 
 * Transaction class, inheriting its attributes and methods.
 */
public class OutgoingTransaction extends Transaction {
    private int storeID;
    private String storeAddr;

    /**
     * Default constructor to initialize outgoing transactions.
     * @param ID      The unique identifier for the outgoing transaction.
     * @param date    The date of the outgoing transaction.
     * @param storeID The identification number of the store where the items are sent.
     * @param storeAddr The address of the store where the items are sent.
     */
    public OutgoingTransaction(int ID, Date date, int storeID, String storeAddr) {
        super(ID, date, "Outgoing");
        this.storeID = storeID;
        this.storeAddr = storeAddr;
    }

    /**
     * Getter for store ID
     * @return the identification number of store where the items are sent
     */
    public int getStoreID(){
        return storeID;
    }

      /**
     * Getter for store Address
     * @return the identification address of store where the items are sent
     */
    public String getStoreAddr(){
        return storeAddr;
    }

    /**
     * This method is overridden from the base Transaction class to update 
     * the product stock.When an outgoing transaction occurs, it removes 
     * items from the inventory.The implementation of this method will handle 
     * updating the inventory stock accordingly.
     * 
     */
    @Override
    public void updateProductStock() {
        //For outgoing transactions, update the product stock by deducting the outgoing items
        for (Map.Entry<Product, Integer> entry : getProductList().entrySet()){
            Product product = entry.getKey();
            int numberOfItems = entry.getValue();
            product.setNumberOfItems(product.getNumberOfItems()-numberOfItems);
        }
    }

    /**
     * Write the outgoing transaction details to the "AllOutgoingItems.txt" file.
     * This method appends the outgoing transaction information, including the
     * transaction ID, date, and the products removed, to the specified file.
     */
        @Override
        public void writeToLogFile() {
            StringBuilder transactionDetails = new StringBuilder();
            transactionDetails.append("Outgoing Transaction ID: ").append(getID()).append("\n");
            transactionDetails.append("Date: ").append(getDate()).append("\n");
            transactionDetails.append("Products: \n");
            for (Map.Entry<Product, Integer> entry : getProductList().entrySet()) {
                Product product = entry.getKey();
                int numberOfItems = entry.getValue();
                transactionDetails.append(product.getName()).append(" (").append(product.getID()).
                                    append("): ").append(numberOfItems).append("\n");
            }
            transactionDetails.append("-----------------------------------\n");
    
            TransactionsManager transactionsManager = new TransactionsManager();
            transactionsManager.appendToFile("AllOutgoingItems.txt", transactionDetails.toString());
        }

}