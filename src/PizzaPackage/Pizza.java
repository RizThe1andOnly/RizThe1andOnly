package PizzaPackage;

import java.util.ArrayList;

/**
 * Abstract class defining a Pizza object. Pizza object has style of pizza, its size,
 * and its toppings.
 *
 * This class was given as a skeleton by instructor and filled out and edited by following:
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public abstract class Pizza {
    protected String style;
    protected String size;
    protected ArrayList<String> toppings;

    /**
     * Creates pizza object with style, size, and toppings. This will be used primarily for
     * Build Your Own pizza style.
     * @param style The type of pizza.
     * @param size How large the pie is: small,medium,large
     * @param topppings Additional foods placed on the pizza pie
     *
     * @author Rizwan Chowdhury
     */
    public Pizza(String style, String size, ArrayList<String> topppings){
        //initialize the class variables with the parameters
        this.style = style;
        this.size = size;
        this.toppings = topppings;
    }


    /**
     * Creates pizza object with just style and size. The are pre-determined, this will either be
     * a Hawaiian or Deluxe pizza.
     * @param style The type of pizza.
     * @param size How large the pie is: small,medium,large
     *
     * @author Rizwan Chowdhury
     */
    public Pizza(String style, String size){
        //initialize class variables
        this.style = style;
        this.size = size;
    }


    /**
     * Abstract method to calculate how much the particular pizza pie that calls this
     * method costs.
     * @return int, the price of the pizza
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public abstract int pizzaPrice();


    /**
     * Returns String representation of the Pizza object. This one will return the
     * type and size.
     * @return
     */
    public String toString(){
        /// !!! THIS NEEDS TO BE COMPLETED
        return "";
    }

}
