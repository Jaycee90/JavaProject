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
        System.out.println("Products appear in the format: name(id): amount\n");
        List<Transaction> transactions = transactionsManager.getTransactions();
        for (Transaction transaction : transactions) {
            if (transaction instanceof IncomingTransaction) {
                System.out.println("Transaction ID: " + transaction.getID());
                System.out.println("Date: " + transaction.getDate());
                System.out.println("Products: ");
                for (Map.Entry<Product, Integer> entry : transaction.getProductList().entrySet()) {
                    Product product = entry.getKey();
                    int numberOfItems = entry.getValue();
                    System.out.println(product.getName() + " (" + product.getID() + "): " + numberOfItems);
                }
                System.out.println("-----------------------------------");
            }
        }
        System.out.println("\nReport saved to AllItemsEnteredReport.txt\n");
    }

    /**
     * Write the report of all incoming items in the inventory to a txt file.
     * The report displays the name, ID, and available quantity of each product.
     */
    @Override
    public String reportMe() {
        StringBuilder report = new StringBuilder();
        report.append("All Items Entered Report:\n").
        append("Products appear in the format: name(id): amount\n");
        List<Transaction> transactions = transactionsManager.getTransactions();
        for (Transaction transaction : transactions) {
            if (transaction instanceof IncomingTransaction) {
                report.append("Transaction ID: ").append(transaction.getID()).append("\n");
                report.append("Date: ").append(transaction.getDate()).append("\n");
                report.append("Products: \n");
                for (Map.Entry<Product, Integer> entry : transaction.getProductList().entrySet()) {
                    Product product = entry.getKey();
                    int numberOfItems = entry.getValue();
                    report.append(product.getName()).append(" (").append(product.getID()).append("): ")
                          .append(numberOfItems).append("\n");
                }
                report.append("-----------------------------------\n");
            }
        }
        return report.toString();
    }
    
     /**
     * Get a list of all transactions associated with this report.
     * @return A list of Transaction objects.
     */
    public List<Transaction> getTransactions(){
        return transactionsManager.getTransactions();
    }

}