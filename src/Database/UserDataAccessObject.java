package Database;
import Models.User;
import main.JDBC;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author xavier
 */
public class UserDataAccessObject {


    /**
     * 
     * @param username the username 
     * @return the User 
     */
    public static User getUserByUsername (String username) throws SQLException, Exception{
        String sql="SELECT * FROM Users WHERE User_Name  = '" + username+ "'";
        Query.makeQuery(sql);
           User userResult;
           ResultSet result=Query.getResult();
           while(result.next()){
            int User_ID = result.getInt("User_ID");
            String User_Name = result.getString("User_Name");
            String Password = result.getString("Password");
            Timestamp createDate=result.getTimestamp("Create_Date");
            LocalDateTime createDateCalendar=createDate.toLocalDateTime();
            String Created_By = result.getString("Created_By");
            Timestamp lastUpdate=result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateCalendar=lastUpdate.toLocalDateTime();
            String Last_Updated_By = result.getString("Last_Updated_By");

            userResult = new User(User_ID, User_Name, Password, createDateCalendar, Created_By, lastUpdateCalendar, Last_Updated_By);
               return userResult;
           }
        return null;
    }



    /**
     * 
     * @param userId the userID 
     * @return the User 
     */
    public static User getUserByUserID(int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE User_ID = " + userId;
        Query.makeQuery(sql);
        User userResult;
        ResultSet result = Query.getResult();
        while (result.next()) {
            int User_ID = result.getInt("User_ID");
            String User_Name = result.getString("User_Name");
            String Password = result.getString("Password");
            Timestamp createDate=result.getTimestamp("Create_Date");
            LocalDateTime createDateCalendar=createDate.toLocalDateTime();
            String Created_By = result.getString("Created_By");
            Timestamp lastUpdate=result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateCalendar=lastUpdate.toLocalDateTime();
            String Last_Updated_By = result.getString("Last_Updated_By");

            userResult = new User(User_ID, User_Name, Password, createDateCalendar, Created_By, lastUpdateCalendar, Last_Updated_By);
            return userResult;
        }
        return null;
    }

}