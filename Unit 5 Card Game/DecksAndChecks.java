import java.util.ArrayList;
import java.util.Scanner;

public class DecksAndChecks {

    // ----------------------------
    // CHECKERS (students implement)
    // ----------------------------

    // Rule: no single card may have more than 1 ability
    public static boolean checkOneAbilityPerCard(ArrayList<Card> deck) {
        for (Card card : deck) {
            if (card.abilityCount() > 1) {
                return false;
            }
        }
        return true;
    }

    // Rule: no more than 3 total ability cards in the deck
    public static boolean checkNoMoreThanThreeAbilityCards(ArrayList<Card> deck) {
        int sum = 0;
        for (Card card : deck) {
            if (card.hasBastion() == true || card.hasCleave() == true || card.hasRipple() == true) {
                sum++;
            }
        }
        if (sum > 3) {
            return false;
        }
        return true;
    }

    // Rule: no duplicate abilities in the deck (max one BASTION, one RIPPLE, one
    // CLEAVE)
    public static boolean checkNoDuplicateAbilities(ArrayList<Card> deck) {
        int thing = 0;
        int thing1 = 0;
        int thing2 = 0;
        for (Card card : deck) {
            if (card.hasBastion() == true) {
                thing++;
            }
            if (card.hasCleave() == true) {
                thing1++;
            }
            if (card.hasRipple() == true) {
                thing2++;
            }
        }
        if (thing > 1 || thing1 > 1 || thing2 > 1) {
            return false;
        }
        return true;
    }

    // Rule: strength and toughness must be 1..5, and strength+toughness <= 6
    public static boolean checkStatsInRange(ArrayList<Card> deck) {
        for (Card card : deck) {
            if (card.getStrength() > 5 || card.getToughness() > 5 || card.getStrength() < 1
                    || card.getToughness() < 1) {
                return false;
            }
        }
        for (Card card : deck) {
            if (card.getStrength() + card.getToughness() > 6) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDeck(ArrayList<Card> deck) {
        // TODO: return true only if:
        // - deck has size 5
        // - AND all checks return true
        if (deck.size() == 5 && checkOneAbilityPerCard(deck) == true && checkNoDuplicateAbilities(deck) == true
                && checkNoMoreThanThreeAbilityCards(deck) && checkStatsInRange(deck) == true) {
            return true;
        }
        return false;
    }

    // ----------------------------
    // DECK BUILDERS (students implement)
    // ----------------------------

    // Must create 5 cards, all 3/3, no abilities
    // If the user doesn't want to input a custom deck, this method should return
    // deck
    // of your choice for them to play with.
    public static ArrayList<Card> buildDefaultDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        NamedCard bums1 = new NamedCard("bums1", CardType.GRANITE, 3, 3, false, false, false);
        NamedCard bums2 = new NamedCard("bums2", CardType.GRANITE, 3, 3, false, false, false);
        NamedCard bums3 = new NamedCard("bums3", CardType.PARCHMENT, 3, 3, false, false, false);
        NamedCard bums4 = new NamedCard("bums4", CardType.PARCHMENT, 3, 3, false, false, false);
        NamedCard bums5 = new NamedCard("bums5", CardType.BLADE, 3, 3, false, false, false);
        deck.add(bums1);
        deck.add(bums2);
        deck.add(bums3);
        deck.add(bums4);
        deck.add(bums5);
        return deck;
    }

    // Prompts the user 5 times using Scanner and validates inputs.
    // Required prompt order per card:
    // name, type, strength, toughness, bastion(y/n), ripple(y/n), cleave(y/n)
    public static ArrayList<Card> buildUserDeck(Scanner sc) {
        ArrayList<Card> deck = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int thing = 0;
            int thing1 = 0;
            int thing2 = 0;
            String name = sc.nextLine();
            while (name.indexOf(" ") != -1) {
                System.out.println("Bum!");
                name = sc.nextLine();
            }
            String type = sc.nextLine();
            while (!type.toLowerCase().equals("granite") && !type.toLowerCase().equals("parchment")
                    && !type.toLowerCase().equals("blade")) {
                System.out.println("Bum!");
                type = sc.nextLine();
            }
            int strength = sc.nextInt();
            sc.nextLine();
            while (strength > 6 || strength < 1) {
                System.out.println("Bum!");
                strength = sc.nextInt();
                sc.nextLine();
            }
            int toughness = sc.nextInt();
            sc.nextLine();
            while (toughness > 6 || toughness < 1) {
                System.out.println("Bum!");
                toughness = sc.nextInt();
                sc.nextLine();
            }
            String bastion = sc.nextLine();
            while (!bastion.equals("y") && !bastion.equals("n")) {
                System.out.println("Bum!");
                bastion = sc.nextLine();
            }
            if (bastion.equals("y")) {
                thing++;
                while (thing > 1) {
                    System.out.println("Bum!");
                    bastion = sc.nextLine();
                    if (bastion.equals("n")) {
                        thing = 1;
                    }
                }
            }
            String ripple = sc.nextLine();
            while (!ripple.equals("y") && !ripple.equals("n")) {
                System.out.println("Bum!");
                ripple = sc.nextLine();
            }
            if (ripple.equals("y")) {
                thing1++;
                while (thing1 > 1) {
                    System.out.println("Bum!");
                    ripple = sc.nextLine();
                    if (ripple.equals("n")) {
                        thing1 = 1;
                    }
                }
            }
            String cleave = sc.nextLine();
            while (!cleave.equals("y") && !cleave.equals("n")) {
                System.out.println("Bum!");
                cleave = sc.nextLine();
            }
            if (cleave.equals("y")) {
                thing2++;
                while (thing2 > 1) {
                    System.out.println("Bum!");
                    cleave = sc.nextLine();
                    if (cleave.equals("n")) {
                        thing2 = 1;
                    }
                }
            }
            NamedCard bums = new NamedCard(name, CardType.fromText(type), strength, toughness, isYes(bastion),
                    isYes(ripple), isYes(cleave));
            deck.add(bums);
        }
        return deck;
    }

    // ----------------------------
    // Optional helpers you may use
    // ----------------------------

    public static boolean isYes(String s) {
        if (s == null)
            return false;
        s = s.trim().toLowerCase();
        return s.equals("y") || s.equals("yes");
    }
}
