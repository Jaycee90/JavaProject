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
        System.out.println("\nAvailable Items Report:");
        System.out.println("Products appear in the format: name(id): amount\n");
        List<Product> products = stockManager.getProducts();
        for (Product product : products) {
            if (product.getNumberOfItems() > 0) {
                System.out.println(product.getName() + " (" + product.getID() + 
                                    "): " + product.getNumberOfItems());
            }
        }
        System.out.println("\nReport saved to AvailableItemsReport.txt\n");
    }

     /**
     * Write the report of available items in the inventory to a txt file.
     * The report displays the name, ID, and available quantity of each product.
     */
    @Override
    public String reportMe() {
        StringBuilder report = new StringBuilder();
        report.append("\nAvailable Items Report:\n").
        append("Products appear in the format: name(id): amount\n");
        List<Product> products = stockManager.getProducts();
        for (Product product : products) {
            if (product.getNumberOfItems() > 0) {
                report.append(product.getName()).append(" (").append(product.getID())
                      .append("): ").append(product.getNumberOfItems()).append("\n");
            }
        }
        return report.toString();
    }

}