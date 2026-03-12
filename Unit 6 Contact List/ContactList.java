import java.util.ArrayList;
import java.util.AbstractList;

public class ContactList extends AbstractList {

    // instance variable
    private ArrayList<String> contactList;

    // constructor
    // to-do: initializes an empty contact list
    public ContactList() {
        contactList = new ArrayList<String>();
    }

    // methods

    // to-do: findInsertLocation(String name)
    /**
     * returns the location in the contact list where the name should go to keep the
     * list
     * alphabetized
     */
    private int findInsertLocation(String name) {
        if (name.equals(null)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < contactList.size(); i++) {
            if (name.compareTo(contactList.get(i)) < 0) {
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
    public boolean add(String name) {
        if (name.equals(null)) {
            throw new IllegalArgumentException();
        }
        System.out.println("+ Adding " + name);
        for (String string : contactList) {
            if (string.equals(name)) {
                return false;
            }
        }
        int index = findInsertLocation(name);
        contactList.add(index, name);
        return true;
    }

    // to-do: add(ArrayList<String> names)
    /* this method adds a list of names to the contact list */
    public void add(ArrayList<String> names) {
        if (names.equals(null)) {
            throw new IllegalArgumentException();
        }
        for (String string : names) {
            add(string);
        }
    }

    // to-do: remove(String name)
    /** removes name from the contact list and keeps list alphabetized */
    public boolean remove(String name) {
        if (name.equals(null)) {
            throw new IllegalArgumentException();
        }
        System.out.println("- Removing " + name);
        for (String string : contactList) {
            if (name.equals(string)) {
                contactList.remove(string);
                return true;
            }
        }
        return false;
    }

    // to-do: remove(ArrayList<String> names)
    /* this method removes a list of names from the contact list */
    public void remove(ArrayList<String> names) {
        if (names.equals(null)) {
            throw new IllegalArgumentException();
        }
        for (String string : names) {
            remove(string);
        }
    }

    /** returns a String containing all of the words in list */
    public String toString() {
        return "Contact List: " + contactList.toString();
    }

    // to-do: get(int index)
    /** returns the name at the specified index */
    public String get(int index) {
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
        for (String string : contactList) {
            contactList.remove(string);
        }
    }

    public static void insertionSort(int[] nums) {
        for (int index = 1; index < nums.length; index++) {
            int key = nums[index];
            int position = index;
            while (position > 0 && nums[position - 1] > key) {
                nums[position] = nums[position - 1];
                position--;
            }
            nums[position] = key;
        }
    }
}