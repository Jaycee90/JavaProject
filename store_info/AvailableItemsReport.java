package store_info;
import java.io.FileWriter;
import java.io.IOException;
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
//     @Override
//    public void printReport() {
//        System.out.println("Available Items Report:");
//        System.out.println("Products appear in the format: name(id): amount");
//        List<Product> products = stockManager.getProducts();
//        for (Product product : products) {
//            int numberOfItems = product.getNumberOfItems();
//            System.out.println(product.getName() + " (" + product.getID() + "): " + numberOfItems);
//            //System.out.println(product.getName() + " (ID: " + product.getID() + ") - Quantity: " + numberOfItems);
//        }
//    }
    @Override    
    public void printReport() {
        List<Product> products = stockManager.getProducts();
        try (FileWriter fileWriter = new FileWriter("AvailableItemsReport.txt")) {
            fileWriter.write("Available Items Report:\n");
            fileWriter.write("Products appear in the format: name(id): amount\n");
            for (Product product : products) {
                int numberOfItems = product.getNumberOfItems();
                fileWriter.write(product.getName() + " (" + product.getID() + "): " + numberOfItems + "\n");
            }
            System.out.println("Report saved to AvailableItemsReport.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}