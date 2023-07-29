package store_info;
import java.util.*;

/**
 * The ReportsManager class is responsible for generating 
 * various reports for the store. It contains methods to 
 * generate different types of reports based on store data.
 */
public class ReportsManager {

    /**
     * Default constructor for the ReportsManager class.
     * This constructor initializes the ReportsManager object.
     */
    public ReportsManager() {
    }

    /**
     * Generate a report and print it.
     * @param report The Report object representing 
     * the report to be generated.
     */
    public void generateReport(Report report) {
        report.printReport();
    }

    /**
     * Generate a report of all items entered in the inventory.
     * @param transactionsManager The TransactionsManager object to retrieve the transactions.
     */
    public void generateAllItemsEnteredReport(TransactionsManager transactionsManager) {
        Report allItemsEnteredReport = new AllItemsEnteredReport(transactionsManager);
        generateReport(allItemsEnteredReport);
    }

    /**
     * Generate a report of available items in the inventory.
     * @param stockManager The StockManager object to retrieve the products.
     */
    public void generateAvailableItemsReport(StockManager stockManager) {
        Report availableItemsReport = new AvailableItemsReport(stockManager);
        generateReport(availableItemsReport);
    }

    /**
     * Generate a report of products sent to a specific store.
     * @param stockManager The StockManager object to retrieve the products.
     * @param store The Store object representing the store.
     */
    public void generateProductByStoreReport(StockManager stockManager, Store store) {
        Report productByStoreReport = new ProductByStoreReport(stockManager, store);
        generateReport(productByStoreReport);
    }
}