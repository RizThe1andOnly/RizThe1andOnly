package Program4GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the main page where customer will create pizza order.
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class SelectionPageController implements Initializable {

    //required constants:
     //pizza types:
    private final String BUILDOWNPIZZA = "Build Your Own";
    private final String HAWAIIAN = "Hawaiian";
    private final String DELUXE = "Deluxe";
     //pizza sizes:
    private final String SMALL = "Small";
    private final String MEDIUM = "Medium";
    private final String LARGE = "Large";

    //pizza type and size related elements:
    @FXML
    private ComboBox<String> pizzaTypeBox;
    @FXML
    private ComboBox<String> pizzaSizeBox;

    /**
     * Sets initial values for elements in the gui when the gui starts.
     * @param location url of relative path resources
     * @param resource resources used
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public void initialize(URL location, ResourceBundle resource){
        //set pizza type combobox
        ObservableList<String> pizzaTypes = FXCollections.observableArrayList(BUILDOWNPIZZA,HAWAIIAN,DELUXE);
        pizzaTypeBox.setItems(pizzaTypes);

        //set pizza size combobox
        ObservableList<String> pizzaSizes = FXCollections.observableArrayList(SMALL,MEDIUM,LARGE);
        pizzaSizeBox.setItems(pizzaSizes);


        //set defaults
        setDefaultVals();
    }


    /**
     * Sets default values for various elements in the gui after certain commands/actions or when the gui first starts.
     */
    private void setDefaultVals(){
        pizzaTypeBox.setValue(BUILDOWNPIZZA);
        pizzaSizeBox.setValue(MEDIUM);
    }

}
