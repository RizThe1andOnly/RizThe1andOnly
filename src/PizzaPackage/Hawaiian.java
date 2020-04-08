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
    private final int Hawaiian_small=8;
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
        if(this.size.equals("Small")){
            return Hawaiian_small;
        }else  if(this.size.equals("Medium")){
            return Hawaiian_small+2;
        }else if(this.size.equals("Large")){
            return Hawaiian_small+4;
        }
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
        return this.style+" pizza with a "+this.size+" size and the prize is $"+this.pizzaPrice()+" dollars.";


    }
    public static void main(String[] args){
        Hawaiian T1=new Hawaiian("Hawaiian","Small");
        System.out.println(T1.toString());
        Hawaiian T2=new Hawaiian("Hawaiian","Medium");
        System.out.println(T2.toString());
        Hawaiian T3=new Hawaiian("Hawaiian","Large");
        System.out.println(T3.toString());
    }
}
