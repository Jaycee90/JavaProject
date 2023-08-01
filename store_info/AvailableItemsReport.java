package store_info;

import java.util.List;

/**
 * A report class that prints the report of available items in the inventory.
 */
public class AvailableItemsReport implements Report {

    private StockManager stockManager;

    /**
     * Constructor to initialize the AvailableItemsReport with the StockManager.
     * @param stockManager The StockManager used for generating the report.
     */
    public AvailableItemsReport(StockManager stockManager) {
        this.stockManager = stockManager;
    }

    /**
     * Print the report of available items in the inventory.
     * The report displays the name, ID, and available quantity of each product.
     */
    @Override    
    public void printReport() {
        List<Product> products = stockManager.getProducts();
        System.out.println("Available Items Report:");
        System.out.println("Products appear in the format: name(id): amount");
        for (Product product : products) {
            int numberOfItems = product.getNumberOfItems();
            System.out.println(product.getName() + " (" + product.getID() + 
                               "): " + numberOfItems);
        }
        System.out.println("Report saved to AvailableItemsReport.txt");
    }

}