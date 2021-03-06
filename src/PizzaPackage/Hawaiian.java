package PizzaPackage;

/**
 * Hawaiian pizza object used to build pies of type Hawaiian. This class extends
 * Pizza and has its own preset toppings to be used.
 *
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class Hawaiian extends Pizza {
    private final int HAWAIIAN_SMALL=8;

    //Constants for toppings:
    private final String HAM = "Ham";
    private final String PINEAPPLE = "Pineapple";


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
        this.toppings.add(HAM);
        this.toppings.add(PINEAPPLE);
    }


    /**
     * Calculates the price of the Hawaiian Pizza pie based on its size.
     * @return int, price of the pie.
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public int pizzaPrice() {
        if(this.size.equals("Small")){
            return HAWAIIAN_SMALL;
        }else  if(this.size.equals("Medium")){
            return HAWAIIAN_SMALL+ MEDIUM_ADDITIONAL_FLAT_COST;
        }else if(this.size.equals("Large")){
            return HAWAIIAN_SMALL+ LARGE_ADDITIONAL_FLAT_COST;
        }
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
        String hawaiianPizzaDetails = this.style + " : " + this.size + "\n"
                                      +"  Toppings: \n"+ generateToppingListString();
        return hawaiianPizzaDetails;
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
