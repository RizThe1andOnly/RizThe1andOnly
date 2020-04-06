package PizzaPackage;

/**
 * Deluxe Pizza object, for creating pies of type Deluxe. This class has
 * a predefined set of toppings that will be used for the pie.
 *
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class Deluxe extends Pizza {
    // !!! NEEDS TO BE COMPLETED
    // NOTE THAT THE PROTECTED VARIABLES ARE AVAILABLE HERE SO DON'T NEED TO RE-CREATE THEM HERE

    /**
     * Constructs the Deluxe pizza object.
     * @param style Deluxe, used for creation purposes
     * @param size Size of pie: Small, Medium, Large
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public Deluxe(String style, String size){
        super(style,size);
    }


    /**
     * Calculates the price for a deluxe pizza based on the size.
     * @return int, price of the pie
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public int pizzaPrice() {
        // !!! NEEDS TO BE COMPLETED
        return 0;
    }


    /**
     * Returns string representation of object containing information regarding the deluxe pie.
     * @return String, the string representation of the object
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public String toString() {
        // !!! NEEDS TO BE COMPLETED
        return "";
    }
}
