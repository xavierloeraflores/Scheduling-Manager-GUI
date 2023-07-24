package Controllers;

import Database.CountryDataAccessObject;
import Database.DivisionDataAccessObject;
import Models.Country;
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








    /**
     * 
     */
    public Boolean validate(){
        errorMessage = "";
        Boolean valid = true;

        if (fieldName.getText() == ""){valid = false;}
        if (fieldAddress.getText() == ""){valid = false;}
        if (fieldPostalCode.getText() == ""){valid = false;}
        if (fieldPhone.getText() == ""){valid = false;}
        if (comboCountry.getValue() == null){valid = false;}
        if (comboDivision.getValue() == null){valid = false;}


        if(!valid){
            errorMessage = "All Fields must not be empty.";
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
    public void handleSave(){
        Boolean valid = validate();

        if(valid){

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