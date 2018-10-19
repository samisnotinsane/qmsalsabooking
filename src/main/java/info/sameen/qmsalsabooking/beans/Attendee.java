package info.sameen.qmsalsabooking.beans;

/**
 * A person attending a class.
 * @author sameenislam
 * @version 1.0
 */
public class Attendee {

    private String firstName;
    private String surname;
    private String gender;
    private String email;
    private String password;

    public Attendee() {
    }

    public Attendee(String firstName, String surname, String gender, String email, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
