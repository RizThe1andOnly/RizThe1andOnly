package Program4GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is run at the start of the program and is responsible for starting the SelectionPage gui (the main gui).
 *
 * Skeleton provided by javafx framework and edited by following:
 * @author Rizwan Chowhdury
 * @author Tin Fung
 */
public class Main extends Application {

    /**
     * Starts the main gui
     * @param primaryStage stage for main gui passed by framework
     * @throws Exception general execption for anything that could go wrong
     *
     * Initially provided by framework and edited by :
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SelectionPage.fxml"));
        primaryStage.setTitle("Order Pizza");
        primaryStage.setScene(new Scene(root, 610, 400));
        primaryStage.show();
    }


    /**
     * The main function run when program is to begin, will start the whole gui process through launch call
     * @param args arguments passed through program command
     * Provided by framework and edited by:
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public static void main(String[] args) {
        launch(args);
    }
}
