package store_info;


/**
 * The Store class represents a store in the inventory management system.
 * It contains information about the store, such as its ID, name, and address.
 */
public class Store {

    /**
     * The unique identifier for the store.
     */
    private int ID;

    /**
     * The name of the store.
     */
    private String name;

    /**
     * The address of the store.
     */
    private String address;

    /**
     * Default constructor
     */
    public Store() {
    }

    /**
     * Constructor with arguments to initialize a new store.
     * @param ID The unique identifier for the store.
     * @param name The name of the store.
     * @param address The address of the store.
     */
    public Store(int ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
    }

     /**
     * Retrieves the name of the store.
     * @return The name of the store.
     */
    public String getName() {
        return name;
    }

     /**
     * Retrieves the ID of the store.
     * @return The ID of the store.
     */
    public int getID() {
        return ID;
    }

    /*
     * Retrieves the address of the store.
     * @return The address of the store.
     */
    public String getAddress() {
        return address;
    }
}