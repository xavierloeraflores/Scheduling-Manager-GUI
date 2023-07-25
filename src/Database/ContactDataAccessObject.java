package Database;
import Models.Contact;
import main.JDBC;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.format.DateTimeFormatter;

/**
 * Class representing all the methods to query the contacts table
 * @author xavierloeraflores
 */
public class ContactDataAccessObject {



    /**
     * This function queries a contact
     * @param _contactId the contactID int value
     * @return the Contact object
     */
    public static Contact getContactByContactID(int _contactId) throws SQLException {
        String sql = "SELECT * FROM contacts WHERE Contact_ID = " + _contactId;
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Contact contactResult;
            int contactId = result.getInt("Contact_ID");
            String contactName = result.getString("Contact_Name");
            String email = result.getString("Email");

            contactResult = new Contact(contactId, contactName, email);
            return contactResult;
        }
        return null;
    }



    /**
     * This function queries a list of contacts
     * @return [ObservableList] of Contact objects
     */

    public static ObservableList<Contact> getAllContacts() throws SQLException {
        String sql = "SELECT * FROM contacts";
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Contact contactResult;
            int contactId = result.getInt("Contact_ID");
            String contactName = result.getString("Contact_Name");
            String email = result.getString("Email");

            contactResult = new Contact(contactId, contactName, email);
            contacts.add(contactResult);
        }
        return contacts;
    }


    /**
     * This function queries a list of contacts
     * @param _email the email string value
     * @return [ObservableList] of Contact objects
     */
    public static ObservableList<Contact> getContactByEmail(int _email) throws SQLException {
        String sql = "SELECT * FROM contacts WHERE Email = '" + _email + "'";
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Contact contactResult;
            int contactId = result.getInt("Contact_ID");
            String contactName = result.getString("Contact_Name");
            String email = result.getString("Email");

            contactResult = new Contact(contactId, contactName, email);
            contacts.add(contactResult);
        }
        return contacts;
    }



    /**
     * This function deletes a contact record
     * @param _contactId the contactID int value
     */
    public static void deleteContactByContactID(int _contactId) throws SQLException {
        try{
            String sql = "DELETE FROM contacts WHERE Contact_ID = " + _contactId;
            DAO.update(sql);
        }catch(Exception error){
            System.out.println(error);
        }
    }

    /**
     * This function deletes a contact record
     * @param _email the email string value
     */
    public static void deleteContactByDivisionID(int _email) throws SQLException {
        try{
            String sql = "DELETE FROM contacts WHERE Email = '" + _email + "'";
            DAO.update(sql);
        }catch(Exception error){
            System.out.println(error);
        }
    }




    /**
     * This function adds a contact record
     * @param _contact the Contact object
     */
    public static void addContact(Contact _contact) {
        try{
            String sqlInsert = "INSERT INTO contacts (Contact_Name, Email) ";


            String ContactName = "'" + _contact.getContactName() + "', ";
            String Email = "'" + _contact.getEmail() + "')";

            String sqlValues = "VALUES("+ContactName+Email;
            String sql = sqlInsert + sqlValues;
            DAO.update(sql);
        } catch(Exception error){
            System.out.println(error);
        }
    }

    /**
     * This function update a contact record
     * @param _contact the Contact object
     */
    public static void updateContact(Contact _contact) {
        try{
            String sqlUpdate = "UPDATE contacts ";

            String ContactName = "Contact_Name='" + _contact.getContactName() + "', ";
            String Email = "Email='" + _contact.getEmail() + "'";


            String sqlSet = "SET "+ ContactName+Email;
            String sqlWhere = " WHERE Contact_ID = "+ _contact.getContactId();

            String sql = sqlUpdate + sqlSet + sqlWhere;
            DAO.update(sql);
        } catch(Exception error){
            System.out.println(error);
        }
    }



}