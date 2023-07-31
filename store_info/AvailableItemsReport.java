package store_info;

import java.util.List;

/**
 * 
 */
public class AvailableItemsReport implements Report {

    private StockManager stockManager;

    /**
     * Constructor to initialize the AvailableItemsReport with the StockManager.
     */
    public AvailableItemsReport(StockManager stockManager) {
        this.stockManager = stockManager;
    }

    @Override    
    public void printReport() {
        List<Product> products = stockManager.getProducts();
        System.out.println("Available Items Report:");
        System.out.println("Products appear in the format: name(id): amount");
        for (Product product : products) {
            int numberOfItems = product.getNumberOfItems();
            System.out.println(product.getName() + " (" + product.getID() + "): " + numberOfItems);
        }
        System.out.println("Report saved to AvailableItemsReport.txt");
    }

}