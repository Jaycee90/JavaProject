package store_info;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TransactionsManager {
    private List<Transaction> transactions;

    public TransactionsManager() {
        transactions = new ArrayList<>();
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
}