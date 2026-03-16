import java.util.ArrayList;
import java.util.Collections;
import java.util.AbstractList;

public class ContactList extends AbstractList {

    // instance variable
    private ArrayList<Contact> contactList;

    // constructor
    // to-do: initializes an empty contact list
    public ContactList() {
        contactList = new ArrayList<Contact>();
    }

    // methods

    // to-do: findInsertLocation(String name)
    /**
     * returns the location in the contact list where the name should go to keep the
     * list
     * alphabetized
     */
    private int findInsertLocation(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < contactList.size(); i++) {
            if (contact.compareTo(contactList.get(i)) < 0) {
                return i;
            }
        }
        return contactList.size();
    }

    // to-do: add(String name)
    /**
     * adds a name to the contact list so that the list remains alphabetized, it
     * prints out which
     * name is being added, also the method prevents duplicate names from being
     * added
     */
    public boolean add(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException();
        }
        System.out.println("+ Adding " + contact.getFirstName());
        for (Contact thing : contactList) {
            if (thing.getTelephoneNumber().equals(contact.getTelephoneNumber())) {
                return false;
            }

            if (thing.getFirstName().equals(contact.getFirstName()) &&
                    thing.getLastName().equals(contact.getLastName()) &&
                    thing.getTelephoneNumber().equals(contact.getTelephoneNumber())) {
                return false;
            }
        }
        int index = findInsertLocation(contact);
        contactList.add(index, contact);
        return true;
    }

    // to-do: add(ArrayList<String> names)
    /* this method adds a list of names to the contact list */
    public void add(ArrayList<Contact> contactList) {
        if (contactList == null) {
            throw new IllegalArgumentException();
        }
        for (Contact contact : contactList) {
            add(contact);
        }
    }

    // to-do: remove(String name)
    /** removes name from the contact list and keeps list alphabetized */
    public boolean remove(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException();
        }
        System.out.println("- Removing " + contact.getFirstName());
        for (Contact thing : contactList) {
            if (contact.equals(thing)) {
                contactList.remove(thing);
                return true;
            }
        }
        return false;
    }

    // to-do: remove(ArrayList<String> names)
    /* this method removes a list of names from the contact list */
    public void remove(ArrayList<Contact> contactList) {
        if (contactList == null) {
            throw new IllegalArgumentException();
        }
        for (Contact contact : contactList) {
            remove(contact);
        }
    }

    /** returns a String containing all of the words in list */
    public String toString() {
        return "Contact List: " + contactList.toString();
    }

    // to-do: get(int index)
    /** returns the name at the specified index */
    public Contact get(int index) {
        if (index < 0 || index >= contactList.size()) {
            throw new IllegalArgumentException();
        }
        return contactList.get(index);
    }

    // to-do: size()
    /** returns the number of names in the contact list */
    public int size() {
        return contactList.size();
    }

    // to-do: clear()
    /** removes all names from the contact list */
    public void clear() {
        System.out.println("Clearing the contact list");
        for (Contact contact : contactList) {
            contactList.clear();
        }
    }

    public void sortByFirstName() {
        Collections.sort(contactList);
    }

    public void sortByLastName() {
        for (int i = 0; i < contactList.size() - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < contactList.size(); j++) {

                Contact current = contactList.get(j);
                Contact min = contactList.get(minIndex);

                int compareLast = current.getLastName().compareTo(min.getLastName());

                if (compareLast < 0 ||
                        (compareLast == 0 &&
                                current.getFirstName().compareTo(min.getFirstName()) < 0)
                        ||
                        (compareLast == 0 &&
                                current.getFirstName().equals(min.getFirstName()) &&
                                current.getTelephoneNumber().compareTo(min.getTelephoneNumber()) < 0)) {

                    minIndex = j;
                }
            }

            Contact temp = contactList.get(i);
            contactList.set(i, contactList.get(minIndex));
            contactList.set(minIndex, temp);
        }
    }

    public void sortByTelephoneNumber() {
        for (int index = 1; index < contactList.size(); index++) {

            Contact key = contactList.get(index);
            int position = index;

            while (position > 0 &&
                    contactList.get(position - 1).getTelephoneNumber()
                            .compareTo(key.getTelephoneNumber()) > 0) {

                contactList.set(position, contactList.get(position - 1));
                position--;
            }

            contactList.set(position, key);
        }
    }

    public Contact searchContacts(String telephoneNumber) {
        if (telephoneNumber.equals(null)) {
            throw new IllegalArgumentException();
        }
        for (Contact contact : contactList) {
            if (contact.getTelephoneNumber().equals(telephoneNumber)) {
                return contact;
            }
        }
        return null;
    }
}