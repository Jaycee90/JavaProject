package store_info;
/**
 * The AllItemsEnteredReport class represents a report that contains information about all items entered in the store.
 * This class implements the Report interface, which defines the common behavior for generating and printing reports.
 * It provides methods to collect and display information about the items.
 */
public class AllItemsEnteredReport implements Report {

    /**
     * Constructs an instance of the report with default settings.
     */
    public AllItemsEnteredReport() {
    }

    /**
     * Prints the report containing information about all items entered in the store.
     * This method will generate and display the collected data in a readable format.
     * The report will typically include details such as item names, quantities, and other relevant information.
     * If no items have been entered, the report may indicate that the store is currently empty.
     */
    public void printReport() {
        // TODO implement here
    }

    /**
     * Private method to collect the items that have been entered in the store.
     * This method will be called internally within the class to gather the necessary data for the report.
     * It may involve accessing a database, retrieving item information, and storing it in the appropriate format.
     * The collected data will later be used when generating the report in the printReport() method.
     */
    private void collectItemsEntered() {
        // TODO implement here
    }

}