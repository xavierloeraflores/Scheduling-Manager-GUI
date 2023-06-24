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
 * Controller class for the Appoinment.fmxl form.
 * Implements Initializable
 * @author xavierloeraflores
 */
public class AppointmentController implements Initializable{


    @FXML
    private Label labelId;
    @FXML
    private Label labelTitle;
    @FXML
    private Label labelStartDate;
    @FXML
    private Label labelEndDate;
    @FXML
    private Label labelStartTime;
    @FXML
    private Label labelLocation;
    @FXML
    private Label labelDescription;
    @FXML
    private Label labelEndTime;
    @FXML
    private Label labelAutoGenId;
    @FXML
    private Label labelContact;
    @FXML
    private Label labelError;
    @FXML
    private Label labelCustomerId;
    @FXML
    private Label labelUserId;



    @FXML 
    private TextField fieldTitle;
    @FXML 
    private TextField fieldDescription;
    @FXML 
    private TextField fieldLocation;
    @FXML 
    private TextField fieldStartHour;
    @FXML 
    private TextField fieldStartMin;
    @FXML
    private TextField fieldEndHour;
    @FXML
    private TextField fieldEndMin;
    @FXML
    private TextField fieldCustomerId;
    @FXML
    private TextField fieldUserId;
    @FXML
    private DatePicker dateStart;
    @FXML
    private DatePicker dateEnd;
    @FXML 
    private ComboBox comboContact;






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