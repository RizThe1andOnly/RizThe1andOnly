package Program4GUI;

import PizzaPackage.Pizza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Controller class used for controlling the order view stage.
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class OrderPageController {

    //reference to current orders for this class to use
    private ArrayList<Pizza> currentPizzaOrders;

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
        currentPizzaOrders = pizzaOrderList;
        int initialCaretPost = orderListTextArea.getCaretPosition();
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
        totalPriceField.setText("$ " + totalPrice);
        orderListTextArea.positionCaret(initialCaretPost);
    }


    /**
     * When the back button is pressed, the order view stage will close.
     * @param e back button being pressed, will also contain the source which is the back button itself and its info
     * @author Rizwan Chowdhury
     */
    @FXML
    public void closeViewOrderPage(ActionEvent e){
        Stage currentStage = (Stage)((Button)e.getSource()).getScene().getWindow();
        currentStage.close();
    }


    /**
     * Clears all of the orders in the current orders list, which this class will have obtained from the calling class
     * @author Rizwan Chowdhury
     */
    @FXML
    public void clearCurrentOrdersList(){
        currentPizzaOrders.clear();
        orderListTextArea.clear();
        totalPriceField.clear();
    }
}
