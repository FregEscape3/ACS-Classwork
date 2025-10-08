import java.util.Random;

public class PawesomeUtils {
    public static char generateDogChar(int dogId) {
        char dogChar = (char) ('F' + (dogId / 100 + (dogId - dogId / 100) / 10 + dogId % 10) % 10);
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
 }
