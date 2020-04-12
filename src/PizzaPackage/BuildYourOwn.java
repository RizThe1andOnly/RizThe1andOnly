package PizzaPackage;

import java.util.ArrayList;

/**
 * Build Your Own Pizza object. This class extends the Pizza class and will
 * be used to create Pizza of type Build Your Own.
 *
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class BuildYourOwn extends Pizza{
    private final int BUILDYOUROWN_SMALL=5;
    private final int PER_TOPPING=2;
    

    /**
     * Constructor for the build your own pizza object. With this customer customize their own pizza with available
     * materials.
     * @param style Build Your Own, kept for object creation purposes
     * @param size Size of pizza, small, medium, large
     * @param toppings the toppings the customer will have on pizza
     *
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public BuildYourOwn(String style,String size, ArrayList<String> toppings){
       super(style,size,toppings);
    }


    /**
     * Calculates the price of the pizza object that this method belongs to. Price based on type
     * size and toppings.
     * @return int, price of the pizza
     *
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public int pizzaPrice() {
        if(this.size.equals("Small")){
            return BUILDYOUROWN_SMALL+toppings.size()*PER_TOPPING;
        }else  if(this.size.equals("Medium")){
            return BUILDYOUROWN_SMALL+ MEDIUM_ADDITIONAL_FLAT_COST +toppings.size()*PER_TOPPING;
        }else if(this.size.equals("Large")){
            return BUILDYOUROWN_SMALL+ LARGE_ADDITIONAL_FLAT_COST +toppings.size()*PER_TOPPING;
        }
        // !!! NEEDS TO BE COMPLETED
        return 0;
    }


    /**
     * Generates the string representation for the object to be displayed.
     * @return String, string representation containing information on the object
     *
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public String toString(){
        String byoPizzaDetails = this.style + " : " + this.size + "\n"
                                 +"  Toppings: \n" + generateToppingListString();
        return byoPizzaDetails;
    }


    /**
     * Helper method to create list of toppings string to be printed in view orders list.
     * @return List of toppings
     * @author Rizwan Chowdhury
     */
    private String generateToppingListString(){
        String toppingList = "";
        String currentTopping = "";
        for(String topping : this.toppings){
            currentTopping = "  ----" + topping + "\n";
            toppingList = toppingList + currentTopping;
        }
        return toppingList;
    }

}
