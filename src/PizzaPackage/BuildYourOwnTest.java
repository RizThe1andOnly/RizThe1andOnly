package PizzaPackage;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildYourOwnTest {

    @org.junit.Test
    public void pizzaPrice() {
        ArrayList<String> tops = new ArrayList<String>();
        tops.add("Beef");
        BuildYourOwn T1=new BuildYourOwn("BuildYourOwn","Small",tops);
        assertEquals(7,T1.pizzaPrice());
        tops.add("Test");
        tops.add("Test");
        tops.add("Test");
        tops.add("Test");
        tops.add("Test");
        tops.add("Test");
        tops.add("Test");
        tops.add("Test");
        tops.add("Test");

        BuildYourOwn T2=new BuildYourOwn("BuildYourOwn","Small",tops);
        assertEquals(25,T1.pizzaPrice());

    }
}
