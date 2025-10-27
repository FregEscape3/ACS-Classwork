import java.util.Random;

public class PawesomeUtils {
    public static char generateDogChar(int dogId) {
        int hundDig = (dogId - dogId % 100) / 100;
        int tensDig = (dogId % 100 - dogId % 10) / 10;
        int onesDig = dogId % 10;
        char dogChar = (char) ('F' + ((hundDig + tensDig + onesDig) % 10));
        return dogChar;
    }

    public static String generateDogTag(int dogId, char dogChar) {
        String dogTag = (dogId + "" + dogChar);
        return dogTag;
    }

    public static int validateDogId(int dogId) {
        if (99 < dogId && dogId < 1000) {
            return dogId;
        } else {
            Random rand = new Random();
            dogId = rand.nextInt(100, 1000);
            return dogId;
        }
    }

    public static boolean validateDogTag(Dog dog) {
        int newDogId = dog.getDogId();
        newDogId = validateDogId(newDogId);
        char newDogChar = generateDogChar(newDogId);
        String newDogTag = (newDogId + "" + newDogChar);
        if (newDogTag.equals(dog.getDogTag())) {
            return true;
        } else {
            return false;
        }
    }

    public static int convertAgeToHumanAge(Dog dog) {
        if (dog.getAge() > 2) {
            return (24 + (dog.getAge() - 2) * 5);
        } else if (dog.getAge() == 2) {
            return 24;
        } else if (dog.getAge() == 1) {
            return 15;
        } else {
            return -1;
        }
    }

    public static int convertAgeToDogYears(int humanYears) {
        if (humanYears > 24) {
            return ((humanYears - 24) / 5 + 2);
        } else if (15 <= humanYears && humanYears <= 24) {
            return 2;
        } else {
            return 1;
        }
    }
}
