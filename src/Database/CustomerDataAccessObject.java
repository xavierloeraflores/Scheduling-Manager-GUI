package Database;
import Models.Customer;
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
 * Class representing all the methods to query the customers table
 * @author xavierloeraflores
 */
public class CustomerDataAccessObject {



    /**
     * This function queries a customer
     * @param _customerId the customerID int value
     * @return the Customer object
     */
    public static Customer getCustomerByCustomerID(int _customerId) throws SQLException {
        String sql = "SELECT * FROM customers WHERE Customer_ID = " + _customerId;
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Customer customerResult;
            int customerId = result.getInt("Customer_ID");
            String customerName = result.getString("Customer_Name");
            String address = result.getString("Address");
            String postalCode = result.getString("Postal_Code");
            String phone = result.getString("Phone");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");
            int divisionId = result.getInt("Division_ID");

            customerResult = new Customer(customerId, customerName, address, postalCode, phone, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, divisionId);
            return customerResult;
        }
        return null;
    }



    /**
     * This function queries a list of customers
     * @return [ObservableList] of Customer objects
     */

    public static ObservableList<Customer> getAllCustomers() throws SQLException {
        String sql = "SELECT * FROM customers";
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Customer customerResult;
            int customerId = result.getInt("Customer_ID");
            String customerName = result.getString("Customer_Name");
            String address = result.getString("Address");
            String postalCode = result.getString("Postal_Code");
            String phone = result.getString("Phone");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");
            int divisionId = result.getInt("Division_ID");

            customerResult = new Customer(customerId, customerName, address, postalCode, phone, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, divisionId);
            customers.add(customerResult);
        }
        return customers;
    }


    /**
     * This function queries a list of customers
     * @param _divisionId the divisionID int value
     * @return [ObservableList] of Customer objects
     */
    public static ObservableList<Customer> getCustomerByDivisionID(int _divisionId) throws SQLException {
        String sql = "SELECT * FROM customers WHERE Division_ID = " + _divisionId;
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Customer customerResult;
            int customerId = result.getInt("Customer_ID");
            String customerName = result.getString("Customer_Name");
            String address = result.getString("Address");
            String postalCode = result.getString("Postal_Code");
            String phone = result.getString("Phone");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");
            int divisionId = result.getInt("Division_ID");

            customerResult = new Customer(customerId, customerName, address, postalCode, phone, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, divisionId);
            customers.add(customerResult);
        }
        return customers;
    }
    




    /**
     * This function deletes a customer record
     * @param _customerId the customerID int value
     */
    public static void deleteCustomerByCustomerID(int _customerId) throws SQLException {
        try{
            String sql = "DELETE FROM customers WHERE Customer_ID = " + _customerId;
            DAO.update(sql);
        }catch(Exception error){
            System.out.println(error);
        }
    }

    /**
     * This function deletes a customer record
     * @param _divisionId the divisionId int value
     */
    public static void deleteCustomerByDivisionID(int _divisionId) throws SQLException {
        try{
            String sql = "DELETE FROM customers WHERE Division_ID = " + _divisionId;
            DAO.update(sql);
        }catch(Exception error){
            System.out.println(error);
        }
    }

    


    /**
     * This function adds a customer record
     * @param _customer the Customer object
     */
    public static void addCustomer(Customer _customer) {
        try{

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String sqlInsert = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Create_Date, Created_By, Last_Update, Last_Updated_By, Division_ID) ";


            String CustomerName = "'" + _customer.getCustomerName() + "', ";
            String Address = "'" + _customer.getAddress() + "', ";
            String PostalCode = "'" + _customer.getPostalCode() + "', ";
            String Phone = "'" + _customer.getPhone() + "', ";

            LocalDateTime CreateDateTime = _customer.getCreateDate();
            LocalDateTime LastUpdateTime = _customer.getLastUpdate();
            String CreateDate = "'" + CreateDateTime.format(formatter).toString() + "', ";
            String CreatedBy = "'" + _customer.getCreatedBy() + "', ";
            String LastUpdate = "'" + LastUpdateTime.format(formatter).toString() + "', ";
            String LastUpdatedBy = "'" + _customer.getLastUpdatedBy() + "', ";
            String DivisionID = _customer.getDivisionId()+");";


            String sqlValues = "VALUES("+CustomerName+Address+PostalCode+Phone+CreateDate+CreatedBy+LastUpdate+LastUpdatedBy+DivisionID;

            String sql = sqlInsert + sqlValues;
            System.out.println("AddingCustomer:" + sql);
            DAO.update(sql);
        } catch(Exception error){
            System.out.println(error);
        }
    }

    /**
     * This function update a customer record
     * @param _customer the Customer object
     */
    public static void updateCustomer(Customer _customer) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String sqlUpdate = "UPDATE customers ";

            String CustomerName = "Customer_Name='" + _customer.getCustomerName() + "', ";
            String Address = "Address='" + _customer.getAddress() + "', ";
            String PostalCode = "Postal_Code='" + _customer.getPostalCode() + "', ";
            String Phone = "Phone='" + _customer.getPhone() + "', ";

            LocalDateTime LastUpdateTime = _customer.getLastUpdate();;
            String LastUpdate = "Last_Update='" + LastUpdateTime.format(formatter).toString() + "', ";
            String LastUpdatedBy = "Last_Updated_By='" + _customer.getLastUpdatedBy() + "', ";
            String DivisionID = "Division_ID=" + _customer.getDivisionId();


            String sqlSet = "SET "+ CustomerName+Address+PostalCode+Phone+LastUpdate+LastUpdatedBy+DivisionID;
            String sqlWhere = " WHERE Customer_ID = "+ _customer.getCustomerId();

            String sql = sqlUpdate + sqlSet + sqlWhere;
            DAO.query(sql);
        } catch(Exception error){
            System.out.println(error);
        }
    }



}