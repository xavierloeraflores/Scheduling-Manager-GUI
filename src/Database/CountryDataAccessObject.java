package Database;
import Models.Country;


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
public class CountryDataAccessObject {

    /**
     *
     * @param countryId the countryID int value
     * @return the Country object
     */
    public static Country getCountryByCountryID(int countryId) throws SQLException {
        String sql = "SELECT * FROM countries WHERE Country_ID = " + countryId;
        Country countryResult;
        ResultSet result = DAO.query(sql);
        while(result.next()){
            int _countryId = result.getInt("Country_ID");
            String country = result.getString("Country");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            countryResult = new Country(_countryId, country, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy);
            return countryResult;
        }
        return null;
    }

    /**
     * @return [ObservableList] of Country objects
     */

    public static ObservableList<Country> getAllCountries() throws SQLException {
        String sql = "SELECT * FROM countries";
        ObservableList<Country> countries = FXCollections.observableArrayList();
        ResultSet result = DAO.query(sql);
        while(result.next()){
            int _countryId = result.getInt("Country_ID");
            String country = result.getString("Country");
            Timestamp createDateTimestamp = result.getTimestamp("Create_Date");
            LocalDateTime createDateTime = createDateTimestamp.toLocalDateTime();
            String createdBy = result.getString("Created_By");
            Timestamp lastUpdateTimestamp = result.getTimestamp("Last_Update");
            LocalDateTime lastUpdateTime=lastUpdateTimestamp.toLocalDateTime();
            String lastUpdatedBy = result.getString("Last_Updated_By");

            Country countryResult = new Country(_countryId, country, createDateTime, createdBy, lastUpdateTime, lastUpdatedBy);
            countries.add(countryResult);
        }
        return countries;
    }



}



