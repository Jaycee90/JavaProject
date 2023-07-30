
package store_info;

import java.util.Date;
import java.util.Scanner;

/**
 * The Main class represents the entry point of the store 
 * information system. It contains references to various 
 * managers responsible for managing different aspects of the store.
 */
public class Main {

    public static void main(String[] args) {
        // Initialization of the inventory management system components
        StockManager stockManager = new StockManager();
        ReportsManager reportsManager = new ReportsManager();
        TransactionsManager transactionsManager = new TransactionsManager();

        // Generating reports and save to .txt files
        Report availableItemsReport = new AvailableItemsReport(stockManager);
        Report allItemsEnteredReport = new AllItemsEnteredReport(transactionsManager);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inventory Management System Menu");
            System.out.println("________________________________\n");
            System.out.println("p: Add Product");
            System.out.println("s: Add Store");
            System.out.println("i: Perform Incoming Transaction");
            System.out.println("o: Perform Outgoing Transaction");
            System.out.println("r: Generate Reports");
            System.out.println("x: Exit Program\n");

            System.out.print("Input an action: ");
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "p":
                    //Add product input
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product amount: ");
                    int productAmount = Integer.parseInt(scanner.nextLine());
                    Product product = new Product(stockManager.getNextProductID(), productName);
                    product.setNumberOfItems(productAmount);
                    stockManager.addProduct(product);
                    break;

                case "s":
                    //Add store input
                    System.out.print("Enter store name: ");
                    String storeName = scanner.nextLine();
                    System.out.print("Enter store address: ");
                    String storeAddress = scanner.nextLine();
                    Store store = new Store(stockManager.getNextStoreID(), storeName, storeAddress);
                    stockManager.addStore(store);
                    break;

                case "i":
                    // Perform incoming transaction
                    System.out.println("List of available products for the transaction:");
                    for (Product prod : stockManager.getProducts()) {
                        System.out.println(prod.getID() + ": " + prod.getName());
                    }

                    System.out.print("Select a product: ");
                    int productID = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter product quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    // Get the selected product and create an incoming transaction
                    Product selectedProduct = stockManager.getProductByID(productID);
                    if (selectedProduct == null) {
                        System.out.println("Invalid product ID, Transaction canceled.");
                    } else {
                        IncomingTransaction incomingTransaction = new IncomingTransaction(transactionsManager.getNextTransactionID(), new Date());
                        incomingTransaction.addProduct(selectedProduct, quantity);
                        transactionsManager.addTransaction(incomingTransaction);
                        System.out.println("Incoming transaction successfully added!");
                    }
                    break;

                case "o":
                    // Perform outgoing transaction
                    System.out.println("List of available stores for the transaction:");
                    for (Store myStore : stockManager.getStores()) {
                        System.out.println(myStore.getID() + ": " + myStore.getName());
                    }

                    System.out.print("Select a store: ");
                    int storeID = Integer.parseInt(scanner.nextLine());

                    System.out.println("List of available products for the transaction:");
                    for (Product prod : stockManager.getProducts()) {
                        System.out.println(prod.getID() + ": " + prod.getName());
                    }

                    System.out.print("Select a product: ");
                    productID = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter product quantity: ");
                    quantity = Integer.parseInt(scanner.nextLine());

                    // Get the selected store and product and create an outgoing transaction
                    Store selectedStore = stockManager.getStoreByID(storeID);
                    selectedProduct = stockManager.getProductByID(productID);
                    if (selectedStore == null || selectedProduct == null) {
                        System.out.println("Invalid store ID or product ID. Transaction canceled.");
                    } else {
                        OutgoingTransaction outgoingTransaction = new OutgoingTransaction(transactionsManager.getNextTransactionID(), new Date());
                        outgoingTransaction.addProduct(selectedProduct, quantity);
                        transactionsManager.addTransaction(outgoingTransaction);
                        System.out.println("Outgoing transaction successfully added!");
                    }
                    break;

                case "r":
                    System.out.println("Generating reports...");
                    // Generate reports
                    reportsManager.generateReport(availableItemsReport);
                    reportsManager.generateReport(allItemsEnteredReport);
                    // You can add more reports here if needed: FIXME
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
