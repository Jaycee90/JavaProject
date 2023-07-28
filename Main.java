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

        // Create some products and stores
        Product product1 = new Product(1, "Product 1");
        Product product2 = new Product(2, "Product 2");
        Store store1 = new Store(1, "Store 1", "Address 1");
        Store store2 = new Store(2, "Store 2", "Address 2");

        // Add products and stores to the inventory
        stockManager.addProduct(product1);
        stockManager.addProduct(product2);
        stockManager.addStore(store1);
        stockManager.addStore(store2);

        // Perform incoming transaction
        IncomingTransaction incomingTransaction = new IncomingTransaction(1, new Date());
        incomingTransaction.addProduct(product1, 100);
        incomingTransaction.addProduct(product2, 50);
        transactionsManager.addTransaction(incomingTransaction);

        // Perform outgoing transaction
        OutgoingTransaction outgoingTransaction = new OutgoingTransaction(2, new Date());
        outgoingTransaction.addProduct(product1, 30);
        transactionsManager.addTransaction(outgoingTransaction);

        // Generate reports
        Report availableItemsReport = new AvailableItemsReport(stockManager);
        Report allItemsEnteredReport = new AllItemsEnteredReport(transactionsManager);
        Report productByStoreReport = new ProductByStoreReport(stockManager, store1);

        reportsManager.generateReport(availableItemsReport);
        reportsManager.generateReport(allItemsEnteredReport);
        reportsManager.generateReport(productByStoreReport);
    }
}