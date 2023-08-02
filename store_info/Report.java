package store_info;

/**
 * The Report interface represents a contract for generating store reports.
 * Classes that implement this interface are responsible for generating 
 * specific types of reports. Each implementing class should provide 
 * an implementation for the report generation logic.
 */
public interface Report {
    /*
     * Generates the specific report based on store data. 
     * The specific details and format of the report 
     * should be described in the implementation.
     */
    void printReport();

     /*
     * Generates the specific report based on store data and write it 
     * to a .txt file.
     */
    String reportMe();

}