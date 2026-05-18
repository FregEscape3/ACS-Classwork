public class MathNote extends Note {
    private int difficulty;

    public MathNote(String title, String topic, int unit, int difficulty) {
        super(title, topic, unit, 50);
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
