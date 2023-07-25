package Controllers;

import Database.CountryDataAccessObject;
import Database.CustomerDataAccessObject;
import Database.DivisionDataAccessObject;
import Models.Country;
import Models.Customer;
import Models.FirstLevelDivision;
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
import java.time.LocalDateTime;
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
    private ComboBox<Country> comboCountry;
    @FXML 
    private ComboBox<FirstLevelDivision> comboDivision;



    static private ResourceBundle rb;
    private String language;
    private String errorMessage;
    private Boolean adding = true;
    private Customer customer;








    /**
     * Validates inputs for the Customer
     */
    public Boolean validate(){
        errorMessage = "";
        Boolean valid = true;

        if (fieldName.getText() == ""){
            valid = false;
            errorMessage += rb.getString("CUSTOMERERRNAME") + "\n";
        }
        if (fieldAddress.getText() == "" || !fieldAddress.getText().contains(",")){
            valid = false;
            errorMessage += rb.getString("CUSTOMERERRADD") + "\n";
        }
        if (fieldPostalCode.getText() == ""){
            valid = false;
            errorMessage += rb.getString("CUSTOMERERRPOST") + "\n";
        }
        if (fieldPhone.getText() == ""){
            valid = false;
            errorMessage += rb.getString("CUSTOMERERRPHONE") + "\n";
        }
        if (comboCountry.getValue() == null){
            valid = false;
            errorMessage += rb.getString("CUSTOMERERRCOUNTRY") + "\n";
        }
        if (comboDivision.getValue() == null){
            valid = false;
            errorMessage += rb.getString("CUSTOMERERRDIV") + "\n";
        }


        if(!valid){
            errorMessage += rb.getString("ERROREMPTY") + "\n";
        }


        if(!valid){
            displayError(errorMessage);
            labelError.setText(errorMessage);
        }

        return valid;
    }

    /**
     * 
     */
    public void handleSave(ActionEvent actionEvent) throws IOException {
        Boolean valid = validate();
        if (valid){
            String _name  = fieldName.getText();
            String _address = fieldAddress.getText();
            String _postal = fieldPostalCode.getText();
            String _phone = fieldPhone.getText();
            FirstLevelDivision _division = comboDivision.getValue();
            int _divisionId = _division.getDivisionId();
            String _updatedBy = LoginController.getUser().getUsername();
            LocalDateTime _lastUpdate = LocalDateTime.now();

            if(adding){
                Customer _customer = new Customer(0, _name, _address, _postal, _phone,_lastUpdate, _updatedBy,_lastUpdate, _updatedBy, _divisionId );
                CustomerDataAccessObject.addCustomer(_customer);
                openPage(actionEvent, "/Views/Main.fxml");
            }
            if(!adding) {
                customer.setCustomerName(_name);
                customer.setAddress(_address);
                customer.setPhone(_phone);
                customer.setPostalCode(_postal);
                customer.setDivisionId(_divisionId);
                customer.setLastUpdatedBy(_updatedBy);
                customer.setLastUpdate(_lastUpdate);
                CustomerDataAccessObject.updateCustomer(customer);
                openPage(actionEvent, "/Views/Main.fxml");
            }
        }
    }

    /**
     *
     */
    public void handleCountrySelect(ActionEvent actionEvent){
        try{
            Country _selectedCountry = comboCountry.getSelectionModel().getSelectedItem();
            int selectedCountryId = _selectedCountry.getCountryId();
            comboDivision.setItems(DivisionDataAccessObject.getDivisionsByCountryID(selectedCountryId));
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
        try {
            language = null;
            mapLabels();
            adding = MainController.getAdding();
            comboCountry.setItems(CountryDataAccessObject.getAllCountries());
            if(!adding){
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
     * Maps the labels to the correct language
     */
    public void mapUpdating() {
        try {


            customer = MainController.getCustomer();
            fieldName.setText(customer.getCustomerName());
            fieldAddress.setText(customer.getAddress());
            fieldPhone.setText(customer.getPhone());
            fieldPostalCode.setText(customer.getPostalCode());
            int _divisionId = customer.getDivisionId();
            FirstLevelDivision _division = DivisionDataAccessObject.getDivisionByDivisionID(_divisionId);
            int _countryId = _division.getCountryId();
            Country _country = CountryDataAccessObject.getCountryByCountryID(_countryId);
            comboCountry.setValue(_country);
            comboDivision.setValue(_division);

        }catch(Exception err){
            System.out.println(err);
        }
    }

    /**
     * Maps the labels to the correct language
     */
    public void mapLabels(){
        ResourceBundle _rb =  LoginController.getRb();
        rb = _rb;
        String _save = rb.getString("SAVE");
        String _cancel = rb.getString("CANCEL");
        String _userId =rb.getString("AUTOGEN");
        String _id = rb.getString("ID");
        String _name = rb.getString("CUSTOMERNAME");
        String _address = rb.getString("CUSTOMERADDRESS");
        String _postalCode = rb.getString("CUSTOMERPOSTALCODE");
        String _phone = rb.getString("CUSTOMERPHONE");
        String _country = rb.getString("CUSTOMERCOUNTRY");
        String _division= rb.getString("CUSTOMERDIVISION");
        String _selectCountry = rb.getString("CUSTOMERSELCOUNTRY");
        String _selectDivision = rb.getString("CUSTOMERSELDIVSION");
        if(adding){
            _userId = _userId + MainController.getAllCustomers().size();
        }else{
            _userId = _userId + MainController.getCustomer().getCustomerId();
        }


        buttonSave.setText(_save);
        buttonCancel.setText(_cancel);
        labelUserId.setText(_userId);
        labelId.setText(_id);
        labelName.setText(_name);
        labelAddress.setText(_address);
        labelPostalCode.setText(_postalCode);
        labelPhone.setText(_phone);
        labelCountry.setText(_country);
        labelDivision.setText(_division);
        comboCountry.setPromptText(_selectCountry);
        comboDivision.setPromptText(_selectDivision);

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