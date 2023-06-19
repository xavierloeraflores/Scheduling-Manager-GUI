package Models;

import java.time.LocalDateTime;

/**
 * A class representing the Appointment object
 * @author xavierloeraflores
 */
public class Appointment {
    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;
    private int customerId;
    private int userId;
    private int contactId;

    /**
     * Constructor method for the Appointment object
     * @param appointmentId the appointmentId integer value to be set on the Appointment object
     * @param title the title string value to be set on the Appointment object
     * @param description the description string value to be set on the Appointment object
     * @param location the location string value to be set on the Appointment object
     * @param type the type string value to be set on the Appointment object
     * @param start the start LocalDateTime value to be set on the Appointment object
     * @param end the end LocalDateTime value to be set on the Appointment object
     * @param createDate the createDate LocalDateTime value to be set on the Appointment object
     * @param createdBy the createdBy string value to be set on the Appointment object
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the Appointment object
     * @param lastUpdatedBy the lastUpdatedBy string value to be set on the Appointment object
     * @param customerId the customerId integer value to be set on the Appointment object
     * @param userId the userId integer value to be set on the Appointment object
     * @param contactId the contactId integer value to be set on the Appointment object
     */
    public Appointment(int appointmentId, String title, String description, String location, String type, LocalDateTime start, LocalDateTime end, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy, int customerId, int userId, int contactId) {
        this.appointmentId = appointmentId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.customerId = customerId;
        this.userId = userId;
        this.contactId = contactId;
    }

    //Getters

    /**
     * @return the appointmentId integer value on the Appointment object
     */
    public int getAppointmentId() {
        return this.appointmentId;
    }

    /**
     * @return the title string value on the Appointment object
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return the description string value on the Appointment object
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return the location string value on the Appointment object
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * @return the type string value on the Appointment object
     */
    public String getType() {
        return this.type;
    }

    /**
     * @return the start LocalDateTime value on the Appointment object
     */
    public LocalDateTime getStart() {
        return this.start;
    }

    /**
     * @return the end LocalDateTime value on the Appointment object
     */
    public LocalDateTime getEnd() {
        return this.end;
    }

    /**
     * @return the createDate LocalDateTime value on the Appointment object
     */
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    /**
     * @return the createdBy string value on the Appointment object
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * @return the lastUpdate LocalDateTime value on the Appointment object
     */
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     * @return the lastUpdatedBy string value on the Appointment object
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    /**
     * @return the customerId integer value on the Appointment object
     */
    public int getCustomerId() {
        return this.customerId;
    }

    /**
     * @return the userId integer value on the Appointment object
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * @return the contactId integer value on the Appointment object
     */
    public int getContactId() {
        return this.contactId;
    }


    //Setters

    /**
     * @param appointmentId the appointmentId integer value to be set on the Appointment object
     */
    public void setAppointmentId(int appointmentId) {
        this. appointmentId = appointmentId;
    }

    /**
     * @param title the title string value to be set on the Appointment object
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param description the description string value to be set on the Appointment object
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param location the location string value to be set on the Appointment object
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @param type the type string value to be set on the Appointment object
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param start the start LocalDateTime value to be set on the Appointment object
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * @param end the end LocalDateTime value to be set on the Appointment object
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
     * @param createDate the createDate LocalDateTime value to be set on the Appointment object
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * @param createdBy the createdBy string value to be set on the Appointment object
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the Appointment object
     */
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @param lastUpdatedBy the lastUpdatedBy string value to be set on the Appointment object
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @param customerId the customerId integer value to be set on the Appointment object
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * @param userId the userId integer value to be set on the Appointment object
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @param contactId the contactId integer value to be set on the Appointment object
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

}