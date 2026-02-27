import java.util.ArrayList;
import java.util.Random;

public class CardBattleGame {

    // TODO: Implement the full game.
    // Must print:
    // == CARD CLASH ==
    // Starting: Player/Bot
    // Winner: Player/Bot
    public static String playGame(ArrayList<Card> playerDeck, ArrayList<Card> botDeck, Random rng) {
        boolean isPlayerFirst = (rng.nextInt(2) == 0);

        PlayerState player = new PlayerState("Player", playerDeck);
        PlayerState bot = new PlayerState("Clanker", botDeck);

        boolean playerTurn = isPlayerFirst;

        while (player.hasAnythingLeft() && bot.hasAnythingLeft()) {
            if (playerTurn == true) {
                takeTurn(player, bot);
            } else {
                takeTurn(bot, player);
            }
            playerTurn = !playerTurn;
        }

        String start = isPlayerFirst ? "Player" : "Bot";
        String win = player.hasAnythingLeft() ? "Player" : "Bot";

        // return "== CARD CLASH ==\n" + "Starting: " + start + "\n" + "Winner: " + win;
        return win;
    }

    // ----- helpers you may implement or use -----

    private static void takeTurn(PlayerState current, PlayerState other) {
        drawAndPlayIfNeeded(current, other);

        // If both players have active cards after drawing/on-play effects, attack once.
        if (current.active != null && other.active != null) {
            attackOnce(current, other);
            if (other.active != null && other.active.isDefeated()) {
                other.active = null;
            }
        }
    }

    // Draw top card if no active, apply on-play effects
    public static void drawAndPlayIfNeeded(PlayerState self, PlayerState other) {
        if (self == null || other == null)
            return;

        // If we have no active card, draw the "top" card (index 0).
        if (self.active == null) {
            if (self.deck == null || self.deck.isEmpty())
                return;

            self.active = self.deck.remove(0);
            if (self.active == null)
                return;

            // Apply any stored pending damage (from opponent RIPPLE while we had no
            // active).
            if (self.pendingDamage > 0) {
                self.active.takeDamage(self.pendingDamage);
                self.pendingDamage = 0;
                if (self.active.isDefeated()) {
                    self.active = null;
                    return;
                }
            }

            // Apply on-play self-buffs.
            Ability a = self.active.resolvedAbility();
            self.active.applySelfOnPlay(a);

            // Apply on-play ping damage (RIPPLE). If opponent has no active, it becomes
            // pending.
            int ping = a.pingDamageOnPlay();
            if (ping > 0) {
                if (other.active != null) {
                    other.active.takeDamage(ping);
                    if (other.active.isDefeated())
                        other.active = null;
                } else {
                    other.pendingDamage += ping;
                }
            }

            // If the ability cycles, move the card to the bottom immediately.
            if (a.cyclesOnPlay()) {
                self.deck.add(self.active);
                self.active = null;
            }
        }
    }

    // One attack (self active attacks other active if both exist)
    public static void attackOnce(PlayerState attacker, PlayerState defender) {
        if (attacker == null || defender == null)
            return;
        if (attacker.active == null || defender.active == null)
            return;

        defender.active.takeDamage(attacker.active.computeDamageAgainst(defender.active));
    }

    // Optional local run (not graded)
    public static void main(String[] args) {
        ArrayList<Card> player = DecksAndChecks.buildDefaultDeck();
        ArrayList<Card> bot = BotFactory.buildBotDeck();

        if (!DecksAndChecks.isValidDeck(player)) {
            System.out.println("Player deck invalid!");
            return;
        }

        playGame(player, bot, new Random());
    }
}