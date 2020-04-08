package PizzaPackage;

import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Build Your Own Pizza object. This class extends the Pizza class and will
 * be used to create Pizza of type Build Your Own.
 *
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class BuildYourOwn extends Pizza{
    private final int BuildYourOwn_small=5;
    private final int per_Topping=2;

    // !!! NEEDS TO BE COMPLETED
    // NOTE THAT THE PROTECTED VARIABLES ARE AVAILABLE HERE SO DON'T NEED TO RE-CREATE THEM HERE

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
            return BuildYourOwn_small+toppings.size()*per_Topping;
        }else  if(this.size.equals("Medium")){
            return BuildYourOwn_small+2+toppings.size()*per_Topping;
        }else if(this.size.equals("Large")){
            return BuildYourOwn_small+4+toppings.size()*per_Topping;
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
        return this.style+" pizza with a "+this.size+" size and the prize is $"+this.pizzaPrice()+" dollars.";
    }
    public static void main(String[] args){
        ArrayList<String> tops = new ArrayList<String>();

        BuildYourOwn T1=new BuildYourOwn("BuildYourOwn","Small",tops);

        System.out.println(T1.toString());
        tops.add("Beef");

        BuildYourOwn T2=new BuildYourOwn("BuildYourOwn","Medium",tops);
        System.out.println(T2.toString());
        tops.add("Cheese");
        tops.add("Green Pepper");
        tops.add("Chicken");

        BuildYourOwn T3=new BuildYourOwn("BuildYourOwn","Large",tops);
        System.out.println(T3.toString());
    }
}
