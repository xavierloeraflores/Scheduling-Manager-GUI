package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;

import javafx.event.ActionEvent;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Modality;

import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.Optional;



/**
 * Controller class for the Login.fmxl form.
 * Implements Initializable
 * @author xavierloeraflores
 */
public class LoginController implements Initializable{


    @FXML
    private Label labelUsername;
    @FXML
    private Label labelPassword;
    @FXML 
    private Label labelTimezone;
    @FXML 
    private Label labelLanguage;
    @FXML 
    private Label labelUserTimezone;
    @FXML
    private Lavel labelUserLanguage;
    @FXML 
    private Label labelError;


    @FXML 
    private TextField fieldUsername;
    @FXML 
    private PasswordField fieldPassword;
    @FXML
    private Button buttonLogin;


    static private String language;
    static private User user; 



    /**
     * @return 
     */
    public static String getLanguage() {
        return language;
    }

    /**
     * @return 
     */
    public static User getUser() {
        return user;
    }




    /**
     * Utility function that is used to switch between pages
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    public void openPage(ActionEvent actionEvent, String form) throws  IOException {
        Parent addPartFXML = FXMLLoader.load(getClass().getResource(form));
        Scene addPartScene = new Scene(addPartFXML);
        Stage addPartStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        addPartStage.setScene(addPartScene);
        addPartStage.show();
    }


    /**
     * 
     */
    public void handleLogin(){

    }


    /**
     * 
     */
    public void mapLabels(){

    }
    /**
     * 
     */
    public void mapLanguage(){
        
    }


    /**
     * Initializes the FXML Screen and sets the selectedPart and selectedProduct to null.
     * @param url parameter for the FXML Screen
     * @param resourceBundle parameter for the FXML Screen
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        language = null;
        user = null;
        mapLanguage();
        mapLabels();

    }
}