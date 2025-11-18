public class StudentRecord {
    // instance variables
    private String name;
    private int[] scores;

    // constructors
    public StudentRecord(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public String toString() {
        String thing = "[";
        for (int i = 0; i < scores.length; i++) {
            thing = thing + scores[i] + "";
            if (i != scores.length - 1) {
                thing = thing + ", ";
            }
        }
        return (name + "'s scores: " + thing + "]");
    }

    public boolean equals(StudentRecord other) {
        if (other.toString().equals(this.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public double getAverage(int first, int last) {
        double sum = 0;
        if (first == last) {
            return 0;
        }
        for (int i = first; i < last; i++) {
            sum += scores[i];
        }
        return (sum / (last - first));
    }

    public int getTestScore(int testNumber) {
        if (testNumber < 0 || testNumber > scores.length - 1) {
            return -1;
        } else {
            return scores[testNumber];
        }
    }

    public boolean hasImproved() {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public double getFinalAverage() {
        if (this.hasImproved() == true) {
            return this.getAverage((int) (scores.length / 2), scores.length);
        } else {
            return this.getAverage(0, scores.length);
        }
    }

}
