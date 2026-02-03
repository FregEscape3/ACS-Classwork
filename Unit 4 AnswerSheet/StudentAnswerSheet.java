import java.util.ArrayList;

public class StudentAnswerSheet {
    String name;
    double testScore;
    ArrayList<String> answers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTestScore() {
        return testScore;
    }

    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public StudentAnswerSheet(String name, ArrayList<String> answers) {
        this.name = name;
        this.answers = answers;
        testScore = 0;
    }

    public double getGrade(ArrayList<String> key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < key.size(); i++) {
            if (answers.get(i) == null) {
                throw new IllegalArgumentException();
            }
            if (key.get(i).equals(answers.get(i))) {
                testScore++;
            } else if (answers.get(i).equals("?")) {
                testScore += 0;
            } else {
                testScore -= 0.25;
            }
        }
        return testScore;
    }
}
