package store_info;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The TransactionsManager class is responsible for managing transactions
 * in the inventory management system. It allows adding new transactions, 
 * retrieving all transactions, and saving transactions to a file.
 */
public class TransactionsManager {
    private List<Transaction> transactions;
    // Variable to keep track of the next transaction ID
    private int nextTransactionID; 

    /*
     * Default constructor to initialize a new TransactionsManager.
     * It creates an empty list of transactions and sets the initial
     * value of nextTransactionID to 1.
     */
    public TransactionsManager() {
        transactions = new ArrayList<>();
        nextTransactionID = 1; // Start with ID 1
    }

    /**
     * Adds a new transaction to the inventory system and updates the product stock.
     * @param transaction The Transaction object representing the new transaction to be added.
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.updateProductStock();
    }

    /**
     * Appends the given transaction details to the specified file.
     * @param fileName The name of the file to which the transaction details should be appended.
     * @param transaction The transaction details to be appended to the file.
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

    /**
     * Retrieves the list of all transactions in the inventory management system.
     * @return The list of all transactions.
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Gets the next transaction ID to be used for a new transaction.
     * @return The next transaction ID.
     */
    public int getNextTransactionID() {
        return nextTransactionID++;
    }

    
    /**
     * Prints all transactions and their details to the console.
     */
    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getID());
            System.out.println("Date: " + transaction.getDate());
            System.out.println("Products: ");
            for (Map.Entry<Product, Integer> entry : transaction.getProductList().entrySet()) {
                Product product = entry.getKey();
                int numberOfItems = entry.getValue();
                System.out.println(product.getName() + "(ID: " + product.getID() + 
                                    ") - Quantity: " + numberOfItems);
            }
            System.out.println("-----------------------------------");
        }
    }

    /**
     * Saves all transactions and their details to a .txt file.
     * @param fileName The name of the file to which the transactions should be saved.
     */
    public void saveTransactionsToFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (Transaction transaction : transactions) {
                fileWriter.write("Transaction ID: " + transaction.getID() + "\n");
                fileWriter.write("Date: " + transaction.getDate() + "\n");
                fileWriter.write("Products: \n");
                for (Map.Entry<Product, Integer> entry : transaction.getProductList().entrySet()) {
                    Product product = entry.getKey();
                    int numberOfItems = entry.getValue();
                    fileWriter.write(product.getName() + "(ID: " + product.getID() + 
                                       ") - Quantity: " + numberOfItems + "\n");
                }
                fileWriter.write("-----------------------------------\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}