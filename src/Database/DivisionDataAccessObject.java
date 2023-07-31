package Database;
import Models.FirstLevelDivision;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class representing all the methods to query the country table
 * @author xavierloeraflores
 */
public class DivisionDataAccessObject {
    /**
     *
     * @param divisionId the divisionID int value
     * @return the FirstLevelDivision object
     */
    public static FirstLevelDivision getDivisionByDivisionID(int divisionId) throws SQLException {
        String sql = "SELECT * FROM first_level_divisions WHERE Division_ID = " + divisionId;
        FirstLevelDivision divisionResult;
        ResultSet result = DAO.query(sql);
        while(result.next()){
            int _divisionId = result.getInt("Division_ID");
            String division = result.getString("Division");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");
            int countryId = result.getInt("Country_ID");
            divisionResult = new FirstLevelDivision(_divisionId, division, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, countryId);
            return divisionResult;
        }
        return null;
    }
    /**
     * @return [ObservableList] of FirstLevelDivision objects
     */
    public static ObservableList<FirstLevelDivision> getAllDivisions() throws SQLException {
        String sql = "SELECT * FROM first_level_divisions";
        ObservableList<FirstLevelDivision> divisions = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            int _divisionId = result.getInt("Division_ID");
            String division = result.getString("Division");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");
            int countryId = result.getInt("Country_ID");
            FirstLevelDivision divisionResult = new FirstLevelDivision(_divisionId, division, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, countryId);
            divisions.add(divisionResult);
        }
        return divisions;
    }


    /**
     *
     * @param countryId the countryId int value
     * @return the FirstLevelDivision object
     */
    public static ObservableList<FirstLevelDivision> getDivisionsByCountryID(int countryId) throws SQLException {
        String sql = "SELECT * FROM first_level_divisions WHERE Country_ID = " + countryId;
        ObservableList<FirstLevelDivision> divisions = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            int divisionId = result.getInt("Division_ID");
            String division = result.getString("Division");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");
            int _countryId = result.getInt("Country_ID");
            FirstLevelDivision divisionResult = new FirstLevelDivision(divisionId, division, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy, _countryId);
            divisions.add(divisionResult);
        }
        return divisions;
    }



}



