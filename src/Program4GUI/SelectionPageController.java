package Program4GUI;

import PizzaPackage.BuildYourOwn;
import PizzaPackage.Deluxe;
import PizzaPackage.Hawaiian;
import PizzaPackage.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller class for the main page where customer will create pizza order.
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class SelectionPageController implements Initializable {

    //pizza type and size related elements:
    @FXML
    private ComboBox<String> pizzaTypeBox;
    @FXML
    private ComboBox<String> pizzaSizeBox;

    //toppings related listboxes & commands:
    @FXML
    private ListView<String> toppingOptionsListBox;
    @FXML
    private ListView<String> toppingSelectedListBox;
    @FXML
    private VBox toppingVBoxMain;

    //text area for messages
    @FXML
    private TextArea messageArea;

    //image related constants and items
    @FXML
    private ImageView pizzaView;
    private final Image DELUXE_PIZZA_IMAGE = new Image("file:src/Images/DeluxePizza.jpg");
    private final Image HAWAIIAN_PIZZA_IMAGE = new Image("file:src/Images/HawaiianPizza.jpg");
    private final Image BUILD_YOUR_OWN_IMAGE = new Image("file:src/Images/BuildYourOwnPizza.jpg");


    //datamembers to keep track of and ctrl different components:
    private ObservableList<String> pizzaTypes; //list to hold types of pizzas
    private ObservableList<String> pizzaSizes; //list to hold sizes of pizzas
    private ObservableList<String> availableToppings; // list that holds the toppings customers can choose from
    private ObservableList<String> selectedToppings; // list to hold toppings that have been selected by customers
    private ArrayList<Pizza> currentOrders; // holds the pizza's currently ordered by customer

    //required constants:
    //pizza types:
    private final String BUILDOWNPIZZA = "Build Your Own";
    private final String HAWAIIAN = "Hawaiian";
    private final String DELUXE = "Deluxe";
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
    private final String PINEAPPLE = "Pineapple";
    private final String JALAPENO = "Jalapeno";
    private final String CHICKEN = "Chicken";
    private final String BACON = "Bacon";
    //limits for number of toppings:
    private final int MAX_TOPPINGS = 6;
    private final int MIN_TOPPINGS = 1;


    /**
     * Sets initial values for elements in the gui when the gui starts.
     * @param location url of relative path resources
     * @param resource resources used
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public void initialize(URL location, ResourceBundle resource){

        //initialize list of current orders:
        currentOrders = new ArrayList<>();
        setUpComboBoxes();
        setUpToppingOptionLists();
        setUpToppingSelectedLists();
        //set defaults
        setDefaultVals();
    }


    /**
     * Helper method to set up combobox elements for pizza style and size. Will be
     * called by initialize.
     *
     * @author Rizwan Chowdhury
     */
    private void setUpComboBoxes(){
        //set pizza type combobox
        pizzaTypes = FXCollections.observableArrayList(BUILDOWNPIZZA,HAWAIIAN,DELUXE);
        pizzaTypeBox.setItems(pizzaTypes);

        //set pizza size combobox
        pizzaSizes = FXCollections.observableArrayList(SMALL,MEDIUM,LARGE);
        pizzaSizeBox.setItems(pizzaSizes);
    }


    /**
     * Sets default values for various elements in the gui after certain commands/actions or when the gui first starts.
     * @author Rizwan Chowdhury
     */
    private void setDefaultVals(){
        pizzaTypeBox.setValue(BUILDOWNPIZZA);
        pizzaSizeBox.setValue(MEDIUM);
        pizzaView.setImage(BUILD_YOUR_OWN_IMAGE);
    }

    /**
     * Helper method to set up the initial state and functionalities of the toppingOptionsListBox
     * and availableToppings list. Will be called by initialize.
     *
     * @author Rizwan Chowdhury
     */
    private void setUpToppingOptionLists(){
        //set available toppings
        toppingOptionsListBox.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        availableToppings = FXCollections.observableArrayList(SAUSAGE,PEPPERONI,GREEN_PEPPER,ONION,MUSHROOM,
                HAM,PINEAPPLE,JALAPENO,CHICKEN,BACON);
        toppingOptionsListBox.setItems(availableToppings);
    }


    /**
     * Helper method to set up the initial state and functionalities of the toppingSelectedListBox
     * and selectedToppings list. Will be called by initialize.
     *
     * @author Rizwan Chowdhury
     */
    private void setUpToppingSelectedLists(){
        //set selected toppings list to the listview
        selectedToppings = FXCollections.observableArrayList();
        toppingSelectedListBox.setItems(selectedToppings);
    }





    //TOPPINGS SECTION:

    /**
     * When called will remove all items from the selected toppings list.
     *
     * @author Rizwan Chowhdury
     * @author Tin Fung
     */
    private void clearSelectedToppings(){
        // base case/ just in case
        if( (selectedToppings.size() == 0) || (selectedToppings==null) ){
            return;
        }

        selectedToppings.clear();
    }


    /**
     * Will be called when Add Toppings>> button is pressed. Will take the slected items in the
     * available toppings listview and add them to the selected toppings list. Since two of the
     * same topping not allowed checks will be made to make sure this does not happen.
     * @param e The Add Toppings>> being pressed.
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @FXML
    public void addSelectedToppings(ActionEvent e){

        // check if customer has exceed 6 toppings and if yest do not allow any more additions:
        if(atMaxLimitTopping()){
            messageArea.appendText("Cannot add any more toppings, at limit of 6.\n");
            return;
        }

        ObservableList<String> toppingsBuffer = toppingOptionsListBox.getSelectionModel().getSelectedItems();
        if(!alreadyContainsTopping(toppingsBuffer)){// false is returned when no duplicates

            //check if number of toppings will go over limit after adding
            if(toppingsBuffer.size()+selectedToppings.size() > MAX_TOPPINGS){
                messageArea.appendText("Toppings will exceed max limit of 6.\nPlease select less toppings.\n");
                return;
            }

            for(String x:toppingsBuffer){
                selectedToppings.add(x); //adds newly selected items to observable list
            }
        }
        else{
            messageArea.appendText("Only 1 of each topping allowed.\n");
        }

        resetToppingSelection();
    }


    /**
     * Checks to see if the maximum number of toppings is exceeded or not in the selected toppings list
     * @return true if max number exceeded, false otherwise
     */
    private boolean atMaxLimitTopping(){
        if(selectedToppings.size() == 6){
            return true;
        }
        return false;
    }


    /**
     * Helper method to check if element being added already exists in selected Topping list.
     * @param toppingsBuffer list of toppings that are to be added to the selected list
     * @return true if there is an element that exists in both lists, false otherwise
     * @author Rizwan Chowdhury
     */
    private boolean alreadyContainsTopping(ObservableList<String> toppingsBuffer){
        //base case: when selected toppings is empty
        if(selectedToppings.size() == 0){
            return false;
        }

        for(String x : toppingsBuffer){
            if(selectedToppings.contains(x)){ // is x (an element of buffer) in selected
                return true;
            }
        }

        return false;
    }


    /**
     * Activated when user presses the Remove Toppings button. It removes selected toppings
     * from the selectedToppings list.
     * @param e pressing of the Remove Toppings button
     * @author Rizwan Chowdhury
     */
    @FXML
    public void removeSelectedToppings(ActionEvent e){
        ObservableList<String> toBeRemovedBuffer = toppingSelectedListBox.getSelectionModel().getSelectedItems();
        for(String toBeRemoved : toBeRemovedBuffer){
            selectedToppings.remove(toBeRemoved);
            if(selectedToppings.size() == 0){
                break;
            }
        }
        resetToppingSelection();
    }


    /**
     * When Hawaiian or Deluxe is selected as pizza style the toppings section will be locked, since
     * for Hawaiian and Deluxe customers cannot choose their own toppings. Will also clear the selected toppings
     * list when switching to Hawaiian or Deluxe.
     * @param e Selection of a style in the Pizza Style combo box.
     *
     * @author Rizwan Chowdhury
     */
    @FXML
    public void readjustToppings(ActionEvent e){
        String pizzastyle = pizzaTypeBox.getSelectionModel().getSelectedItem();
        clearSelectedToppings();
        if( (pizzastyle.equals(HAWAIIAN)) || (pizzastyle.equals(DELUXE)) ){
            toppingVBoxMain.setDisable(true);
            setPresetToppings(pizzastyle);
            if(pizzastyle.equals(HAWAIIAN)){
                pizzaView.setImage(HAWAIIAN_PIZZA_IMAGE);
            }
            if(pizzastyle.equals(DELUXE)){
                pizzaView.setImage(DELUXE_PIZZA_IMAGE);
            }
        }
        else{
            toppingVBoxMain.setDisable(false);
            pizzaView.setImage(BUILD_YOUR_OWN_IMAGE);
        }
    }


    /**
     * Helper method to set preset toppings to selected toppings list for Hawaiian and Deluxe pizza
     * @param style Hawaiian or Deluxe, the style for which preset toppings are to be set
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void setPresetToppings(String style){
        if(style.equals(HAWAIIAN)){
            selectedToppings.add(HAM);
            selectedToppings.add(PINEAPPLE);
        }
        else{
            selectedToppings.add(SAUSAGE);
            selectedToppings.add(PEPPERONI);
            selectedToppings.add(GREEN_PEPPER);
            selectedToppings.add(ONION);
            selectedToppings.add(MUSHROOM);
        }
    }


    /**
     * Resets the selected topping selection and available toppings selection after each time a toppings command is pressed
     * or after selection cleared or something.
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void resetToppingSelection(){
        toppingOptionsListBox.getSelectionModel().clearSelection();
        toppingSelectedListBox.getSelectionModel().clearSelection();
    }


    //ADD ORDER SECTION:

    /**
     * Once the Add Order button is pressed the current order, as it is (barring errors in order), will be added to
     * current list of orders for customers.
     *
     * @param e Pressing of Add Order button
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @FXML
    public void addOrder(ActionEvent e){
        String style = pizzaTypeBox.getSelectionModel().getSelectedItem();
        String size  = pizzaSizeBox.getSelectionModel().getSelectedItem();

        if(style.equals("Build Your Own")){
            addBuildYourOwn(style,size);
        }
        else if(style.equals("Hawaiian")){
            addHawaiian(style,size);
        }
        else{
            addDeluxe(style,size);
        }
    }


    /**
     * Helper method to create and add a Build Your Own pizza to the current orders.
     * @param style Build Your Own; used for object creation purposes
     * @param size how big the pie is: small, medium, large
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void addBuildYourOwn(String style, String size){
        //check if minimum number of toppings added:
        if(selectedToppings.size() < MIN_TOPPINGS){
            messageArea.appendText("Please add at least 1 topping.\n\n");
            return;
        }

        //create and add to arraylist toppings which will be passed to Pizza constructors
        ArrayList<String> toppings = new ArrayList<>();
        for(String topping:selectedToppings){
            toppings.add(topping);
        }

        Pizza newBYOPizza = new BuildYourOwn(style,size,toppings);
        currentOrders.add(newBYOPizza);
        messageArea.appendText("Build Your Own order added!\n\n");
        clearSelectedToppings();
        setDefaultVals();
    }


    /**
     * Helper method to create and add a Deluxe pizza object to the current orders
     * @param style Deluxe, here for object creation purposes
     * @param size how big the pie is: small, medium, large
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void addDeluxe(String style, String size){
        Pizza newDeluxePizza = new Deluxe(style,size);
        currentOrders.add(newDeluxePizza);
        messageArea.appendText("Deluxe order added!\n\n");
        setDefaultVals();
    }


    /**
     * Helper method to create and add a Hawaiian pizza object to the current orders
     * @param style Hawaiian, here for object creation purposes
     * @param size how big the pie is: small, medium, large
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void addHawaiian(String style, String size){
        Pizza newHawaiianPizza = new Hawaiian(style,size);
        currentOrders.add(newHawaiianPizza);
        messageArea.appendText("Hawaiian order added!\n\n");
        setDefaultVals();
    }


    //CLEAR SELECTION SECTION:

    /**
     * When clear selection button is pressed the current selection will be cleared and re-set to defaults
     * @param e Clear Selection button being pressed
     * @author Rizwan Chowdhury
     */
    @FXML
    public void clearSelection(ActionEvent e){
        selectedToppings.clear();
        setDefaultVals();
        messageArea.appendText("Current Selection Cleared.\n\n");
    }


    //VIEW ORDER SECTION:

    /**
     * Triggered with the press of hte View Orders button, will open the Orders screen and pass list of current orders to the
     * new window.
     * @param e Pressing of the View Order button
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @FXML
    public void viewOrders(ActionEvent e){
        try{
            //obtain parts of order view
            FXMLLoader viewOrderLoader = new FXMLLoader(getClass().getResource("OrderPage.fxml"));
            Parent orderViewRoot = viewOrderLoader.load();
            OrderPageController orderViewController = viewOrderLoader.getController();

            //set up stage basics
            Stage orderStage = new Stage();
            orderStage.setTitle("Order View");
            orderStage.setScene(new Scene(orderViewRoot,400,400));

            //have view order print orders and total price
            if(orderViewController == null) {messageArea.appendText("NUll bro"); return;}
            orderViewController.printOrders(currentOrders);

            orderStage.show();
        }catch (IOException exception){
            messageArea.appendText("Error in loading view screen, sorry.\n\n");
        }
    }


    //DONE BUTTON Programming

    /**
     * Pressing of the Done button will close the entire program
     * @param e Pressing of the done button, will also contain info on the done button
     */
    @FXML
    public void doneAction(ActionEvent e){
        Stage thisStage = (Stage)((Button)e.getSource()).getScene().getWindow();
        thisStage.close();
    }
}
