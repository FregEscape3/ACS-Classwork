public class Course {
    // instance variables
    private String courseName;
    private StudentRecord[] enrolledStudents;

    // constructors
    public Course(String courseName, StudentRecord[] enrolledStudents) {
        this.courseName = courseName;
        this.enrolledStudents = enrolledStudents;
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
