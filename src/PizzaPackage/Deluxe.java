package PizzaPackage;

/**
 * Deluxe Pizza object, for creating pies of type Deluxe. This class has
 * a predefined set of toppings that will be used for the pie.
 *
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class Deluxe extends Pizza {
    private final int Deluxe_small=14;

    //constants for toppings:
    private final String SAUSAGE = "Sausage";
    private final String PEPPERONI = "Pepperoni";
    private final String GREEN_PEPPER = "Green Pepper";
    private final String ONION = "Onion";
    private final String MUSHROOM = "Mushroom";

    /**
     * Constructs the Deluxe pizza object.
     * @param style Deluxe, used for creation purposes
     * @param size Size of pie: Small, Medium, Large
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public Deluxe(String style, String size){
        super(style,size);
        this.toppings.add(SAUSAGE);
        this.toppings.add(PEPPERONI);
        this.toppings.add(GREEN_PEPPER);
        this.toppings.add(ONION);
        this.toppings.add(MUSHROOM);
    }


    /**
     * Calculates the price for a deluxe pizza based on the size.
     * @return int, price of the pie
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public int pizzaPrice() {

        if(this.size.equals("Small")){
            return Deluxe_small;
        }else  if(this.size.equals("Medium")){
            return Deluxe_small + MEDIUM_ADDITIONAL_FLAT_COST;
        }else if(this.size.equals("Large")){
            return Deluxe_small + LARGE_ADDITIONAL_FLAT_COST;
        }
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
        String deluxePizzaDetails = this.style + " : " + this.size + "\n"
                                    + "  Toppings: \n" + generateToppingListString();
        return deluxePizzaDetails;

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
