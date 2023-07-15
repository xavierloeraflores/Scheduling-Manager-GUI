package Controllers;

import Database.UserDataAccessObject;
import Models.Appointment;
import Models.Customer;
import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


/**
 * Controller class for the Main.fmxl form.
 * Implements Initializable
 * @author xavierloeraflores
 */
public class MainController implements Initializable{
    @FXML
    private Label labelAppointments;
    @FXML
    private Label labelCustomers;
    @FXML
    private Label labelError;

    @FXML
    private Button buttonAddA;
    @FXML
    private Button buttonUpdateA;
    @FXML
    private Button buttonDeleteA;
    @FXML
    private Button buttonAddC;
    @FXML
    private Button buttonUpdateC;
    @FXML
    private Button buttonDeleteC;
    @FXML
    private Button buttonReports;

    @FXML
    private RadioButton radioMonthly;
    @FXML
    private RadioButton radioWeekly;

    @FXML
    private TableView tableA;
    @FXML
    private TableColumn aColumnID;
    @FXML
    private TableColumn aColumnTitle;
    @FXML
    private TableColumn aColumnDescription;
    @FXML
    private TableColumn aColumnLocation;
    @FXML
    private TableColumn aColumnType;
    @FXML
    private TableColumn aColumnStart;
    @FXML
    private TableColumn aColumnEnd;
    @FXML
    private TableColumn aColumnCustomer;
    @FXML
    private TableColumn aColumnUser;
    @FXML
    private TableColumn aColumnContact;

    @FXML
    private TableView tableC;
    @FXML
    private TableColumn cColumnID;
    @FXML
    private TableColumn cColumnName;
    @FXML
    private TableColumn cColumnAddress;
    @FXML
    private TableColumn cColumnPostalCode;
    @FXML
    private TableColumn cColumnPhone;
    @FXML
    private TableColumn cColumnDivision;

    static private Appointment appointment;
    static private Customer customer;


    /**
     * @return [Customer] object that was selected from the table
     */
    public static Customer getCustomer(){return customer;}

    /**
     * @return [Appointment] object that was selected from the table
     */
    public static Appointment getAppointment(){return appointment;}





    /**
     * Function that checks and alerts the user if they are within 15 minutes of an appointment
     */
    public void appointmentAlert(){
        User user = LoginController.getUser();
    }



    /**
     * Function that correctly maps all the labels to the correct language
     */
    public void mapLabels(){
        ResourceBundle rb =  LoginController.getRb();
        //String _username = rb.getString("LOGINUSERNAME");
        //labelUsername.setText(_username);

    }

    /**
     * Initializes the FXML Screen 
     * @param url parameter for the FXML Screen
     * @param resourceBundle parameter for the FXML Screen
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        customer = null;
        appointment = null;
        appointmentAlert();
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
        ResourceBundle rb =  LoginController.getRb();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(rb.getString("ERROR"));
        alert.setHeaderText(rb.getString("ERRORHEADER"));
        alert.setContentText(text);
        alert.showAndWait();
    }
}