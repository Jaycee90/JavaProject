package store_info;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    public void generateItemsSentToStoresReport(StockManager stockManager) {
        List<Store> stores = stockManager.getStores();
        StringBuilder report = new StringBuilder();
        report.append("Items Sent to Stores Report:\n");
        for (Store store : stores) {
            boolean anyItemSent = false;
            report.append("Store: ").append(store.getName()).append(" (ID: ").append(store.getID()).append(")\n");
            List<Product> products = stockManager.getProducts();
            for (Product product : products) {
                int quantitySentToStore = product.getQuantitySentToStore(store.getID());
                if (quantitySentToStore > 0) {
                    anyItemSent = true;
                    report.append(product.getName()).append(" (ID: ").append(product.getID()).append(") - Quantity: ").append(quantitySentToStore).append("\n");
                }
            }
            if (anyItemSent) {
                report.append("-----------------------------------\n");
            } else {
                report.append("No items sent to this store.\n");
                report.append("-----------------------------------\n");
            }
        }
        System.out.println(report.toString());
        saveReportToFile("ItemsSentToStoresReport.txt", report.toString());
    }


    public void generateAllTransactionsReport(TransactionsManager transactionsManager) {
    List<Transaction> transactions = transactionsManager.getTransactions();
    StringBuilder report = new StringBuilder();
    report.append("All Transactions Report:\n");
    for (Transaction transaction : transactions) {
        report.append("Transaction ID: ").append(transaction.getID()).append("\n");
        report.append("Date: ").append(transaction.getDate()).append("\n");
        report.append("Products: \n");
        for (Map.Entry<Product, Integer> entry : transaction.getProductList().entrySet()) {
            Product product = entry.getKey();
            int numberOfItems = entry.getValue();
            report.append(product.getName()).append("(ID: ").append(product.getID()).append(") - Quantity: ").append(numberOfItems).append("\n");
        }
        report.append("-----------------------------------\n");
    }
    System.out.println(report.toString());
    saveReportToFile("AllTransactionsReport.txt", report.toString());
}

private void saveReportToFile(String fileName, String report) {
    try (FileWriter fileWriter = new FileWriter(fileName)) {
        fileWriter.write(report);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}