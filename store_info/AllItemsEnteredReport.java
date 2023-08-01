package store_info;

import java.util.List;
import java.util.Map;

/**
 *  A report class that prints the report of 
 * all items entered in the inventory.
 */
public class AllItemsEnteredReport implements Report {

    private TransactionsManager transactionsManager;

    /**
     * Constructor to initialize the AllItemsEnteredReport with the TransactionsManager.
     * @param transactionsManager The TransactionsManager used for generating the report.
     */
    public AllItemsEnteredReport(TransactionsManager transactionsManager) {
        this.transactionsManager = transactionsManager;
    }

    /**
     * Print the report of all items entered in the inventory.
     */
    @Override
    public void printReport() {
        System.out.println("All Items Entered Report:");
        List<Transaction> transactions = transactionsManager.getTransactions();
        for (Transaction transaction : transactions) {
            if (transaction instanceof IncomingTransaction) {
                System.out.println("Transaction ID: " + transaction.getID());
                System.out.println("Date: " + transaction.getDate());
                System.out.println("Products: ");
                for (Map.Entry<Product, Integer> entry : transaction.getProductList().entrySet()) {
                    Product product = entry.getKey();
                    int numberOfItems = entry.getValue();
                    System.out.println(product.getName() + " (ID: " + product.getID() + ") - Quantity: " + numberOfItems);
                }
                System.out.println("-----------------------------------");
            }
        }
    }
    
     /**
     * Get a list of all transactions associated with this report.
     * @return A list of Transaction objects.
     */
    public List<Transaction> getTransactions(){
        return transactionsManager.getTransactions();
    }

}