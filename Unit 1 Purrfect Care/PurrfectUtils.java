import java.util.Random;

public class PurrfectUtils {
    public static String determineCatMood(Cat cat) {
        if (cat.getMoodLevel() > 7) {
            return ("Currently, " + cat.getName() + " is in a great mood.\n"
                    + "Petting is appreciated.");
        } else if (cat.getMoodLevel() > 3) {
            return ("Currently, " + cat.getName() + " is reminiscing of a past life.\n"
                    + "Petting is acceptable.");
        } else {
            return ("Currently, " + cat.getName() + " is plotting revengeance.\n"
                    + "Petting is extremely risky.");
        }
    }

    public static char generateCatChar(String catId) {
        Integer sum = 0;
        String subCatId;
        for (int i = 0; i < catId.length(); i++) {
            subCatId = catId.substring(i, i + 1);
            Integer num = Integer.valueOf(subCatId);
            sum += num;
        }
        sum = sum % 26;
        return (char) ('A' + sum);
    }

    public static int generateRandomNumber (int low, int high) {
        int low1, high1;
        if (low > high) {
            low1 = high;
            high1 = low;
        } else {
            low1 = low;
            high1 = high;
        }
        Random rand = new Random();
        return (rand.nextInt(low1, high1));
    }

    public static String validateCatId(String catId) {
        Integer num = Integer.valueOf(catId);
        if (num < 1000 || num > 9999) {
            Random rand = new Random();
            num = rand.nextInt(1000, 10000);
            return(num.toString());
        } else {
            return catId;
        }
    }

    public static int validateMoodLevel(int moodLevel) {
        if (moodLevel > 10) {
            return 10;
        } else if (moodLevel < 0) {
            return 0;
        } else {
            return moodLevel;
        }
    }

    public static String bootUp(Cat cat) {
        return(cat.toString());
    }

    public static void pet(Cat cat) {
        System.out.println("Attempting to pet...");
        int moodLevel = cat.getMoodLevel();
        boolean isHungry = cat.isHungry();
        if (moodLevel >= 2) {
            moodLevel += 1;
            System.out.println("Petting successful!");
        } else if (isHungry = true) {
            moodLevel -= 1;
            System.out.println("Petting failed...");
        } else {
            moodLevel += 1;
            System.out.println("Petting successful!");
        }
        cat.setMoodLevel(moodLevel);
    }

    public static void trimClaws(Cat cat) {
        System.out.println("Attempting to trim claws...");
        int moodLevel = cat.getMoodLevel();
        Random rand = new Random();
        int random = rand.nextInt(1, 3);
        if (random == 1) {
            moodLevel -= 1;
            System.out.println(cat.getName() + " did not like that...");
        } else {
            moodLevel -= 2;
            System.out.println(cat.getName() + " really hated that!");
        }
        cat.setMoodLevel(moodLevel);
    }
}
