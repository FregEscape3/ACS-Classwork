public class Player {
    private String choice;
    private String name;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return (name + " chose " + choice + ".");
    }
}
