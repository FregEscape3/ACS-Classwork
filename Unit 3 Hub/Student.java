import java.util.Random;

public class Student {
    static String[] NAMES_IN_USE = new String[10];
    static int NAME_COUNT = 0;
    static final String CHARS = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz23456789!@#$";

    String name;
    String password;
    String email;
    Assignment[] assignments;
    int assignmentCount;

    public Student(String name, String password, String email) {
        requireNotBlank(name, "name");
        requireNotBlank(password, "password");
        requireEmail(email);
        if (name.contains("@")) {
            throw new IllegalArgumentException("Name cannot include '@'.");
        }
        if (nameExists(name)) {
            throw new IllegalStateException("Display name taken.");
        }
        addName(name);
        this.name = name;
        this.password = password;
        this.email = email;
        this.assignments = new Assignment[5];
        this.assignmentCount = 0;
    }

    public void changeName(String newDisplayName) {
        requireNotBlank(newDisplayName, "newDisplayName");
        if (newDisplayName.contains("@")) {
            throw new IllegalArgumentException("Name cannot include '@'.");
        }
        if (nameExists(newDisplayName)) {
            throw new IllegalStateException("Display name taken.");
        }
        replaceName(this.name, newDisplayName);
        this.name = newDisplayName;
    }

    public String resetPassword() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Student name missing.");
        }
        // Simple random password generator for demo purposes (no tester)
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            sb.append(CHARS.charAt(r.nextInt(CHARS.length())));
        }
        password = sb.toString();
        // Never triggerable because the password is always 12 characters long. (no
        // tester)
        if (password.length() < 8) {
            throw new IllegalStateException("Password generator failed.");
        }
        return password;
    }

    public Assignment submitAssignment(String title, String description) {
        if (assignments == null) {
            throw new IllegalStateException("Assignment storage missing.");
        }
        if (assignmentCount >= assignments.length) {
            throw new IllegalStateException("Assignment limit reached.");
        }
        requireNotBlank(title, "title");
        requireNotBlank(description, "description");
        assignments[assignmentCount] = new Assignment(title, description);
        return assignments[assignmentCount++];
    } // (no tester)
    
    private static boolean nameExists(String name) {
        for (int i = 0; i < NAME_COUNT; i++) {
            if (NAMES_IN_USE[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void addName(String name) {
        ensureNameCapacity();
        NAMES_IN_USE[NAME_COUNT++] = name;
    }

    private static void replaceName(String oldName, String newName) {
        for (int i = 0; i < NAME_COUNT; i++) {
            if (NAMES_IN_USE[i].equals(oldName)) {
                NAMES_IN_USE[i] = newName;
                return;
            }
        }
        addName(newName);
    }

    private static void ensureNameCapacity() {
        if (NAME_COUNT < NAMES_IN_USE.length) {
            return;
        }
        String[] bigger = new String[NAMES_IN_USE.length * 2];
        for (int i = 0; i < NAMES_IN_USE.length; i++) {
            bigger[i] = NAMES_IN_USE[i];
        }
        NAMES_IN_USE = bigger;
    }

    private static void requireNotBlank(String s, String field) {
        if (s == null) {
            throw new IllegalArgumentException(field + " is null.");
        }
        if (s.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " is blank.");
        }
    }

    private static void requireEmail(String email) {
        requireNotBlank(email, "email");
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email.");
        }
    }
}