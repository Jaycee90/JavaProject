package store_info;
import java.util.*;

/**
 * 
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

    //Constructor with arguments
    public Store (int ID, String name, String address){
        this.ID = ID;
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return ID;
    }

    public String getAddress(){
        return address;
    }

}