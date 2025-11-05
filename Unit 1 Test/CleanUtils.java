import java.util.Random;

public class CleanUtils {
    public static int validateCleanlinessLevel(int cleanlinesslevel) {
        if (cleanlinesslevel < 0) {
            cleanlinesslevel = 0;
            return cleanlinesslevel;
        } else if (cleanlinesslevel > 10) {
            cleanlinesslevel = 10;
            return cleanlinesslevel;
        } else {
            return cleanlinesslevel;
        }
    }

    public static String generateUsername(String name) { 
        int index1 = name.indexOf(' ');
        String firstName = name.substring(0, index1);
        String lastName = name.substring(index1 + 1, name.length());
        Random random = new Random();
        int randNum = random.nextInt(1950, 2050);
        return ("@" + firstName.toLowerCase() + "_" + lastName.toLowerCase() + "_" + randNum);
    }

    public static void cleanHome(Home home) {
        home.setCleanlinessLevel(home.getCleanlinessLevel() + 2);
    }

    public static String fixName(String name) {
        int output = 0;
        String newName = name.trim();
        int index1 = newName.indexOf(' ');
        String firstName = newName.substring(0, index1);
        while (output != -1) {
            output = newName.indexOf(' ');
            if (output != -1) {
                newName = newName.substring(output + 1);
            }
        }
        return(firstName + " " + newName);
    }
}
