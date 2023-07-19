package Controllers;

import Database.AppointmentDataAccessObject;
import Database.CustomerDataAccessObject;
import Database.UserDataAccessObject;
import Models.Appointment;
import Models.Country;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Logger;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    private TableView<Appointment> tableA;
    @FXML
    private TableColumn<Appointment, Integer> aColumnID;
    @FXML
    private TableColumn<Appointment, String> aColumnTitle;
    @FXML
    private TableColumn<Appointment, String> aColumnDescription;
    @FXML
    private TableColumn<Appointment, String> aColumnLocation;
    @FXML
    private TableColumn<Appointment, LocalDateTime> aColumnType;
    @FXML
    private TableColumn<Appointment, LocalDateTime> aColumnStart;
    @FXML
    private TableColumn<Appointment, LocalDateTime> aColumnEnd;
    @FXML
    private TableColumn<Appointment, Integer> aColumnCustomer;
    @FXML
    private TableColumn<Appointment, Integer> aColumnUser;
    @FXML
    private TableColumn<Appointment, Integer> aColumnContact;

    @FXML
    private TableView<Customer> tableC;
    @FXML
    private TableColumn<Customer, Integer> cColumnID;
    @FXML
    private TableColumn<Customer, String> cColumnName;
    @FXML
    private TableColumn<Customer, String> cColumnAddress;
    @FXML
    private TableColumn<Customer, String> cColumnPostalCode;
    @FXML
    private TableColumn<Customer, String> cColumnPhone;
    @FXML
    private TableColumn<Customer, Integer> cColumnDivision;

    static private Appointment appointment;
    static private Customer customer;
    static private ObservableList<Appointment> appointments = FXCollections.observableArrayList();;
    static private ObservableList<Customer> customers = FXCollections.observableArrayList();;


    /**
     * @return [Customer] object that was selected from the table
     */
    public static Customer getCustomer(){return customer;}

    /**
     * @return [Appointment] object that was selected from the table
     */
    public static Appointment getAppointment(){return appointment;}

    /**
     * @return [ObservableList<Customer>] list from the table
     */
    public static  ObservableList<Customer> getAllCustomers(){return customers;}

    /**
     * @return [ObservableList<Appointment>] list from the table
     */
    public static ObservableList<Appointment> getAllAppointments(){return appointments;}


    /**
     * Function that checks and alerts the user if they are within 15 minutes of an appointment
     */
    public void appointmentAlert(){
        try{
            User user = LoginController.getUser();
            int _userId = user.getUserId();
            ObservableList<Appointment> userAppointments = FXCollections.observableArrayList();
            userAppointments = AppointmentDataAccessObject.getAppointmentByUserID(_userId);
            Boolean showAlert = false;
            for(int i = 0; i<userAppointments.size();i++){
                Appointment curAppointment = userAppointments.get(i);
                LocalDateTime appointmentTime = curAppointment.getStart();
                LocalDateTime alertTime = LocalDateTime.now().plusMinutes(15);
                if(appointmentTime.isBefore(alertTime) && appointmentTime.isAfter(LocalDateTime.now())){showAlert = true;}
            }
            if(showAlert){
                ResourceBundle rb =  LoginController.getRb();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(rb.getString("MAINAPPOINTMENTALERTTITLE"));
                alert.setHeaderText(rb.getString("MAINAPPOINTMENTALERTHEADER"));
                alert.setContentText(rb.getString("MAINAPPOINTMENTALERTTEXT"));
                alert.showAndWait();
            }

        }catch(Exception err){
            System.out.println(err);
        }

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
     * Function that correctly maps all the tables with te correct ObservableLists
     */
    public void mapTables(){
        aColumnID.setCellValueFactory(new PropertyValueFactory("appointmentId"));
        aColumnTitle.setCellValueFactory(new PropertyValueFactory("title"));
        aColumnDescription.setCellValueFactory(new PropertyValueFactory("description"));
        aColumnLocation.setCellValueFactory(new PropertyValueFactory("location"));
        aColumnType.setCellValueFactory(new PropertyValueFactory("type"));
        aColumnStart.setCellValueFactory(new PropertyValueFactory("start"));
        aColumnEnd.setCellValueFactory(new PropertyValueFactory("end"));
        aColumnCustomer.setCellValueFactory(new PropertyValueFactory("customerId"));
        aColumnUser.setCellValueFactory(new PropertyValueFactory("userId"));
        aColumnContact.setCellValueFactory(new PropertyValueFactory("contactId"));


        cColumnID.setCellValueFactory(new PropertyValueFactory("customerId"));
        cColumnName.setCellValueFactory(new PropertyValueFactory("customerName"));
        cColumnAddress.setCellValueFactory(new PropertyValueFactory("address"));
        cColumnPostalCode.setCellValueFactory(new PropertyValueFactory("postalCode"));
        cColumnPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        cColumnDivision.setCellValueFactory(new PropertyValueFactory("divisionId"));


        tableA.setItems(getAllAppointments());
        tableC.setItems(getAllCustomers());


    }

    /**
     * Function that correctly fetch the appointments and customers ObservableLists
     */
    public void fetchData(){
        try {
            appointments = AppointmentDataAccessObject.getAllAppointments();
            customers = CustomerDataAccessObject.getAllCustomers();
        }catch(Exception err){
            System.out.println(err);
        }



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
        fetchData();
        appointmentAlert();
        mapLabels();
        mapTables();

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