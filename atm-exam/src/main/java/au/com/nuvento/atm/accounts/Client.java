package au.com.nuvento.atm.accounts;

public class Client {

    // Initialization
    String FirstName;
    String Surname;
    String AccountOwnerID;


    // Getter and Setters
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getAccountOwnerID() {
        return AccountOwnerID;
    }

    public void setAccountOwnerID(String accountOwnerID) {
        AccountOwnerID = accountOwnerID;
    }


    // Main Function
    public Client(String firstName, String surname, String accountOwnerID) {
        FirstName = firstName;
        Surname = surname;
        AccountOwnerID = accountOwnerID;
    }

}
