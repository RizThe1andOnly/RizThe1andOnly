package Program4GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.net.URL;
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


    //datamembers to keep track of and ctrl different components:
    ObservableList<String> pizzaTypes; //list to hold types of pizzas
    ObservableList<String> pizzaSizes; //list to hold sizes of pizzas
    ObservableList<String> availableToppings; // list that holds the toppings customers can choose from
    ObservableList<String> selectedToppings; // list to hold toppings that have been selected by customers

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


    /**
     * Sets initial values for elements in the gui when the gui starts.
     * @param location url of relative path resources
     * @param resource resources used
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public void initialize(URL location, ResourceBundle resource){

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


    /**
     * Sets default values for various elements in the gui after certain commands/actions or when the gui first starts.
     * @author Rizwan Chowdhury
     */
    private void setDefaultVals(){
        pizzaTypeBox.setValue(BUILDOWNPIZZA);
        pizzaSizeBox.setValue(MEDIUM);
    }


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
     */
    @FXML
    public void addSelectedToppings(ActionEvent e){
        ObservableList<String> toppingsBuffer = toppingOptionsListBox.getSelectionModel().getSelectedItems();
        if(!alreadyContainsTopping(toppingsBuffer)){// false is returned when no duplicates
            for(String x:toppingsBuffer){
                selectedToppings.add(x); //adds newly selected items to observable list
                //may need to manually add to the listview as well, will see !!!
            }
        }
        else{
            messageArea.appendText("One or more of the toppings you have selected are already\n " +
                                      "selected, duplicates are not allowed, please select again\n toppings" +
                                      " that you have not selected yet.\n");
        }
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
    public void lockToppings(ActionEvent e){
        String pizzastyle = pizzaTypeBox.getSelectionModel().getSelectedItem();
        clearSelectedToppings();
        if( (pizzastyle.equals(HAWAIIAN)) || (pizzastyle.equals(DELUXE)) ){
            toppingVBoxMain.setDisable(true);
        }
        else{
            toppingVBoxMain.setDisable(false);
        }
    }

}
