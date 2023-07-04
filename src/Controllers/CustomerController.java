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
 * Controller class for the Customer.fmxl form.
 * Implements Initializable
 * @author xavierloeraflores
 */
public class CustomerController implements Initializable{


    @FXML
    private Label labelId;
    @FXML
    private Label labelName;
    @FXML
    private Label labelAddress;
    @FXML
    private Label labelPostalCode;
    @FXML
    private Label labelPhone;
    @FXML
    private Label labelCountry;
    @FXML
    private Label labelDivision;
    @FXML
    private Label labelUserId;
    @FXML
    private Label labelError;





    @FXML 
    private TextField fieldName;
    @FXML 
    private TextField fieldAddress;
    @FXML 
    private TextField fieldPostalCode;
    @FXML 
    private TextField fieldPhone;

    @FXML
    private Button buttonSave;
    @FXML 
    private Button buttonCancel;


    @FXML 
    private ComboBox comboCountry;
    @FXML 
    private ComboBox comboDivision;

    private String language;






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
     * Handles the canceling functionality when a user presses the cancel button.
     * It will return the user the Main screen if the user confirms cancellation
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    @FXML
    private void handleCancel(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initModality(Modality.NONE);
        alert.setTitle("Cancel Appointment Confirmation");
        alert.setHeaderText("Confirm Cancellation");
        alert.setContentText("Are you sure you want to cancel this appointment?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            //Send to main screen
            //mainScreen(actionEvent);
        }
    }


    /**
     * 
     */
    public Boolean validate(){
        return true;
    }

    /**
     * 
     */
    public void handleSave(){

    }


    /**
     * 
     */
    public void mapLabels(){

    }



    /**
     * Initializes the FXML Screen 
     * @param url parameter for the FXML Screen
     * @param resourceBundle parameter for the FXML Screen
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        language = null;
        mapLabels();

    }
}