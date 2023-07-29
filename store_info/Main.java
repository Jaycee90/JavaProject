package store_info;
import java.util.*;

/**
 * The Main class represents the entry point of the store 
 * information system. It contains references to various 
 * managers responsible for managing different aspects of the store.
 */

public class Main {

    public static void main(String[] args) {
        // Initialize the inventory management system components
        StockManager stockManager = new StockManager();
        ReportsManager reportsManager = new ReportsManager();
        TransactionsManager transactionsManager = new TransactionsManager();

        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inventory Management System Menu");
            System.out.println("p: Add Product");
            System.out.println("s: Add Store");
            System.out.println("i: Perform Incoming Transaction");
            System.out.println("o: Perform Outgoing Transaction");
            System.out.println("r: Generate Reports");
            System.out.println("x: Exit Program");

            System.out.print("Input an action: ");
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "p":
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product amount: ");
                    int productAmount = Integer.parseInt(scanner.nextLine());
                    Product product = new Product(stockManager.getNextProductID(), productName);
                    product.setNumberOfItems(productAmount);
                    stockManager.addProduct(product);
                    break;

                case "s":
                    System.out.print("Enter store name: ");
                    String storeName = scanner.nextLine();
                    System.out.print("Enter store address: ");
                    String storeAddress = scanner.nextLine();
                    Store store = new Store(stockManager.getNextStoreID(), storeName, storeAddress);
                    stockManager.addStore(store);
                    break;

                case "i":
                    // Perform incoming transaction
                    // Implementation code here...
                    break;

                case "o":
                    // Perform outgoing transaction
                    // Implementation code here...
                    break;

                case "r":
                    System.out.println("Generating reports...");
                    // Generate reports
                    Report availableItemsReport = new AvailableItemsReport(stockManager);
                    Report allItemsEnteredReport = new AllItemsEnteredReport(transactionsManager);

                    reportsManager.generateReport(availableItemsReport);
                    reportsManager.generateReport(allItemsEnteredReport);
                    // You can add more reports here if needed
                    break;

                case "x":
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}