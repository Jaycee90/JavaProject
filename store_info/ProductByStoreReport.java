package store_info;

import java.util.List;

/**
 * 
 */
public class ProductByStoreReport implements Report {

    private StockManager stockManager;
    private Store store;

    /**
     * Constructor to initialize the ProductByStoreReport 
     * with the StockManager and Store.
     */
    public ProductByStoreReport(StockManager stockManager, Store store) {
        this.stockManager = stockManager;
        this.store = store;
    }

    /*
     * Print the report of products sent to the specified store.
     */

    @Override
    public void printReport() {
        System.out.println("Products sent to store: " + store.getName() + " (ID: " + 
                                                        store.getID() + ")");
        List<Product> products = stockManager.getProducts();
        for (Product product : products) {
            int quantitySentToStore = product.getQuantitySentToStore(store.getID());
            if (quantitySentToStore > 0) {
                System.out.println(product.getName() + " (ID: " + product.getID() +
                                        ") - Quantity:" + quantitySentToStore);
            }
        }
    }
}