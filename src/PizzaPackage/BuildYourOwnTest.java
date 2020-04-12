package PizzaPackage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * JUnit test class to test the functionalities of the BuildYourOwn Pizza class.
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class BuildYourOwnTest {

    //pizza types:
    private final String BUILDOWNPIZZA = "Build Your Own";

    //pizza sizes:
    private final String SMALL = "Small";
    private final String MEDIUM = "Medium";
    private final String LARGE = "Large";

    //pizza toppings:
    private final String SAUSAGE = "Sausage";
    private final String PEPPERONI = "Pepperoni";
    private final String GREEN_PEPPER = "Green Pepper";
    private final String ONION = "Onion";
    private final String MUSHROOM = "Mushroom";
    private final String HAM = "Ham";

    /**
     * Tests the pizzaPrice method of the BuildYourOwn class.
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @org.junit.Test
    public void pizzaPrice() {
        /**
         * Testing will consist of testing different number of toppings for each size. For each size
         * 1 topping, 4 toppings, and 6 toppings will be tested to see if price returned is correct.
         */
        // set the lists with different number of toppings
         //one topping
        ArrayList<String> oneTopping = new ArrayList<String>();
        oneTopping.add(SAUSAGE);
         //four toppings
        ArrayList<String> fourToppings = new ArrayList<>();
        fourToppings.add(SAUSAGE);
        fourToppings.add(PEPPERONI);
        fourToppings.add(GREEN_PEPPER);
        fourToppings.add(ONION);
         //six toppings
        ArrayList<String> sixToppings = new ArrayList<>();
        sixToppings.add(SAUSAGE);
        sixToppings.add(PEPPERONI);
        sixToppings.add(GREEN_PEPPER);
        sixToppings.add(ONION);
        sixToppings.add(MUSHROOM);
        sixToppings.add(HAM);

        //test cases for each size:
         //small size:
        BuildYourOwn smallPizzaOneTopping = new BuildYourOwn(BUILDOWNPIZZA,SMALL,oneTopping);
        BuildYourOwn smallPizzaFourToppings = new BuildYourOwn(BUILDOWNPIZZA,SMALL,fourToppings);
        BuildYourOwn smallPizzaSixToppings = new BuildYourOwn(BUILDOWNPIZZA,SMALL,sixToppings);
          //tests:
        assertEquals(7,smallPizzaOneTopping.pizzaPrice());
        assertEquals(13,smallPizzaFourToppings.pizzaPrice());
        assertEquals(17,smallPizzaSixToppings.pizzaPrice());
         //medium size:
        BuildYourOwn mediumPizzaOneTopping = new BuildYourOwn(BUILDOWNPIZZA,MEDIUM,oneTopping);
        BuildYourOwn mediumPizzaFourToppings = new BuildYourOwn(BUILDOWNPIZZA,MEDIUM,fourToppings);
        BuildYourOwn mediumPizzaSixToppings = new BuildYourOwn(BUILDOWNPIZZA,MEDIUM,sixToppings);
          //tests:
        assertEquals(9,mediumPizzaOneTopping.pizzaPrice());
        assertEquals(15,mediumPizzaFourToppings.pizzaPrice());
        assertEquals(19,mediumPizzaSixToppings.pizzaPrice());
         //large size:
        BuildYourOwn largePizzaOneTopping = new BuildYourOwn(BUILDOWNPIZZA,LARGE,oneTopping);
        BuildYourOwn largePizzaFourToppings = new BuildYourOwn(BUILDOWNPIZZA,LARGE,fourToppings);
        BuildYourOwn largePizzaSixToppings = new BuildYourOwn(BUILDOWNPIZZA,LARGE,sixToppings);
          //tests:
        assertEquals(11,largePizzaOneTopping.pizzaPrice());
        assertEquals(17,largePizzaFourToppings.pizzaPrice());
        assertEquals(21,largePizzaSixToppings.pizzaPrice());

    }
}
