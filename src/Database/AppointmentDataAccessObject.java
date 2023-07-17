package Database;
import Models.Appointment;
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
 * Class representing all the methods to query the appointments table
 * @author xavierloeraflores
 */
public class AppointmentDataAccessObject {
    


    /**
     * This function queries an appointment
     * @param _appointmentId the appointmentID int value
     * @return the Appointment object
     */
    public static Appointment getAppointmentByAppointmentID(int _appointmentId) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE Appointment_ID = " + _appointmentId;
        Appointment appointmentResult;
        ResultSet result = DAO.query(sql);
        while(result.next()){
            int appointmentId = result.getInt("Appointment_ID");
            int customerId = result.getInt("Customer_ID");
            int userId = result.getInt("User_ID");
            int contactId = result.getInt("Contact_ID");
            String title = result.getString("Title");
            String description = result.getString("Description");
            String location = result.getString("Location");
            String type = result.getString("Type");
            Timestamp startDateTimestamp = result.getTimestamp("Start");
            LocalDateTime startDateTime = startDateTimestamp.toLocalDateTime();
            Timestamp endDateTimestamp = result.getTimestamp("End");
            LocalDateTime endDateTime = endDateTimestamp.toLocalDateTime();
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            appointmentResult = new Appointment(appointmentId, title, description, location, type, startDateTime,endDateTime, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, customerId, userId, contactId);
            return appointmentResult;
        }
        return null;
    }



    /**
     * This function queries a list of appointments
     * @return [ObservableList] of Appointment objects
     */

    public static ObservableList<Appointment> getAllAppointments() throws SQLException {
        String sql = "SELECT * FROM appointments";
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Appointment appointmentResult;
            int appointmentId = result.getInt("Appointment_ID");
            int customerId = result.getInt("Customer_ID");
            int userId = result.getInt("User_ID");
            int contactId = result.getInt("Contact_ID");
            String title = result.getString("Title");
            String description = result.getString("Description");
            String location = result.getString("Location");
            String type = result.getString("Type");
            Timestamp startDateTimestamp = result.getTimestamp("Start");
            LocalDateTime startDateTime = startDateTimestamp.toLocalDateTime();
            Timestamp endDateTimestamp = result.getTimestamp("End");
            LocalDateTime endDateTime = endDateTimestamp.toLocalDateTime();
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            appointmentResult = new Appointment(appointmentId, title, description, location, type, startDateTime,endDateTime, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, customerId, userId, contactId);
            appointments.add(appointmentResult);
        }
        return appointments;
    }


    /**
     * This function queries a list of appointments
     * @param _userId the userID int value
     * @return [ObservableList] of Appointment objects
     */
    public static ObservableList<Appointment> getAppointmentByUserID(int _userId) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE User_ID = " + _userId;
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Appointment appointmentResult;
            int appointmentId = result.getInt("Appointment_ID");
            int customerId = result.getInt("Customer_ID");
            int userId = result.getInt("User_ID");
            int contactId = result.getInt("Contact_ID");
            String title = result.getString("Title");
            String description = result.getString("Description");
            String location = result.getString("Location");
            String type = result.getString("Type");
            Timestamp startDateTimestamp = result.getTimestamp("Start");
            LocalDateTime startDateTime = startDateTimestamp.toLocalDateTime();
            Timestamp endDateTimestamp = result.getTimestamp("End");
            LocalDateTime endDateTime = endDateTimestamp.toLocalDateTime();
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            appointmentResult = new Appointment(appointmentId, title, description, location, type, startDateTime,endDateTime, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, customerId, userId, contactId);
            appointments.add(appointmentResult);
        }
        return appointments;
    }

    /**
     * This function queries a list of appointments
     * @param _contactId the contactID int value
     * @return [ObservableList] of Appointment objects
     */
    public static ObservableList<Appointment> getAppointmentByContactID(int _contactId) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE Contact_ID = " + _contactId;
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Appointment appointmentResult;
            int appointmentId = result.getInt("Appointment_ID");
            int customerId = result.getInt("Customer_ID");
            int userId = result.getInt("User_ID");
            int contactId = result.getInt("Contact_ID");
            String title = result.getString("Title");
            String description = result.getString("Description");
            String location = result.getString("Location");
            String type = result.getString("Type");
            Timestamp startDateTimestamp = result.getTimestamp("Start");
            LocalDateTime startDateTime = startDateTimestamp.toLocalDateTime();
            Timestamp endDateTimestamp = result.getTimestamp("End");
            LocalDateTime endDateTime = endDateTimestamp.toLocalDateTime();
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            appointmentResult = new Appointment(appointmentId, title, description, location, type, startDateTime,endDateTime, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, customerId, userId, contactId);
            appointments.add(appointmentResult);
        }
        return appointments;
    }


    /**
     * This function queries a list of appointments
     * @param _customerId the customerID int value
     * @return [ObservableList] of Appointment objects
     */
    public static ObservableList<Appointment> getAppointmentByCustomerID(int _customerId) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE Customer_ID = " + _customerId;
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Appointment appointmentResult;
            int appointmentId = result.getInt("Appointment_ID");
            int customerId = result.getInt("Customer_ID");
            int userId = result.getInt("User_ID");
            int contactId = result.getInt("Contact_ID");
            String title = result.getString("Title");
            String description = result.getString("Description");
            String location = result.getString("Location");
            String type = result.getString("Type");
            Timestamp startDateTimestamp = result.getTimestamp("Start");
            LocalDateTime startDateTime = startDateTimestamp.toLocalDateTime();
            Timestamp endDateTimestamp = result.getTimestamp("End");
            LocalDateTime endDateTime = endDateTimestamp.toLocalDateTime();
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            appointmentResult = new Appointment(appointmentId, title, description, location, type, startDateTime,endDateTime, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, customerId, userId, contactId);
            appointments.add(appointmentResult);
        }
        return appointments;
    }

    /**
     * This function queries a list of appointments
     * @param _type the type String value
     * @return [ObservableList] of Appointment objects
     */
    public static ObservableList<Appointment> getAppointmentByType(String _type) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE Type = '" + _type + "'";
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            Appointment appointmentResult;
            int appointmentId = result.getInt("Appointment_ID");
            int customerId = result.getInt("Customer_ID");
            int userId = result.getInt("User_ID");
            int contactId = result.getInt("Contact_ID");
            String title = result.getString("Title");
            String description = result.getString("Description");
            String location = result.getString("Location");
            String type = result.getString("Type");
            Timestamp startDateTimestamp = result.getTimestamp("Start");
            LocalDateTime startDateTime = startDateTimestamp.toLocalDateTime();
            Timestamp endDateTimestamp = result.getTimestamp("End");
            LocalDateTime endDateTime = endDateTimestamp.toLocalDateTime();
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            appointmentResult = new Appointment(appointmentId, title, description, location, type, startDateTime,endDateTime, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, customerId, userId, contactId);
            appointments.add(appointmentResult);
        }
        return appointments;
    }


    /**
     * This function deletes an appointment record
     * @param _appointmentId the appointmentID int value
     */
    public static void deleteAppointmentByAppointmentID(int _appointmentId) throws SQLException {
        try{
            String sql = "DELETE FROM appointments WHERE Appointment_ID = " + _appointmentId;
            DAO.update(sql);
        }catch(Exception error){
            System.out.println(error);
        }
    }

    /**
     * This function deletes an appointment record
     * @param _userId the userID int value
     */
    public static void deleteAppointmentByUserID(int _userId) throws SQLException {
        try{
            String sql = "DELETE FROM appointments WHERE User_ID = " + _userId;
            DAO.update(sql);
        }catch(Exception error){
            System.out.println(error);
        }
    }


    /**
     * This function deletes an appointment record
     * @param _customerId the customerID int value
     */
    public static void deleteAppointmentByCustomerID(int _customerId) throws SQLException {
        try{
            String sql = "DELETE FROM appointments WHERE Customer_ID = " + _customerId;
            DAO.update(sql);
        }catch(Exception error){
            System.out.println(error);
        }
    }

    /**
     * This function deletes an appointment record
     * @param _contactId the contactID int value
     */
    public static void deleteAppointmentByContactID(int _contactId) throws SQLException {
        try{
            String sql = "DELETE FROM appointments WHERE Contact_ID = " + _contactId;
            DAO.update(sql);
        }catch(Exception error){
            System.out.println(error);
        }
    }

    public static void addAppointment(Appointment _appointment) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String sqlInsert = "INSERT INTO appointments(Title, Description, Location, Type, Start, End, Create_Date, Created_By, Last_Update, Last_Updated_By, Customer_ID, User_ID, Contact_ID) ";
            String Title = "'" + _appointment.getTitle() + "', ";
            String Description = "'" + _appointment.getDescription() + "', ";
            String Location = "'" + _appointment + "', ";
            String Type = "'" + _appointment + "', ";
            LocalDateTime StartTime= _appointment.getStart();
            LocalDateTime EndTime = _appointment.getEnd();
            LocalDateTime CreateDateTime = _appointment.getCreateDate();
            LocalDateTime LastUpdateTime = _appointment.getLastUpdate();
            String Start = "'" + StartTime.format(formatter).toString() + "', ";
            String End = "'" + EndTime.format(formatter).toString() + "', ";
            String CreateDate = "'" + CreateDateTime.format(formatter).toString() + "', ";
            String CreatedBy = "'" + _appointment.getCreatedBy() + "', ";
            String LastUpdate = "'" + LastUpdateTime.format(formatter).toString() + "', ";
            String LastUpdatedBy = "'" + _appointment.getLastUpdatedBy() + "', ";
            String CustomerID = + _appointment.getCustomerId()+", ";
            String UserID = + _appointment.getUserId()+", ";
            String ContactID = + _appointment.getContactId()+")";


            String sqlValues = "VALUES("+Title+Description+Location+Type+Start+End+CreateDate+CreatedBy+LastUpdate+LastUpdatedBy+CustomerID+UserID+ContactID;

            String sql = sqlInsert + sqlValues;
            DAO.query(sql);
        } catch(Exception error){
            System.out.println(error);
        }
    }



}