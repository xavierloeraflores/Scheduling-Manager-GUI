package Controllers;

import Database.ContactDataAccessObject;
import Models.Appointment;
import Models.Contact;
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
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @FXML
    private Button buttonSave;
    @FXML 
    private Button buttonCancel;

    private String language;
    private ResourceBundle rb;
    private boolean adding = true;
    private Appointment appointment;







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
     * Maps the textFields with data
     */
    public void mapUpdating() {
        try{
            appointment = MainController.getAppointment();
            int _userId = appointment.getUserId();
            int _customerId = appointment.getCustomerId();
            int _contactId = appointment.getContactId();
            String _title = appointment.getTitle();
            String _desc = appointment.getDescription();
            String _location = appointment.getLocation();
            LocalDateTime _start = appointment.getStart();
            LocalDateTime _end = appointment.getEnd();


            Contact _contact = ContactDataAccessObject.getContactByContactID(_contactId);
            Instant _startInstant = _start.atZone(LoginController.getTimezone().toZoneId()).toInstant();
            Instant _endInstant = _end.atZone(LoginController.getTimezone().toZoneId()).toInstant();

            LocalDate _dateStart = LocalDate.of(_start.getYear(),_start.getMonth(), _start.getDayOfMonth());
            LocalDate _dateEnd = LocalDate.of(_end.getYear(),_end.getMonth(), _end.getDayOfMonth());

            fieldTitle.setText(_title);
            fieldCustomerId.setText(""+_customerId);
            fieldUserId.setText(""+_userId);
            fieldDescription.setText(_desc);
            fieldLocation.setText(_location);

            fieldStartHour.setText(""+_start.getHour());
            fieldStartMin.setText(""+ _start.getMinute());
            fieldEndHour.setText(""+_end.getHour());
            fieldEndMin.setText(""+_end.getMinute());


            dateStart.setValue(_dateStart);
            dateEnd.setValue(_dateEnd);




            comboContact.setValue(_contact);





        }catch(Exception err){
            System.out.println(err);
        }
    }
    /**
     * Maps the labels to the correct language
     */
    public void mapLabels(){
        ResourceBundle _rb = LoginController.getRb();
        rb= _rb;

        String _save  = rb.getString("SAVE");
        String _cancel  = rb.getString("CANCEL");
        String _id = rb.getString("ID");
        String _contact  = rb.getString("APPOINTMENTCONTACT");
        String _title  = rb.getString("APPOINTMENTTITLE");
        String _description  = rb.getString("APPOINTMENTDESCRIPTION");
        String _location  = rb.getString("APPOINTMENTLOCATION");
        String _startDate  = rb.getString("APPOINTMENTSTARTDATE");
        String _startTime  = rb.getString("APPOINTMENTSTARTTIME");
        String _endDate  = rb.getString("APPOINTMENTENDDATE");
        String _endTime  = rb.getString("APPOINTMENTENDTIME");
        String _customerId  = rb.getString("APPOINTMENTCUSTOMERID");
        String _userId  = rb.getString("APPOINTMENTUSERID");
        String _selContact = rb.getString("APPOINTMENTSELCONTACT");
        String _autogen = rb.getString("AUTOGEN");

        if(adding){
            _autogen = _autogen + MainController.getAllAppointments().size();
        }else{
            _autogen = _autogen + MainController.getAppointment().getAppointmentId();
        }

        buttonCancel.setText(_cancel);
        buttonSave.setText(_save);
        labelId.setText(_id);
        labelAutoGenId.setText(_autogen);
        labelContact.setText(_contact);
        labelTitle.setText(_title);
        labelDescription.setText(_description);
        labelLocation.setText(_location);
        labelStartDate.setText(_startDate);
        labelStartTime.setText(_startTime);
        labelEndDate.setText(_endDate);
        labelEndTime.setText(_endTime);
        labelCustomerId.setText(_customerId);
        labelUserId.setText(_userId);
        comboContact.setPromptText(_selContact);
    }



    /**
     * Initializes the FXML Screen 
     * @param url parameter for the FXML Screen
     * @param resourceBundle parameter for the FXML Screen
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try{
            language = null;
            adding = MainController.getAdding();
            mapLabels();
            comboContact.setItems(ContactDataAccessObject.getAllContacts());
            if (!adding){
                mapUpdating();
            }
        }catch(Exception err){
            System.out.println(err);
        }




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
        alert.setTitle(rb.getString("CANCELTITLE"));
        alert.setHeaderText(rb.getString("CANCELHEADER"));
        alert.setContentText(rb.getString("CANCELCONFIRM"));
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            openPage(actionEvent,"/Views/Main.fxml");
        }
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


}