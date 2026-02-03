import java.util.ArrayList;

public class TestResults {
    ArrayList<String> answerKey;
    ArrayList<StudentAnswerSheet> submissions;

    public ArrayList<String> getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(ArrayList<String> answerKey) {
        this.answerKey = answerKey;
    }

    public ArrayList<StudentAnswerSheet> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(ArrayList<StudentAnswerSheet> submissions) {
        this.submissions = submissions;
    }

    public TestResults(ArrayList<String> key, ArrayList<StudentAnswerSheet> submissions) {
        if (key == null || submissions == null) {
            throw new IllegalArgumentException();
        }
        this.answerKey = key;
        this.submissions = submissions;
    }

    public void submit(StudentAnswerSheet student) {
        submissions.add(student);
    }

    public void gradeTests() {
        for (StudentAnswerSheet student : submissions) {
            student.testScore = student.getGrade(answerKey);
        }
    }

    public String highestScoringStudent() {
        if (submissions.size() == 0) {
            return "";
        }
        StudentAnswerSheet output = submissions.get(0);
        for (StudentAnswerSheet student : submissions) {
            if (output.getTestScore() < student.getTestScore()) {
                output = student;
            }
        }
        return output.getName();
    }
}
