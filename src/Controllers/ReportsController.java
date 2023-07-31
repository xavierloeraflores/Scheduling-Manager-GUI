package Controllers;

import Database.*;
import Models.*;
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
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Controller class for the Main.fmxl form.
 * Implements Initializable
 * @author xavierloeraflores
 */
public class ReportsController implements Initializable{

    @FXML
    private Label labelReportA;
    @FXML
    private Label labelReportB;
    @FXML
    private Label labelReportC;
    @FXML
    private Label labelTotalA;
    @FXML
    private Label labelTotalB;
    @FXML
    private Label labelTotalC;

    @FXML
    private ComboBox<Country> comboCountry;
    @FXML
    private ComboBox<FirstLevelDivision> comboDivision;
    @FXML
    private ComboBox<Contact> comboContact;
    @FXML
    private ComboBox<String> comboType;
    @FXML
    private ComboBox<Integer> comboMonth;

    @FXML
    private Button buttonReturn;


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
    private TableView<Appointment> tableB;
    @FXML
    private TableColumn<Appointment, Integer> bColumnID;
    @FXML
    private TableColumn<Appointment, String> bColumnTitle;
    @FXML
    private TableColumn<Appointment, String> bColumnDescription;
    @FXML
    private TableColumn<Appointment, String> bColumnLocation;
    @FXML
    private TableColumn<Appointment, LocalDateTime> bColumnType;
    @FXML
    private TableColumn<Appointment, LocalDateTime> bColumnStart;
    @FXML
    private TableColumn<Appointment, LocalDateTime> bColumnEnd;
    @FXML
    private TableColumn<Appointment, Integer> bColumnCustomer;
    @FXML
    private TableColumn<Appointment, Integer> bColumnUser;
    @FXML
    private TableColumn<Appointment, Integer> bColumnContact;

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

    static private ResourceBundle rb;


    /**
     * Function for updating the table and label for report  A
     */
    public void updateA()  {
        try{
            ObservableList<Appointment> _appointments = FXCollections.observableArrayList();
            if(comboType.getValue() == null){
                _appointments = AppointmentDataAccessObject.getAllAppointments();
            }
            if(comboType.getValue() != null){
                _appointments = AppointmentDataAccessObject.getAppointmentByType(comboType.getValue());
            }
            if(comboMonth.getValue() != null){
                ObservableList<Appointment> _appointmentsByMonth = FXCollections.observableArrayList();
                for(int i = 0; i<_appointments.size(); i++){
                    Appointment _cur = _appointments.get(i);
                    if(_cur.getStart().getMonthValue()==comboMonth.getValue()){ _appointmentsByMonth.add(_cur); }
                }
                _appointments = _appointmentsByMonth;
            }

            String _total  = rb.getString("TOTAL") + _appointments.size();
            tableA.setItems(_appointments);
            labelTotalA.setText(_total);
        }catch(Exception err){
            System.out.println(err);
        }
    }

    /**
     * Function for updating the table and label for report  B
     */
    public void updateB()  {
        try{
            ObservableList<Appointment> _appointments = FXCollections.observableArrayList();

            if(comboContact.getValue() == null){
                _appointments = AppointmentDataAccessObject.getAllAppointments();
            }
            if(comboContact.getValue() != null){
                Contact _selContact = comboContact.getValue();
                int contactId = _selContact.getContactId();
                _appointments = AppointmentDataAccessObject.getAppointmentByContactID(contactId);
            }
            String _total  = rb.getString("TOTAL") + _appointments.size();
            tableB.setItems(_appointments);
            labelTotalB.setText(_total);
        }catch(Exception err){
            System.out.println(err);
        }
    }

    /**
     * Function for updating the table and label for report  C
     */
    public void updateC()  {
        try{
            ObservableList<Customer> _customers = FXCollections.observableArrayList();
            if(comboDivision.getValue() == null){
                _customers = CustomerDataAccessObject.getAllCustomers();
            }
            if(comboCountry.getValue() != null){
                Country _country = comboCountry.getValue();
                int countryId = _country.getCountryId();
                for(int i = 0;i<_customers.size(); i++){
                    Customer _cur = _customers.get(i);
                    int _divisionId = _cur.getDivisionId();
                    FirstLevelDivision _division = DivisionDataAccessObject.getDivisionByDivisionID(_divisionId);
                    if(_division.getCountryId() !=countryId){ _customers.remove(i); }
                }
            }
            if(comboDivision.getValue() != null){
                FirstLevelDivision _division  = comboDivision.getValue();
                Integer divisionId = _division.getDivisionId();
                _customers = CustomerDataAccessObject.getCustomerByDivisionID(divisionId);
            }

            String _total  = rb.getString("TOTAL") + _customers.size();
            tableC.setItems(_customers);
            labelTotalC.setText(_total);
        }catch(Exception err){
            System.out.println(err);
        }
    }

    /**
     * Sends the user to the Main Screen
     * @param actionEvent JavaFX action event
     * @throws IOException
     */
    @FXML
    public void handleReturn(ActionEvent actionEvent) throws IOException {
        openPage(actionEvent, "/Views/Main.fxml");
    }

    /**
     * Handles the combo box logix for selecting a report A
     */
    public void handleASelect(ActionEvent actionEvent){updateA();}

    /**
     * Handles the combo box logix for selecting a Contact
     */
    public void handleContactSelect(ActionEvent actionEvent){updateB();}

    /**
     * Handles the combo box logix for selecting a division
     */
    public void handleDivisionSelect(ActionEvent actionEvent){ updateC(); }

    /**
     * Handles the combo box logix for selecting a country
     */
    public void handleCountrySelect(ActionEvent actionEvent){
        try{
            Country _selectedCountry = comboCountry.getSelectionModel().getSelectedItem();
            int selectedCountryId = _selectedCountry.getCountryId();
            comboDivision.setItems(DivisionDataAccessObject.getDivisionsByCountryID(selectedCountryId));
            updateC();
        }catch(Exception err){
            System.out.println(err);
        }
    }

    /**
     * Function that correctly maps all the labels to the correct language
     */
    public void mapLabels(){
        ResourceBundle _rb =  LoginController.getRb();
        rb=_rb;
        String _selectCountry = rb.getString("CUSTOMERSELCOUNTRY");
        String _selectDivision = rb.getString("CUSTOMERSELDIVSION");
        String _selectContact = rb.getString("APPOINTMENTSELCONTACT");
        String _selectMonth = rb.getString("SELMONTH");
        String _selectType = rb.getString("SELTYPE");
        String _reportA = rb.getString("REPORTA");
        String _reportB = rb.getString("REPORTB");
        String _reportC = rb.getString("REPORTC");
        String _return = rb.getString("RETURN");
        String _total  = rb.getString("TOTAL");


        buttonReturn.setText(_return);
        labelReportA.setText(_reportA);
        labelReportB.setText(_reportB);
        labelReportC.setText(_reportC);

        labelTotalA.setText(_total);
        labelTotalB.setText(_total);
        labelTotalC.setText(_total);

        comboContact.setPromptText(_selectContact);
        comboMonth.setPromptText(_selectMonth);
        comboType.setPromptText(_selectType);
        comboCountry.setPromptText(_selectCountry);
        comboDivision.setPromptText(_selectDivision);

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


        bColumnID.setCellValueFactory(new PropertyValueFactory("appointmentId"));
        bColumnTitle.setCellValueFactory(new PropertyValueFactory("title"));
        bColumnDescription.setCellValueFactory(new PropertyValueFactory("description"));
        bColumnLocation.setCellValueFactory(new PropertyValueFactory("location"));
        bColumnType.setCellValueFactory(new PropertyValueFactory("type"));
        bColumnStart.setCellValueFactory(new PropertyValueFactory("start"));
        bColumnEnd.setCellValueFactory(new PropertyValueFactory("end"));
        bColumnCustomer.setCellValueFactory(new PropertyValueFactory("customerId"));
        bColumnUser.setCellValueFactory(new PropertyValueFactory("userId"));
        bColumnContact.setCellValueFactory(new PropertyValueFactory("contactId"));

        cColumnID.setCellValueFactory(new PropertyValueFactory("customerId"));
        cColumnName.setCellValueFactory(new PropertyValueFactory("customerName"));
        cColumnAddress.setCellValueFactory(new PropertyValueFactory("address"));
        cColumnPostalCode.setCellValueFactory(new PropertyValueFactory("postalCode"));
        cColumnPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        cColumnDivision.setCellValueFactory(new PropertyValueFactory("divisionId"));

        updateA();
        updateB();
        updateC();
    }


    /**
     * Initializes the FXML Screen
     * @param url parameter for the FXML Screen
     * @param resourceBundle parameter for the FXML Screen
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try{
            mapLabels();
            mapTables();
            comboContact.setItems(ContactDataAccessObject.getAllContacts());
            comboCountry.setItems(CountryDataAccessObject.getAllCountries());
            comboDivision.setItems(DivisionDataAccessObject.getAllDivisions());
            ObservableList<Integer> months = FXCollections.observableArrayList();
            for(int i=1; i<=12; i++){ months.add(i); }
            comboMonth.setItems(months);
            ObservableList<String> types = FXCollections.observableArrayList();
            ObservableList<Appointment> appointments = AppointmentDataAccessObject.getAllAppointments();
            for(int i =0; i<appointments.size(); i ++){ types.add(appointments.get(i).getType()); }
            comboType.setItems(types);
        }catch(Exception err){
            System.out.println(err);
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