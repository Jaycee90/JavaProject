package store_info;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * This class manages transactions in the inventory 
 * management system. It allows adding new transactions 
 * and appending transaction information to a file. 
 */
public class TransactionsManager {
    //
    private List<Transaction> transactions;

    /**
     * Default constructor to initialize the TransactionsManager.
     */
    public TransactionsManager() {
        //Initialize the list 
        transactions = new ArrayList<>();
    }

    /**
     * Adds a new transaction to the system.
     * @param transaction The Transaction object representing 
     * the new transaction to be added.
     */
    public void addTransaction(Transaction transaction) {
        //Depending on the transaction type (Incoming or Outgoing), 
        //you need to update the stock accordingly
        transactions.add(transaction);
        transaction.updateProductStock();
    }

    /**
     * Appends transaction information to a file.
     * @param fileName The name of the file to which 
     * the transaction information will be appended.
     * @param transaction The String representation of 
     * the transaction information to be appended.
     */
    public void appendToFile(String fileName, String transaction) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(transaction + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
}
}