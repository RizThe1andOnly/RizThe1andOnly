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

        if(this.size.equals("Small")){
            return Deluxe_small;
        }else  if(this.size.equals("Medium")){
            return Deluxe_small+2;
        }else if(this.size.equals("Large")){
            return Deluxe_small+4;
        }
            // !!! NEEDS TO BE COMPLETED
            return 0;
    }
        // !!! NEEDS TO BE COMPLETED


    /**
     * Returns string representation of object containing information regarding the deluxe pie.
     * @return String, the string representation of the object
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public String toString() {
        return this.style+" pizza with a "+this.size+" size and the prize is $"+this.pizzaPrice()+" dollars.";

    }
    public static void main(String[] args){
         Deluxe T1=new Deluxe("Deluxe","Small");
         System.out.println(T1.toString());
        Deluxe T2=new Deluxe("Deluxe","Medium");
        System.out.println(T2.toString());
        Deluxe T3=new Deluxe("Deluxe","Large");
        System.out.println(T3.toString());
    }
}
