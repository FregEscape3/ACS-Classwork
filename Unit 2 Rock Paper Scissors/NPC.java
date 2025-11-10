import java.util.Random;

public class NPC {
    private String choice;
    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        choice = choice.toLowerCase();
        if (RPSGame.validateChoice(choice) == true) {
            this.choice = choice;
        } else {
            this.choice = RPSGame.generateRandomChoice();
        }
    }

    public NPC() {
        this.choice = RPSGame.generateRandomChoice();
    }

    public String setChoice() {
        Random random = new Random();
        int var = random.nextInt(1, 4);
        if (var == 1) {
            this.choice = "rock";
            return "rock";
        } else if (var == 2) {
            this.choice = "paper";
            return "paper";
        } else {
            this.choice = "scissors";
            return "scissors";
        }
    }

    public String toString() {
        return ("Opponent chose " + this.choice + ".");
    }
}
