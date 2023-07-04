package Controllers;

import Models.User;
import Database.UserDataAccessObject;
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

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
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
    private Label labelUserLanguage;
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
     * Utility function that is used to display errors
     * @param title String value text of the title
     * @param header String value text of the header
     * @param text String value text of the main text
     */
    public void displayError(String title, String header, String text)  {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }


    public void logAuthentication(Boolean valid, String username){

    }


    /**
     * 
     */
    public void handleLogin(ActionEvent actionEvent) throws IOException,SQLException, Exception {
        try{
            user = null;
            Boolean validLogin = true;
            String errorMessage = "";
            String username = fieldUsername.getText();
            String password = fieldPassword.getText();
            validLogin = !(Objects.equals(username, "") || Objects.equals(password, ""));
            if (!validLogin){errorMessage = "The username and password fields can not be empty";}
            else{
                User userLogin = UserDataAccessObject.getUserByUsername(username);
                validLogin = !(userLogin == null);
                if(!validLogin){errorMessage = "Could not find a user with the provided username";}
                else{
                    validLogin = (Objects.equals(userLogin.getPassword(), password));
                    if(!validLogin){errorMessage = "Passwords do not match";}
                    else{
                        user = userLogin;
                        logAuthentication(true, username);
                        //openPage(actionEvent, "Main.fxml");
                    }

                }
            }

            labelError.setText(errorMessage);
            if(!validLogin){logAuthentication(true, username);displayError("Error", "Log in Error",errorMessage );}
        }catch(Exception error){
            displayError("Login Error", "Error Logging In","An error has occurred" );
        }

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
     * Initializes the FXML Screen 
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