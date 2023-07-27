package Models;

import java.time.LocalDateTime;

/**
 * A class representing the Customer object
 * @author xavierloeraflores
 */
public class Customer {
    private int customerId;
    private String customerName;
    private String address;
    private String postalCode;
    private String phone;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;
    private int divisionId;

    /**
     * Constructor method for the Customer object
     * @param customerId the customerId integer value to be set on the Customer object
     * @param customerName the customerName string value to be set on the Customer object
     * @param address the address string value to be set on the Customer object
     * @param postalCode the postalCode string value to be set on the Customer object
     * @param phone the phone string value to be set on the Customer object
     * @param createDate the createDate LocalDateTime value to be set on the Customer object
     * @param createdBy the createdBy string value to be set on the Customer object
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the Customer object
     * @param lastUpdatedBy the lastUpdatedBy string value to be set on the Customer object
     * @param divisionId the divisionId integer value to be set on the Customer object
     */
    public Customer(int customerId, String customerName, String address, String postalCode, String phone, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy, int divisionId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.divisionId = divisionId;
    }

    //Getters
    /**
     * @return the customerId integer value on the Customer object
     */
    public int getCustomerId() {
        return this.customerId;
    }

    /**
     * @return the customerName string value on the Customer object
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * @return the address string value on the Customer object
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @return the postalCode string value on the Customer object
     */
    public String getPostalCode() {
        return this.postalCode;
    }

    /**
     * @return the phone string value on the Customer object
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * @return the createDate LocalDateTime value on the Customer object
     */
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    /**
     * @return the createdBy string value on the Customer object
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * @return the lastUpdate LocalDateTime value on the Customer object
     */
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     * @return the lastUpdatedBy string value on the Customer object
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * @return the divisionId integer value on the Customer object
     */
    public int getDivisionId() {
        return this.divisionId;
    }


    //Setters
    /**
     * @param customerId the customerId integer value to be set on the Customer object
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }



    /**
     * @param customerName the customerName string value to be set on the Customer object
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }



    /**
     * @param address the address string value to be set on the Customer object
     */
    public void setAddress(String address) {
        this.address = address;
    }



    /**
     * @param postalCode the postalCode string value to be set on the Customer object
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }



    /**
     * @param phone the phone string value to be set on the Customer object
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     * @param createDate the createDate LocalDateTime value to be set on the Customer object
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }


    /**
     * @param createdBy the createdBy string value to be set on the Customer object
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }



    /**
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the Customer object
     */
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }



    /**
     * @param lastUpdatedBy the lastUpdatedBy string value to be set on the Customer object
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }


    /**
     * @param divisionId the divisionId integer value to be set on the Customer object
     */
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    /**
     * @return Stringified customer details
     */
    @Override
    public String toString(){return customerId + " : " + customerName;}
}