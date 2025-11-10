import java.util.Scanner;
import java.util.Random;

public class RPSGame {
    private Player player;
    private NPC opponent;
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public NPC getOpponent() {
        return opponent;
    }
    public void setOpponent(NPC opponent) {
        this.opponent = opponent;
    }
    public RPSGame(Player player, NPC opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What is your choice?");
        String choice = scanner.nextLine();
        int counter = 1;
        while (validateChoice(player.getChoice()) == false || counter < 3) {
            counter += 1;
            System.out.println("That is not valid! Strike " + counter + "!");
            System.out.println("What is your choice?");
            choice = scanner.nextLine();
            setPlayerValues(name, choice);
        }
        scanner.close();
        if (counter == 3) {
            choice = generateRandomChoice();
        } else {
            setPlayerValues(name, choice);
        }
    }

    public void setPlayerValues(String name, String choice) {
        player.setName(name);
        player.setChoice(choice);
    }

    public boolean didPlayerWin() {
        if (this.player.getChoice().equals("rock")) {
            if (this.opponent.getChoice().equals("scissors")) {
                return true;
            } else {
                return false;
            }
        } else if (this.player.getChoice().equals("paper")) {
            if (this.opponent.getChoice().equals("rock")) {
                return true;
            } else {
                return false;
            }
        } else {
            if (this.opponent.getChoice().equals("paper")) {
                return true;
            } else {
                return false;
            }
        }
    }

    public String toString() {
        if (didPlayerWin() == true) {
            return (player.getName() + "won!\nCongratulations!");
        } else {
            return ("Opponent won!\nBetter luck next time!");
        }
    }

    public String displayResults() {
        return ("== GAME RESULTS ==\n" + player.getName() + "chose" +  player.getChoice() + ".\n"
                + "Opponent chose " + opponent.getChoice() + ".\n" + toString());
    }

    public static boolean validateChoice(String choice) {
        if (!choice.equals("rock") && !choice.equals("paper")
            && !choice.equals("scissors")) {
            return false;
        } else {
            return true;
        }
    }

    public static String generateRandomChoice() {
        Random random = new Random();
        int var = random.nextInt(1, 4);
        if (var == 1) {
            return "rock";
        } else if (var == 2) {
            return "paper";
        } else {
            return "scissors";
        }
    }
}
