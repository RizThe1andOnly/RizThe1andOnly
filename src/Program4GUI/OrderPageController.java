package Program4GUI;

import PizzaPackage.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller class used for controlling the order view stage.
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class OrderPageController {

    @FXML
    private TextField totalPriceField;
    @FXML
    private TextArea orderListTextArea;

    /**
     * Prints the orders received from the selection page.
     * @param pizzaOrderList List of current pizzas ordered by the customer
     * @author Rizwan Chowdhury
     */
    public void printOrders(ArrayList<Pizza> pizzaOrderList){
        String pizzaPriceTag = "\t\t\tPrice: $";
        String toBePrinted = "";
        int currentPizzaPrice = 0;
        int totalPrice = 0;
        for(Pizza orderedPizza: pizzaOrderList){
            currentPizzaPrice = orderedPizza.pizzaPrice();
            totalPrice = totalPrice + currentPizzaPrice;
            toBePrinted = orderedPizza.toString() + pizzaPriceTag + currentPizzaPrice + "\n\n";
            orderListTextArea.appendText(toBePrinted);
        }
        totalPriceField.setText(String.valueOf(totalPrice));
    }
}
