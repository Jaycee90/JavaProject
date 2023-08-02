package store_info;

import java.util.List;

/**
 * A report class that prints the report of products 
 * sent to a specific store in the inventory.
 */
public class ProductByStoreReport implements Report {

    private StockManager stockManager;
    private Store store;

    /**
     * Constructor to initialize the ProductByStoreReport with the 
     * provided StockManager and Store.
     * @param stockManager The StockManager used for generating the report.
     * @param store The Store for which the report is generated.
     */
    public ProductByStoreReport(StockManager stockManager, Store store) {
        this.stockManager = stockManager;
        this.store = store;
    }

    /**
     * Print the report of products sent to the specified store.
     * This report lists the products and their quantities sent to the specified store.
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

     /**
     * Save the report of products sent to the specified store to a txt file.
     * This report lists the products and their quantities sent to the specified store.
     */
    @Override
    public String reportMe() {
        StringBuilder report = new StringBuilder();
        report.append("Products sent to store: ").append(store.getName()).append(" (ID: ").
               append(store.getID()).append(")\n");
        List<Product> products = stockManager.getProducts();
        for (Product product : products) {
            int quantitySentToStore = product.getQuantitySentToStore(store.getID());
            if (quantitySentToStore > 0) {
                report.append(product.getName()).append(" (ID: ").append(product.getID())
                      .append(") - Quantity: ").append(quantitySentToStore).append("\n");
            }
        }
        return report.toString();
    }
}