import java.util.Comparator;

public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String telephoneNumber;

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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Contact(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (telephoneNumber.length() != 12) {
            throw new IllegalArgumentException();
        }
        this.telephoneNumber = telephoneNumber;
    }

    public int compareTo(Contact other) {
        int firstCompare = this.firstName.compareTo(other.firstName);
        if (firstCompare != 0) {
            return firstCompare;
        }

        int lastCompare = this.lastName.compareTo(other.lastName);
        if (lastCompare != 0) {
            return lastCompare;
        }

        return this.telephoneNumber.compareTo(other.telephoneNumber);
    }

    public String toString() {
        return ("Name: " + firstName + " " + lastName + "\nPhone number: " + telephoneNumber);
    }
}
