package store_info;
import java.util.*;

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

    /**
     Generate and print the report of all available items in the inventory. 
     //
     */
    @Override
   public void printReport() {
       System.out.println("Available Items Report:");
       List<Product> products = stockManager.getProducts();
       for (Product product : products) {
           int numberOfItems = product.getNumberOfItems();
           System.out.println(product.getName() + " (ID: " + product.getID() + ") - Quantity: " + numberOfItems);
       }
   }

}