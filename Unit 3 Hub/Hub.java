public class Hub {
    private Student[] students;
    private int studentCount;
    private Student loggedInStudent;

    public Hub() {
        this.students = new Student[10];
        this.studentCount = 0;
    }

    public Student registerStudent(String name, String password, String email) {
        requireNotBlank(name, "name");
        requireNotBlank(password, "password");
        requireEmail(email);
        rejectAt(name);
        ensureStudentDoesNotExist(name);
        ensureStudentCapacity();
        Student student = new Student(name, password, email);
        students[studentCount++] = student;
        return student;
    }

    public Student loginStudent(String username, String password) {
        requireNotBlank(username, "username");
        requireNotBlank(password, "password");
        int index = findStudentIndex(username);
        if (index < 0) {
            throw new IllegalStateException("Student not found: " + username);
        }
        if (!students[index].password.equals(password)) {
            throw new SecurityException("Wrong password.");
        }
        loggedInStudent = students[index];
        return loggedInStudent;
    }

    public void doesStudentExist(String displayName) {
        requireNotBlank(displayName, "displayName");
        if (findStudentIndex(displayName) >= 0) {
            throw new IllegalStateException("Student already exists.");
        }
    }

    private int findStudentIndex(String name) {
        if (students == null || studentCount < 0) {
            throw new IllegalStateException("Bad student storage.");
        }
        for (int i = 0; i < studentCount; i++) {
            if (students[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void ensureStudentDoesNotExist(String name) {
        if (findStudentIndex(name) >= 0) {
            throw new IllegalStateException("Display name taken.");
        }
    }

    private void ensureStudentCapacity() {
        if (students == null || studentCount < 0) {
            throw new IllegalStateException("Bad student storage.");
        }
        if (studentCount < students.length) {
            return;
        }
        Student[] bigger = new Student[students.length * 2];
        for (int i = 0; i < students.length; i++) {
            bigger[i] = students[i];
        }
        students = bigger;
    }

    private static void rejectAt(String s) {
        if (s.contains("@")) {
            throw new IllegalArgumentException("Name cannot include '@'.");
        }
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