package store_info;


/**
 * This class represents a store in the inventory management system.
 * It contains information about the store, such as ID, name, and address.
 */
public class Store {

    private int ID;
    private String name;
    private String address;

    /**
     * Default constructor
     */
    public Store() {
    }

    // Constructor with arguments
    public Store(int ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }
}