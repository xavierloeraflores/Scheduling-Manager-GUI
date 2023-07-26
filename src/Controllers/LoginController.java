package Controllers;

import main.Logger;
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

//import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.io.IOException;
import java.util.Optional;
import java.util.TimeZone;



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
    static ResourceBundle rb;
    static private TimeZone timeZone = TimeZone.getDefault();


    /**
     * @return [TimeZone] timezone of the system
     */
    public static TimeZone getTimezone() {
        return timeZone;
    }

    /**
     * @return [String] language of the system
     */
    public static String getLanguage() {
        return language;
    }

    /**
     * @return [User] user that has loggged in
     */
    public static User getUser() {
        return user;
    }

    /**
     * @return [ResourceBundle] rb for the labels
     */
    public static ResourceBundle getRb(){return rb;}






    /**
     * Utility function that is used to log any sign in attempts
     * @param valid Boolean value representing a successful log in
     * @param username String value representing the username being attempted
     */
    public void logAuthentication(Boolean valid, String username){
        try{
            Logger.log(valid, username);
        }catch(Exception error){
            System.out.println("Error:"+ error);
        }
    }

    /**
     * Function that handles authentication
     * @param actionEvent ActionEvent object that triggered this function
     */
    public void handleLogin(ActionEvent actionEvent) throws IOException {
        try{
            user = null;
            Boolean validLogin = true;
            String errorMessage = "";
            String username = fieldUsername.getText();
            String password = fieldPassword.getText();
            validLogin = !(Objects.equals(username, "") || Objects.equals(password, ""));
            if (!validLogin){errorMessage = rb.getString("ERROREMPTY");}
            else{
                User userLogin = UserDataAccessObject.getUserByUsername(username);
                validLogin = !(userLogin == null);
                if(!validLogin){ errorMessage = rb.getString("LOGINERRORUSERNAME"); }
                else{
                    validLogin = (Objects.equals(userLogin.getPassword(), password));
                    if(!validLogin){ errorMessage = rb.getString("LOGINERRORPASSWORD"); }
                    else{
                        user = userLogin;
                        logAuthentication(true, username);
                        openPage(actionEvent, "/Views/Main.fxml");
                    }

                }
            }

            labelError.setText(errorMessage);
            if(!validLogin){logAuthentication(false, username);displayError(errorMessage );}
        }catch(Exception error){
            displayError(rb.getString("ERRORGENERIC") );
        }
    }


    /**
     * Function that correctly maps all the labels to the correct language
     */
    public void mapLabels(){
        String _username = rb.getString("LOGINUSERNAME");
        String _password = rb.getString("LOGINPASSWORD");
        String _timezone = rb.getString("LOGINTIMEZONE");
        String _language = rb.getString("LOGINLANGUAGE");
        String _login = rb.getString("LOGINLOGIN");
        String _userTimezone = timeZone.getID()+ " - " +timeZone.getDisplayName();



        labelUserLanguage.setText("en - English");
        if(getLanguage() == "fr"){labelUserLanguage.setText("fr - Français");}

        labelUsername.setText(_username);
        labelPassword.setText(_password);
        labelTimezone.setText(_timezone);
        labelLanguage.setText(_language);
        buttonLogin.setText(_login);
        labelUserTimezone.setText(_userTimezone);

    }
    /**
     * Maps the language from the system
     */
    public void mapLanguage(){

        language = "en";
        String userLang = System.getProperty("user.language");
        if(userLang.contains("fr" )){
            language = "fr";
        }
        ResourceBundle _rb = ResourceBundle.getBundle("bundle/resource");
        System.out.println("Lang = "+ language + "----" + userLang);
        rb = _rb;

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
        rb = null;
        mapLanguage();
        mapLabels();

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
     * @param text String value text of the main text
     */
    public void displayError( String text)  {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(rb.getString("ERROR"));
        alert.setHeaderText(rb.getString("ERRORHEADER"));
        alert.setContentText(text);
        alert.showAndWait();
    }
}