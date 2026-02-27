import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardBattleGame {

    // TODO: Implement the full game.
    // Must print:
    // == CARD CLASH ==
    // Starting: Player/Bot
    // Winner: Player/Bot
    public static String playGame(ArrayList<Card> playerDeck, ArrayList<Card> botDeck, Random rng) {
        boolean isPlayerFirst = false;
        boolean isPlayerWin = false;
        boolean isBotWin = false;
        int flip = rng.nextInt(2);
        if (flip == 0) {
            isPlayerFirst = true;
        }
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();
        while (isPlayerWin == false || isBotWin == false) {
            PlayerState player = new PlayerState(name, playerDeck);
            PlayerState bot = new PlayerState(name, botDeck);
            if (isPlayerFirst == true) {
                drawAndPlayIfNeeded(player, bot);
            } else {
                drawAndPlayIfNeeded(bot, player);
            }
            if (player.hasAnythingLeft() == false) {
                isBotWin = true;
            } else if (bot.hasAnythingLeft() == false) {
                isPlayerWin = true;
            }
        }
        return null;
    }

    // ----- helpers you may implement or use -----

    // Draw top card if no active, apply on-play effects
    public static void drawAndPlayIfNeeded(PlayerState self, PlayerState other) {
        int index = 0;
        while (self.active == null) {
            self.active = self.deck.get(index);
            self.deck.set(index, null);
            index++;
        }
        if (other.active != null) {
            attackOnce(self, other);
        } else {
            if (self.active.hasRipple() == true) {
                other.pendingDamage++;
            }
        }
    }

    // One attack (self active attacks other active if both exist)
    public static void attackOnce(PlayerState attacker, PlayerState defender) {
        int damage = 0;
        if (attacker.active.hasRipple() == true) {
            damage++;
        } else if (attacker.active.hasCleave() == true) {
            damage+=2;
        }
        if (defender.active.isDefeated() == true) {
            defender.active = null;

        }
    }

    // Optional local run (not graded)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Card> player = DeckAndChecks.buildDefaultDeck();
        ArrayList<Card> bot = BotFactory.buildBotDeck();

        if (!DeckAndChecks.isValidDeck(player)) {
            System.out.println("Player deck invalid!");
            return;
        }

        playGame(player, bot, new Random());
    }
}
