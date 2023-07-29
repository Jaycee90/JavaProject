package store_info;

//import java.util.*;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class AllItemsEnteredReport implements Report {

    private TransactionsManager transactionsManager;

    /**
     * Constructor to initialize the AllItemsEnteredReport with the TransactionsManager.
     *
     */
    public AllItemsEnteredReport(TransactionsManager transactionsManager) {
        this.transactionsManager = transactionsManager;
    }

    /**
     * Print the report of all items entered in the inventory.
     */
    @Override
    public void printReport() {
        List<Transaction> transactions = transactionsManager.getTransactions();
        try (FileWriter fileWriter = new FileWriter("AllItemsEnteredReport.txt")) {
            fileWriter.write("All Items Entered Report:\n");
            for (Transaction transaction : transactions){
                if (transaction instanceof IncomingTransaction){
                    fileWriter.write("Transasction ID: " + transaction.getID() + "\n");
                    fileWriter.write("Date: " + transaction.getDate() + "\n");
                    fileWriter.write("Products:\n");
                    for (Map.Entry<Product, Integer> entry : transaction.getProductList().entrySet()){
                        Product product = entry.getKey();
                        int numberOfItems = entry.getValue();
                        fileWriter.write(product.getName() + "(ID: " + product.getID() + ") -Quantity: " + numberOfItems + "\n");
                    }
                    fileWriter.write("-----------------------------------\n");
                }
            }
            System.out.println("Report saved to AllItemsEnteredReport.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    private void collectItemsEntered() {
        // TODO implement here
    }

    public List<Transaction> getTransactions(){
        return transactionsManager.getTransactions();
    }

}