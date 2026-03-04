import java.util.Random;

public interface ElementalAttacks {

    // to-do: Implement the attack method for ElementalAttacks
    // Every monster has 2 different attacks, each with different name and type
    // Base damage is based on the monster's attack
    // There is a 45% chance the monster should use AttackOne
    // There is a 45% chance the monster should use AttackTwo
    // There is a 10% chance the monster doubles down and uses BOTH attacks with
    // doubleDown Attack
    // - The double down attack is only available once per battle.
    // - After using double down, the attack probability is 50% / 50% for Attacks
    // 1/2
    default void attack(Monster opponent) {
        Monster thisMonster = thisMonster();
        Random rng = new Random();
        int prob = rng.nextInt(101);
        if (thisMonster.hasUsedDoubleDown()) {
            if (prob < 10) {
                performDoubleDownAttack(opponent);
            } else if (prob < 55) {
                performSingleElementalAttack(1, opponent);
            } else {
                performSingleElementalAttack(2, opponent);
            }
        } else {
            if (prob < 50) {
                performSingleElementalAttack(1, opponent);
            } else {
                performSingleElementalAttack(2, opponent);
            }
        }
        // implement this method here
    }

    // to-do: Implement the attack method for performSingleElementalAttack
    // The current moster attacks the opponent using the attackNumber provided
    // Inputs:
    // attackNumber: either 1 or 2
    // opponent: the opposing Monster to attack
    default void performSingleElementalAttack(int attackNumber, Monster opponent) {
        Monster thisMonster = thisMonster();
        String attackName;
        ElementType attackElement;
        if (attackNumber == 1) {
            attackName = thisMonster.attackNameOne;
            attackElement = thisMonster.attackElementOne;
        } else {
            attackName = thisMonster.attackNameTwo;
            attackElement = thisMonster.attackElementTwo;
        }
        double STAB = 1;
        if (attackElement == thisMonster.element) {
            STAB = 1.5;
        }
        double critMultiplier = 1;
        if (didAttackCrit(thisMonster.speed)) {
            critMultiplier = 2;
        }
        double damage = 10 * thisMonster.attack * STAB * critMultiplier
                * getElementalMultiplier(attackElement, opponent.element) / (opponent.defense);
        opponent.health -= damage;
        System.out.println(thisMonster.name + " used " + attackName + "!\n");
        if (getElementalMultiplier(attackElement, opponent.element) == 2) {
            System.out.println("It was super effective!\n");
        } else if (getElementalMultiplier(attackElement, opponent.element) == 0.5) {
            System.out.println("It was not very effective...\n");
        }
        if (critMultiplier == 2) {
            System.out.println("It was a critical hit!\n");
        }
        // implement this method here
    }

    // to-do: Implement the useDoubleDown() method for the monster
    // This method is called when the monster uses their double down attack.
    // The double down attack is only available once per battle
    // If the monster has already used their double down attack, print a message
    // saying so and
    // return. The
    // monster effectively loses their turn.
    default void performDoubleDownAttack(Monster opponent) {
        Monster thisMonster = thisMonster();
        if (thisMonster.hasUsedDoubleDown) {
            System.out.println("You have already used your double down ability.");
            return;
        } else {
            thisMonster.hasUsedDoubleDown = true;
            ElementType attackElement1;
            ElementType attackElement2;
            attackElement1 = thisMonster.attackElementOne;
            attackElement2 = thisMonster.attackElementTwo;
            double STAB = 1;
            if (attackElement1 == thisMonster.element) {
                STAB = 1.5;
            }
            double critMultiplier = 1;
            if (didAttackCrit(thisMonster.speed)) {
                critMultiplier = 2;
            }
            double damage = 10 * thisMonster.attack * STAB * critMultiplier
                    * getElementalMultiplier(attackElement1, opponent.element) / (opponent.defense);
            opponent.health -= damage;
            double STAB1 = 1;
            if (attackElement1 == thisMonster.element) {
                STAB1 = 1.5;
            }
            double critMultiplier1 = 1;
            if (didAttackCrit(thisMonster.speed)) {
                critMultiplier1 = 2;
            }
            double damage1 = 10 * thisMonster.attack * STAB1 * critMultiplier1
                    * getElementalMultiplier(attackElement2, opponent.element) / (opponent.defense);
            opponent.health -= damage1;
            System.out.println(thisMonster.name + " used Double Down!\n");
            if (getElementalMultiplier(attackElement1, opponent.element) == 2) {
                System.out.println("It was super effective!\n");
            } else if (getElementalMultiplier(attackElement1, opponent.element) == 0.5) {
                System.out.println("It was not very effective...\n");
            }
            if (getElementalMultiplier(attackElement2, opponent.element) == 2) {
                System.out.println("It was super effective!\n");
            } else if (getElementalMultiplier(attackElement2, opponent.element) == 0.5) {
                System.out.println("It was not very effective...\n");
            }
            if (critMultiplier == 2) {
                System.out.println("It was a critical hit!\n");
            }
            if (critMultiplier == 2) {
                System.out.println("It was a critical hit!\n");
            }
            // implement this method here
        }
    }

    /**
     * didAttackCrit
     * returns a boolean if an attack critically struck based on the speed of the
     * attacking monster
     */
    public static boolean didAttackCrit(int speed) {
        if (speed <= 0)
            return false;
        if (speed >= 250)
            return true;
        return Math.random() < (speed / 250.0);
    }

    /**
     * Returns true if attackType is super effective against defenderType.
     * Fire->Air, Air->Earth, Earth->Water, Water->Fire
     */
    static boolean isSuperEffectiveAgainst(ElementType attackType, ElementType defenderType) {
        if (attackType == null || defenderType == null)
            return false;
        return (attackType == ElementType.FIRE && defenderType == ElementType.AIR)
                || (attackType == ElementType.AIR && defenderType == ElementType.EARTH)
                || (attackType == ElementType.EARTH && defenderType == ElementType.WATER)
                || (attackType == ElementType.WATER && defenderType == ElementType.FIRE);
    }

    /**
     * Returns the effectiveness multiplier: 2.0 (super), 1.0 (normal), or 0.5
     * (low).
     */
    static double getElementalMultiplier(ElementType attackType, ElementType defenderType) {
        if (attackType == null || defenderType == null)
            return 1.0;
        if (isSuperEffectiveAgainst(attackType, defenderType))
            return 2.0;
        if ((attackType == ElementType.FIRE && (defenderType == ElementType.WATER || defenderType == ElementType.FIRE))
                || (attackType == ElementType.WATER
                        && (defenderType == ElementType.EARTH || defenderType == ElementType.WATER))
                || (attackType == ElementType.EARTH
                        && (defenderType == ElementType.AIR || defenderType == ElementType.EARTH))
                || (attackType == ElementType.AIR
                        && (defenderType == ElementType.FIRE || defenderType == ElementType.AIR)))
            return 0.5;
        return 1.0;
    }

    // Using this to get the Monster.
    // You can use: (Monster) this
    // or: Monster thisMonster = thisMonster();
    private Monster thisMonster() {
        if (!(this instanceof Monster)) {
            throw new IllegalStateException("ElementalAttack implementations must be Monsters");
        }
        return (Monster) this;
    }
}
