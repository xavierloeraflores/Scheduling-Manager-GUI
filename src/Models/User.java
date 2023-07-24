package Models;

import java.time.LocalDateTime;

/**
 * A class representing the User object
 * @author xavierloeraflores
 */
public class User {

    private int userId;
    private String username;
    private String password;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdateBy;

    /**
     * Constructor method for the User object
     * @param userId : the integer value of the userId to be set on the User object
     * @param username the username string value to be set on the User object
     * @param password the password string value to be set on the User object
     * @param createDate the createDate LocalDateTime value to be set on the User object
     * @param createdBy the createdBy string value to be set on the User object
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the User object
     * @param lastUpdateBy the lastUpdateBy string value to be set on the User object
     */
    public User(int userId, String username, String password, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdateBy) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
    }



    //Getters
    /**
     * @return userId integer value on the User object
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * @return the username stringValue on the User object
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return the password string value on the User object
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return the createDate LocalDateTime value on the User object
     */
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    /**
     * @return the createdBy string value on the User object
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * @return the lastUpdate LocalDateTime value on the User object
     */
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     * @return the lastUpdateBy string value on the User object
     */
    public String getLastUpdateBy() {
        return this.lastUpdateBy;
    }

    //Setters

    /**
     * @param userId : the integer value of the userId to be set on the User object
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }


    /**
     * @param username the username string value to be set on the User object
     */
    public void setUsername(String username) {
        this.username = username;
    }



    /**
     * @param password the password string value to be set on the User object
     */
    public void setPassword(String password) {
        this.password = password;
    }



    /**
     * @param createDate the createDate LocalDateTime value to be set on the User object
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }



    /**
     * @param createdBy the createdBy string value to be set on the User object
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }



    /**
     * @param lastUpdate the lastUpdate LocalDateTime value to be set on the User object
     */
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }



    /**
     * @param lastUpdateBy the lastUpdateBy string value to be set on the User object
     */
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    /**
     * @return Stringified user details
     */
    @Override
    public String toString(){return username;}
}