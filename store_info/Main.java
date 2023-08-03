
package store_info;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The Main class represents the entry point of the store 
 * information system. It contains references to various 
 * managers responsible for managing different aspects of the store.
 */
public class Main {
    /**
     * The main method serves as the entry point of the inventory management system.
     * It initializes the components of the system, such as StockManager, ReportsManager,
     * and TransactionsManager. Then, it presents a menu to the user for performing various actions,
     * such as adding products, adding stores, performing incoming and outgoing transactions,
     * generating reports, and exiting the program.
     *
     * @param args Command-line arguments.
     */

    public static void main(String[] args) {
        // Initialization of the inventory management system components
        StockManager stockManager = new StockManager();
        ReportsManager reportsManager = new ReportsManager();
        TransactionsManager transactionsManager = new TransactionsManager();

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
                        IncomingTransaction incomingTransaction = new IncomingTransaction(transactionsManager.
                                                                  getNextTransactionID(), new Date());
                        incomingTransaction.addProduct(selectedProduct, quantity);
                        //update the quantity in the warehouse(storeID = 0)
                        selectedProduct.addToQuantitySentToStore(0, quantity);
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
                        // Check if there are enough items in the warehouse
                        int warehouseQuantity = selectedProduct.getNumberOfItems();
                        if (warehouseQuantity < quantity){
                            System.out.println("Not enough items in the warehouse. Transaction canceled.");
                        }
                        else{
                            OutgoingTransaction outgoingTransaction = new OutgoingTransaction
                            (transactionsManager.getNextTransactionID(), new Date(), storeID,  selectedStore.getAddress());
                            outgoingTransaction.addProduct(selectedProduct, quantity);

                            // Deduct the quantity from the warehouse and add it to the store
                            selectedProduct.addToQuantitySentToStore(0, -quantity);
                            selectedProduct.addToQuantitySentToStore(selectedStore.getID(), quantity);
                            
                            transactionsManager.addTransaction(outgoingTransaction);
                            System.out.println("Outgoing transaction successfully added!");
                        }
                    }
                    break;

                case "r":
                    System.out.println("Generate Reports Submenu");
                    System.out.println("Note:Reports are also saved to .txt files");
                    System.out.println("__________________________________________\n");
                    System.out.println("a: Available Items Report");
                    System.out.println("v: Incoming Products Report");
                    System.out.println("s: Items Sent to Stores Report");
                    System.out.println("t: All Transactions Report");
                    System.out.println("x: Return to Main Menu\n");

                    System.out.print("Choose a report to generate: ");
                    String reportOption = scanner.nextLine().toLowerCase();

                    switch (reportOption) {
                        case "a":
                            reportsManager.generateAvailableItemsReport(stockManager);
                            break;

                        case "v":
                            reportsManager.generateAllItemsEnteredReport(transactionsManager);
                            break;

                        case "s":
                            reportsManager.generateItemsSentToStoresReport(stockManager);
                            break;

                        case "t":
                            System.out.println("All Transactions Report:");
                            List<Transaction> transactions = transactionsManager.getTransactions();
                            for (Transaction transaction : transactions) {
                                System.out.println("Transaction ID: " + transaction.getID());
                                System.out.println("Date: " + transaction.getDate());
                                System.out.println("Transaction Type: " + transaction.getTransactionType());

                                Map<Product, Integer> productList = transaction.getProductList();
                                for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
                                    Product myProd = entry.getKey();
                                    int numberOfItems = entry.getValue();
                                    System.out.println(myProd.getName() + " (ID:" + myProd.getID() + 
                                                                     ") - Quantity: " + numberOfItems);
                                }

                            if (transaction instanceof OutgoingTransaction) {
                                OutgoingTransaction outgoingTransaction = (OutgoingTransaction) transaction;
                                System.out.println("Store (" + outgoingTransaction.getStoreID() + "), Address: " + 
                                outgoingTransaction.getStoreAddr());
                            }

                            System.out.println("-----------------------------------");
                            }
                            reportsManager.generateAllTransactionsReport(transactionsManager,stockManager);
                            break;

                        case "x":
                            System.out.println("Returning to the Main Menu...");
                            break;

                        default:
                            System.out.println("Invalid input. Please try again.");
                    }
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
