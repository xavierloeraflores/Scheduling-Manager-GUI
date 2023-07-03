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
     * @param username String value
     * @return the User object
     */
    public static User getUserByUsername (String username) throws SQLException, Exception{
        String sql="SELECT * FROM Users WHERE User_Name  = '" + username+ "'";
           User userResult;
           ResultSet result = DAO.query(sql);
           while(result.next()){
            int userId = result.getInt("User_ID");
            String _username = result.getString("User_Name");
            String password = result.getString("Password");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            userResult = new User(userId, _username, password, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy);
            return userResult;
           }
        return null;
    }


    /**
     * 
     * @param userId the userID int value
     * @return the User object
     */
    public static User getUserByUserID(int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE User_ID = " + userId;
        User userResult;
        ResultSet result = DAO.query(sql);
        while(result.next()){
            int _userId = result.getInt("User_ID");
            String username = result.getString("User_Name");
            String password = result.getString("Password");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            userResult = new User(_userId, username, password, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy);
            return userResult;
        }
        return null;
    }

}