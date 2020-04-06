package PizzaPackage;

/**
 * Hawaiian pizza object used to build pies of type Hawaiian. This class extends
 * Pizza and has its own preset toppings to be used.
 *
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */


public class Hawaiian extends Pizza {
    // !!! NEEDS TO BE COMPLETED

    // NOTE THAT THE PROTECTED VARIABLES ARE AVAILABLE HERE SO DON'T NEED TO RE-CREATE THEM HERE

    /**
     * Constructs the Hawaiian pizza object.
     * @param style Hawaiian, kept for creation purposes
     * @param size Size of pizza pie: small, medium, large
     *
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public Hawaiian(String style, String size){
        super(style, size);
    }


    /**
     * Calculates the price of the Hawaiian Pizza pie based on its size.
     * @return int, price of the pie.
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public int pizzaPrice() {
        // !!! NEEDS TO BE COMPLETED
        return 0;
    }

    /**
     * Generates the string representation of the object, containing information on the Hawaiian pizza.
     * @return The string representation of the object.
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public String toString() {
        // !!! NEEDS TO BE COMPLETED
        return "";
    }
}
