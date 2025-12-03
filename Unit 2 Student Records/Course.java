public class Course {
    // instance variables
    private String courseName;
    private StudentRecord[] enrolledStudents;
    private int maxEnrollment;

    // constructors
    public Course(String courseName, StudentRecord[] enrolledStudents) {
        this.courseName = courseName;
        this.enrolledStudents = enrolledStudents;
    }

    public Course(String courseName, int maxEnrollment) {
        this.courseName = courseName;
        this.maxEnrollment = maxEnrollment;
        this.enrolledStudents = new StudentRecord[maxEnrollment];
    }

    public boolean isFull() {
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void enrollStudent(StudentRecord student) {
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] == null) {
                enrolledStudents[i] = student;
                return;
            }
        }
    }

    public boolean dropStudent(StudentRecord student) {
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] != null 
                && enrolledStudents[i].getName().equals(student.getName())) {
                enrolledStudents[i] = null;
                return true;
            }
        }
        return false;
    }

    public int countEnrolledStudents() {
        int count = 0;
        for (int i = 0; i < enrolledStudents.length; i++) {
            if (enrolledStudents[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void increaseClassSizeBy(int sizeIncrease) {
        int count = 0;
        StudentRecord[] record1 = new StudentRecord[sizeIncrease + enrolledStudents.length];
        for (int i = 0; i < enrolledStudents.length; i++) {
            record1[i] = enrolledStudents[i];
        }
        enrolledStudents = record1;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public StudentRecord[] getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(StudentRecord[] enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String toString() {
        String output = "";
        output = output + "== " + courseName + " ==\n";
        for (int i = 0; i < enrolledStudents.length; i++) {
            output += ((i + 1) + ".) " + enrolledStudents[i].toString() + "\n");
        }
        return output;
    }

    public String findBestStudent() {
        String bestName = enrolledStudents[0].getName();
        for (int i = 0; i < enrolledStudents.length - 1; i++) {
            if (enrolledStudents[i].getFinalAverage() < enrolledStudents[i + 1].getFinalAverage()) {
                bestName = enrolledStudents[i + 1].getName();
            }
        }
        return bestName;
    }

    public double calculateTestAverage(int num) {
        double sum = 0;
        for (int i = 0; i < enrolledStudents.length; i++) {
            sum += enrolledStudents[i].getTestScore(num);
        }
        return (sum / enrolledStudents.length);
    }
}
