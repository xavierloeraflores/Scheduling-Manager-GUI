package Models;

import java.time.LocalDateTime;
/**
 * A class representing the country object
 * @author xavierloeraflores
 */
public class Country {
    private int countryId;
    private String country;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;

    /**
     * Constructor method for the Contact object
     * @param countryId the countryId integer value to be set on the Country object
     * @param country the country string value to be set on the Country object
     * @param createDate the createDate LocalDateTime value to be set on the Country object
     * @param createdBy the createdBy string value to be set on the Country object
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the Country object
     * @param lastUpdatedBy the lastUpdatedBy string value to be set on the Country object
     */
    public Country(int countryId, String country, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy){
        this.countryId = countryId;
        this.country = country;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }
    //Setters
    /**
     * @return the countryId integer value on the Country object
     */
    public int getCountryId() {
        return this.countryId;
    }

    /**
     * @return the country string value on the Country object
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * @return the createDate LocalDateTime value on the Country object
     */
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    /**
     * @return the createdBy string value on the Country object
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * @return the lastUpdate LocalDateTime value on the Country object
     */
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     * @return the lastUpdatedBy string value on the Country object
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }


    //Setters
    /**
     * @param countryId the countryId integer value to be set on the Country object
     */
    public void setCountryId(int countryId) {
       this.countryId = countryId;
    }

    /**
     * @param country the country string value to be set on the Country object
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @param createDate the createDate LocalDateTime value to be set on the Country object
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * @param createdBy the createdBy string value to be set on the Country object
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the Country object
     */
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @param lastUpdatedBy the lastUpdatedBy string value to be set on the Country object
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
