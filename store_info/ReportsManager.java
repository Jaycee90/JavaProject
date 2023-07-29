package store_info;
import java.util.*;

/**
 * The ReportsManager class is responsible for generating 
 * various reports for the store. It contains methods to 
 * generate different types of reports based on store data.
 */
public class ReportsManager {

    /**
     * Default constructor for the ReportsManager class.
     * This constructor initializes the ReportsManager object.
     */
    public ReportsManager() {
    }

    /**
     * Generate a report and print it.
     * @param report The Report object representing 
     * the report to be generated.
     */
    public void generateReport(Report report) {
        report.printReport();
    }

}