package Models;

import java.time.LocalDateTime;

/**
 * A class representing the FirstLevelDivision object
 * @author xavierloeraflores
 */
public class FirstLevelDivision {
    private int divisionId;
    private String division;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;
    private int countryID;
    
    /**
     * Constructor method for the FirstLevelDivision object
     * @param divisionId the divisionId integer value to be set on the FirstLevelDivision object
     * @param division the division string value to be set on the FirstLevelDivision object
     * @param createDate the createDate LocalDateTime value to be set on the FirstLevelDivision object
     * @param createdBy the createdBy string value to be set on the FirstLevelDivision object
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the FirstLevelDivision object
     * @param lastUpdatedBy the  lastUpdatedBy string value to be set on the FirstLevelDivision object
     * @param countryID the countryId integer value to be set on the FirstLevelDivision object
     */
    public FirstLevelDivision(int divisionId, String division, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy, int countryID){
        this.divisionId=divisionId;
        this.division=division;
        this.createDate=createDate;
        this.createdBy=createdBy;
        this.lastUpdate=lastUpdate;
        this.lastUpdatedBy=lastUpdatedBy;
        this.countryID=countryID;
    }
    
    //Getters
    /**
     * @return the divisionId integer value on the FirstLevelDivision object
     */
    public int getDivisionId() {
        return this.divisionId;
    }

    /**
     * @return the division string value on the FirstLevelDivision object
     */
    public String getDivision() {
        return this.division;
    }

    /**
     * @return the createDate LocalDateTime value on the FirstLevelDivision object
     */
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    /**
     * @return the createdBy string value on the FirstLevelDivision object
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * @return the lastUpdate LocalDateTime value on the FirstLevelDivision object
     */
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     * @return the lastUpdatedBy string value on the FirstLevelDivision object
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * @return the countryId integer value on the FirstLevelDivision object
     */
    public int getCountryId() {
        return this.countryID;
    }



    //Setters
    /**
     * @param divisionId the divisionId integer value to be set on the FirstLevelDivision object
     */
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    /**
     * @param division the division string value to be set on the FirstLevelDivision object
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * @param createDate the createDate LocalDateTime value to be set on the FirstLevelDivision object
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * @param createdBy the createdBy string value to be set on the FirstLevelDivision object
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the FirstLevelDivision object
     */
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @param lastUpdatedBy the  lastUpdatedBy string value to be set on the FirstLevelDivision object
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @param countryID the countryId integer value to be set on the FirstLevelDivision object
     */
    public void setCountryId(int countryID) {
        this.countryID = countryID;
    }

    /**
     * @return Stringified division details
     */
    @Override
    public String toString(){return division;}
}