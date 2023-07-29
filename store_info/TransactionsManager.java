package store_info;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionsManager {
    private List<Transaction> transactions;
    private int nextTransactionID; // Variable to keep track of the next transaction ID

    public TransactionsManager() {
        transactions = new ArrayList<>();
        nextTransactionID = 1; // Start with ID 1
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.updateProductStock();
    }

    public void appendToFile(String fileName, String transaction) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(transaction + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Method to get the next transaction ID
    public int getNextTransactionID() {
        return nextTransactionID++;
    }

    // Method to print all transactions
    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getID());
            System.out.println("Date: " + transaction.getDate());
            System.out.println("Products: ");
            for (Map.Entry<Product, Integer> entry : transaction.getProductList().entrySet()) {
                Product product = entry.getKey();
                int numberOfItems = entry.getValue();
                System.out.println(product.getName() + "(ID: " + product.getID() + ") - Quantity: " + numberOfItems);
            }
            System.out.println("-----------------------------------");
        }
    }

    // Method to save transactions to a .txt file
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
                    fileWriter.write(product.getName() + "(ID: " + product.getID() + ") - Quantity: " + numberOfItems + "\n");
                }
                fileWriter.write("-----------------------------------\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}