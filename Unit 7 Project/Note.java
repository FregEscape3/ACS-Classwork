import java.util.Random;

public class Note {
    private String title;
    private String topic;
    private int unit;
    private boolean isDone;
    private int priority;
    private int weight;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Note(String title, String topic, int unit) {
        this.title = title;
        this.topic = topic;
        this.unit = unit;
        this.isDone = false;
        Random rand = new Random();
        int rng = rand.nextInt(1, 51);
        this.weight = rng;
        this.priority = generatePriority();
    }

    public Note(String title, String topic, int unit, int weight) {
        this.title = title;
        this.topic = topic;
        this.unit = unit;
        this.isDone = false;
        this.weight = weight;
        this.priority = generatePriority();
    }

    public static String printTemplate() {
        return "This is a template for all of the notes pages.\n# Title\n## Subtopic 1\n## Subtopic 2\n...\n## Subtopic n"
                +
                "\n### Content\nBlah blah blah\nBoxes:\n\n<div class=\"theorem-box\" markdown=\"1\">\nProblem/example\n</div>"
                +
                "\n\nImages: <img class=\"note-img note-img--w480\" src=\"{{ '/assets/folderpath/picture.png' | relative_url }}\" alt=\"parent functions\" loading=\"lazy\" decoding=\"async\" />\n"
                +
                "## Problems\n## Solutions";
    }

    public int generatePriority() {
        return this.weight * (100 - this.unit) / 10;
    }
}
