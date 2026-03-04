// a class for all of the battle engine functions
// this class will be used to validate the type, element, weakness, health, and attack of the
// monsters
// there's also methods that will be used to calculate the damage and the health of the monsters
// and apply the type advantage multipliers

import java.util.ArrayList;
import java.util.Random;

public class BattleEngine {

    // to-do: validateStats
    // checks if the monster stats are valid
    // the total combined stats of the monster should not exceed 250
    public static boolean validateStats(Monster monster) {
        if (monster == null) {
            throw new IllegalArgumentException();
        }
        if (monster.getTotalStatSum() > 250) {
            return false;
        } else if (monster.health < 0 || monster.attack < 0 || monster.speed < 0 || monster.defense < 0) {
            return false;
        }
        return true;
    }

    // to-do: validateElement
    // checks if the monster element is valid
    // the only valid types allowed are "Fire", "Water", "Earth", and "Air"
    public static boolean validateElement(Monster monster) {
        if (monster.getElement() != ElementType.FIRE && monster.getElement() != ElementType.WATER
                && monster.getElement() != ElementType.EARTH && monster.getElement() != ElementType.AIR) {
            monster.element = ElementType.FIRE;
            return false;
        }
        return true;
    }

    // to-do: correctStats
    // checks if stats are invalid
    // fixes them so they are valid, however you choose
    public static void correctStats(Monster monster) {
        if (validateStats(monster) == false) {
            monster.setAttack(50);
            monster.setDefense(50);
            monster.setHealth(50);
            monster.setSpeed(50);
        }
    }

    // to-do: startBattle
    // each monster takes turn attacking the other until a monster's hp reaches 0.
    // It returns the
    // winning monster.
    public static Monster startBattle(Monster monster1, Monster monster2) {
        if (monster1 == null || monster2 == null) {
            return null;
        }
        Random rng = new Random();
        int flip = rng.nextInt(0, 2);
        boolean isMonster1Turn = true;
        boolean isMonster1Win = false;
        boolean isMonster2Win = false;
        if (flip == 0) {
            isMonster1Turn = false;
        }
        System.out.println(monster1.name + " wants to fight!\n" + monster2.name + " wants to fight!\n");
        displayStatus(monster1, monster2);
        while (!isMonster1Win && !isMonster2Win) {
            if (isMonster1Turn == true) {
                monster1.attack(monster2);
            } else {
                monster2.attack(monster1);
            }
            isMonster1Turn = !isMonster1Turn;
            displayStatus(monster1, monster2);
            if (monster1.health <= 0) {
                isMonster2Win = true;
                System.out.println(monster2.name + " wins!");
            } else if (monster2.health <= 0) {
                isMonster1Win = true;
                System.out.println(monster1.name + " wins!");
            }
        }
        if (isMonster1Win == true) {
            return monster1;
        } else {
            return monster2;
        }
    }

    // to-do: displayStatus
    // method prints out the current health of each monster.
    public static void displayStatus(Monster monster, Monster opponent) {
        if (monster.health <= 0 || opponent.health <= 0) {
            if (monster.health <= 0) {
                monster.health = 0;
            } else {
                opponent.health = 0;
            }
        }
        System.out.println(
                "" + monster.name + ": " + monster.health + " health vs "
                        + opponent.name + ": " + opponent.health + " health");
    }

}