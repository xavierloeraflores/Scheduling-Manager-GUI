package Models;

/**
 * A class representing the Contact object
 * @author xavierloeraflores
 */
public class Contact {
    private int contactId;
    private String contactName;
    private String email;
    /**
     * Constructor method for the Contact object
     * @param contactId the contactId integer value to be set on the Contact object
     * @param contactName the contactName string value to be set on the Contact object
     * @param email the email string value to be set on the Contact object
     */
    public Contact(int contactId, String contactName, String email) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.email = email;
    }
    //Getters
    /**
     * @return the contactId integer value on the Contact object
     */
    public int getContactId() {
        return this.contactId;
    }

    /**
     * @return the contactName string value on the Contact object
     */
    public String getContactName() {
        return this.contactName;
    }

    /**
     * @return the email string value on the Contact object
     */
    public String getEmail() {
        return this.email;
    }

    //Setters
    /**
     * @param contactId the contactId integer value to be set on the Contact object
     */
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }


    /**
     * @param contactName the contactName string value to be set on the Contact object
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }



    /**
     * @param email the email string value to be set on the Contact object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Stringified contact details
     */
    @Override
    public String toString(){return contactId + " : " + contactName;}

}