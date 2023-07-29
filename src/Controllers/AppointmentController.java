package Controllers;

import Database.AppointmentDataAccessObject;
import Database.ContactDataAccessObject;
import Database.CustomerDataAccessObject;
import Database.UserDataAccessObject;
import Models.*;
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

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.*;
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
    private Label labelType;



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
    private TextField fieldType;

    
    @FXML
    private DatePicker dateStart;
    @FXML
    private DatePicker dateEnd;
    @FXML 
    private ComboBox<Contact> comboContact;
    @FXML
    private ComboBox<Customer> comboCustomer;
    @FXML
    private ComboBox<User> comboUser;

    @FXML
    private Button buttonSave;
    @FXML 
    private Button buttonCancel;

    private String language;
    private ResourceBundle rb;
    private boolean adding = true;
    private Appointment appointment;





    /**
     * Validates inputs for the Appointment
     */
    public Boolean validate(){
        String errorMessage = "";
        Boolean valid = true;

        //field.getText() == ""
        if (fieldTitle.getText() == ""){
            valid = false;
            errorMessage += rb.getString("ATITLE") + "\n";
        }
        if (fieldDescription.getText() == ""){
            valid = false;
            errorMessage += rb.getString("ADESC") + "\n";
        }
        if (fieldLocation.getText() == ""){
            valid = false;
            errorMessage += rb.getString("ALOCATION") + "\n";
        }
        if (fieldType.getText() == ""){
            valid = false;
            errorMessage += rb.getString("ATYPE") + "\n";
        }
        if (fieldStartHour.getText() == ""){
            valid = false;
            errorMessage += rb.getString("ASTARTHOUR") + "\n";
        }
        if (fieldStartMin.getText() == ""){
            valid = false;
            errorMessage += rb.getString("ASTARTMIN") + "\n";
        }
        if (fieldEndHour.getText() == ""){
            valid = false;
            errorMessage += rb.getString("AENDHOUR") + "\n";
        }
        if (fieldEndMin.getText() == ""){
            valid = false;
            errorMessage += rb.getString("AENDMIN") + "\n";
        }
        if (comboUser.getValue()==null){
            valid = false;
            errorMessage += rb.getString("ACOMBOUSER") + "\n";
        }
        if (comboCustomer.getValue()==null){
            valid = false;
            errorMessage += rb.getString("ACOMBOCUSTOMER") + "\n";
        }
        if (comboContact.getValue()==null){
            valid = false;
            errorMessage += rb.getString("ACOMBOCONTACT") + "\n";
        }
        if (dateStart.getValue()==null){
            valid = false;
            errorMessage += rb.getString("ADATESTART") + "\n";
        }
        if (dateEnd.getValue()==null){
            valid = false;
            errorMessage += rb.getString("ADATEEND") + "\n";
        }

        if(!valid){
            errorMessage += rb.getString("ERROREMPTY") + "\n";
        }

        //Checks for integers
        if (valid){
            if (!fieldStartHour.getText().matches("-?\\d+")){
                valid = false;
                errorMessage += rb.getString("ASTARTHOUR") + "\n";
            }
            if (!fieldStartMin.getText().matches("-?\\d+")){
                valid = false;
                errorMessage += rb.getString("ASTARTMIN") + "\n";
            }
            if (!fieldEndHour.getText().matches("-?\\d+")){
                valid = false;
                errorMessage += rb.getString("AENDHOUR") + "\n";
            }
            if (!fieldEndMin.getText().matches("-?\\d+")){
                valid = false;
                errorMessage += rb.getString("AENDMIN") + "\n";
            }
        }

        if (valid){
            String _startHourString = fieldStartHour.getText();
            String _startMinString = fieldStartMin.getText();
            String _endHourString = fieldEndHour.getText();
            String _endMinString = fieldEndMin.getText();

            int _startHour = Integer.parseInt(_startHourString);
            int _startMin = Integer.parseInt(_startMinString);
            int _endHour = Integer.parseInt(_endHourString);
            int _endMin = Integer.parseInt(_endMinString);
            if (_startHour<0 || _startHour>24){
                valid = false;
                errorMessage += rb.getString("ASTARTHOUR") + "\n";
            }
            if (_startMin<0 || _startMin>60){
                valid = false;
                errorMessage += rb.getString("ASTARTMIN") + "\n";
            }
            if (_endHour<0 || _endHour>24){
                valid = false;
                errorMessage += rb.getString("AENDHOUR") + "\n";
            }
            if (_endMin<0 || _endMin>60){
                valid = false;
                errorMessage += rb.getString("AENDMIN") + "\n";
            }
        }



        if (valid){
            LocalDate _startLocalDate = dateStart.getValue();
            LocalDate _endLocalDate = dateEnd.getValue();
            String _startHourString = fieldStartHour.getText();
            String _startMinString = fieldStartMin.getText();
            String _endHourString = fieldEndHour.getText();
            String _endMinString = fieldEndMin.getText();

            int _startHour = Integer.parseInt(_startHourString);
            int _startMin = Integer.parseInt(_startMinString);
            int _endHour = Integer.parseInt(_endHourString);
            int _endMin = Integer.parseInt(_endMinString);
            int _startYear=  _startLocalDate.getYear();
            int _startMonth = _startLocalDate.getMonthValue();
            int _startDay = _startLocalDate.getDayOfMonth();
            int _endYear = _endLocalDate.getYear();
            int _endMonth = _endLocalDate.getMonthValue();
            int _endDay = _endLocalDate.getDayOfMonth();

            LocalDateTime _start = LocalDateTime.of(_startYear, _startMonth, _startDay, _startHour, _startMin);
            LocalDateTime _end = LocalDateTime.of(_endYear, _endMonth, _endDay, _endHour, _endMin);

            if(_start.isAfter(_end)){
                errorMessage += rb.getString("ATIME") + "\n";
                valid = false;
            }
            String utcM = ""+ _startMonth;
            String utcD = "" + _startDay;
            if(_startMonth<10){ utcM = "0"+utcM;}
            if(_startDay<10){utcD = "0"+utcD;}
            ZoneId ET_zoneId =ZoneId.of("America/New_York");
            ZonedDateTime zoneBStart = ZonedDateTime.of(_startYear, _startMonth, _startDay, 8, 0,0,0,ET_zoneId );
            ZonedDateTime zonedBEnd= ZonedDateTime.of(dateEnd.getValue().atTime(22, 0),ET_zoneId).withHour(22);
            ZonedDateTime zoneStart = ZonedDateTime.of(_start, LoginController.getTimezone().toZoneId());
            ZonedDateTime zoneEnd = ZonedDateTime.of(_end, LoginController.getTimezone().toZoneId());



            if(zoneStart.isBefore(zoneBStart) || zoneStart.isAfter(zonedBEnd)){
                errorMessage += rb.getString("ABUSINESSHOURS") + "1\n";
                valid = false;
            }
            if( zoneEnd.isBefore(zoneBStart) || zoneEnd.isAfter(zonedBEnd)){
                errorMessage += rb.getString("ABUSINESSHOURS") + "2\n";
                valid = false;
            }

            try {
                Customer _customer = comboCustomer.getValue();
                int _customerId = _customer.getCustomerId();
                ObservableList<Appointment> _appointments = AppointmentDataAccessObject.getAppointmentByCustomerID(_customerId);

                for(int i = 0; i< _appointments.size(); i++){
                    Appointment _cur = _appointments.get(i);
                    LocalDateTime _curStart = _cur.getStart();
                    LocalDateTime _curEnd = _cur.getEnd();
                    if (adding && _curStart.isAfter(_start) && _curStart.isBefore(_end) ) {
                        errorMessage += rb.getString("ACUSTOMEROVERLAP") + "\n";
                        valid = false;
                    }
                    if (valid && adding && _curEnd.isAfter(_start) && _curEnd.isBefore(_end)) {
                        errorMessage += rb.getString("ACUSTOMEROVERLAP") + "\n";
                        valid = false;
                    }
                    if (valid && !adding && appointment.getAppointmentId() !=_cur.getAppointmentId() && _curStart.isAfter(_start) && _curStart.isBefore(_end) ) {
                        errorMessage += rb.getString("ACUSTOMEROVERLAP") + "\n";
                        valid = false;
                    }
                    if (valid && !adding && appointment.getAppointmentId() !=_cur.getAppointmentId() && _curEnd.isAfter(_start) && _curEnd.isBefore(_end)) {
                        errorMessage += rb.getString("ACUSTOMEROVERLAP") + "\n";
                        valid = false;
                    }


                }

            }catch(Exception err){
                System.out.println(err);
            }

        }


        if(!valid){
            displayError(errorMessage);
            labelError.setText(errorMessage);
        }

        return valid;
    }

    /**
     * Handles the save logic for the Appointment
     */
    public void handleSave(ActionEvent actionEvent) throws IOException {
        Boolean valid = validate();
        if (valid){
            String _title = fieldTitle.getText();
            String _desc = fieldDescription.getText();
            String _location = fieldLocation.getText();
            String _type = fieldType.getText();
            String _startHourString = fieldStartHour.getText();
            String _startMinString = fieldStartMin.getText();
            String _endHourString = fieldEndHour.getText();
            String _endMinString = fieldEndMin.getText();
            LocalDate _startLocalDate = dateStart.getValue();
            LocalDate _endLocalDate = dateEnd.getValue();
            Contact _contact = comboContact.getValue();
            Customer _customer = comboCustomer.getValue();
            User _user = comboUser.getValue();



            int _contactId = _contact.getContactId();
            int _customerId = _customer.getCustomerId();
            int _userId = _user.getUserId();
            int _startHour = Integer.parseInt(_startHourString);
            int _startMin = Integer.parseInt(_startMinString);
            int _startYear=  _startLocalDate.getYear();
            int _startMonth = _startLocalDate.getMonthValue();
            int _startDay = _startLocalDate.getDayOfMonth();
            int _endHour = Integer.parseInt(_endHourString);
            int _endMin = Integer.parseInt(_endMinString);
            int _endYear = _endLocalDate.getYear();
            int _endMonth = _endLocalDate.getMonthValue();
            int _endDay = _endLocalDate.getDayOfMonth();

            LocalDateTime _start =  LocalDateTime.of(_startYear, _startMonth, _startDay, _startHour, _startMin);
            LocalDateTime _end = LocalDateTime.of(_endYear, _endMonth, _endDay, _endHour, _endMin);

            String _updatedBy = LoginController.getUser().getUsername();
            LocalDateTime _lastUpdate = LocalDateTime.now();


            if(adding){
                Appointment _appointment = new Appointment(0, _title, _desc, _location, _type, _start, _end, _lastUpdate, _updatedBy, _lastUpdate,_updatedBy, _customerId, _userId, _contactId);
                AppointmentDataAccessObject.addAppointment(_appointment);
                openPage(actionEvent, "/Views/Main.fxml");
            }
            if(!adding) {

                appointment.setStart(_start);
                appointment.setEnd(_end);
                appointment.setCustomerId(_customerId);
                appointment.setUserId(_userId);
                appointment.setTitle(_title);
                appointment.setDescription(_desc);
                appointment.setLocation(_location);
                appointment.setLastUpdatedBy(_updatedBy);
                appointment.setLastUpdate(_lastUpdate);
                AppointmentDataAccessObject.updateAppointment(appointment);
                openPage(actionEvent, "/Views/Main.fxml");
            }
        }

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
            String _type = appointment.getType();
            LocalDateTime _start = appointment.getStart();
            LocalDateTime _end = appointment.getEnd();


            Contact _contact = ContactDataAccessObject.getContactByContactID(_contactId);
            Customer _customer = CustomerDataAccessObject.getCustomerByCustomerID(_customerId);
            User _user = UserDataAccessObject.getUserByUserID(_userId);

            LocalDate _dateStart = LocalDate.of(_start.getYear(),_start.getMonth(), _start.getDayOfMonth());
            LocalDate _dateEnd = LocalDate.of(_end.getYear(),_end.getMonth(), _end.getDayOfMonth());


            fieldTitle.setText(_title);
            fieldDescription.setText(_desc);
            fieldLocation.setText(_location);
            fieldType.setText(_type);
            fieldStartHour.setText(""+_start.getHour());
            fieldStartMin.setText(""+ _start.getMinute());
            fieldEndHour.setText(""+_end.getHour());
            fieldEndMin.setText(""+_end.getMinute());

            dateStart.setValue(_dateStart);
            dateEnd.setValue(_dateEnd);

            comboCustomer.setValue(_customer);
            comboUser.setValue(_user);
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
        String _selUser = rb.getString("APPOINTMENTSELUSER");
        String _selCustomer = rb.getString("APPOINTMENTSELCUSTOMER");
        String _autogen = rb.getString("AUTOGEN");
        String _type = rb.getString("TYPE");


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
        labelType.setText(_type);
        comboContact.setPromptText(_selContact);
        comboCustomer.setPromptText(_selCustomer);
        comboUser.setPromptText(_selUser);
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
            comboUser.setItems(UserDataAccessObject.getAllUsers());
            comboCustomer.setItems(CustomerDataAccessObject.getAllCustomers());
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
        labelError.setText(text);
    }

}