package lv.ctco.notepad;

/**
 * Created by yelena.kraveca on 11/16/2018.
 */
public class Person extends Record {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return firstName.contains(str)
                || lastName.contains(str)
                || email.contains(str)
                || phone.contains(str);
    }

    @Override
    public void askData() {
        firstName = Main.askString("First Name");
        lastName = Main.askString("Last Name");
        email = Main.askString("Email");
        phone = Main.askPhone("Phone");
    }
}
