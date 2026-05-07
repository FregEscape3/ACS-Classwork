public class Cipher {

    public static String encode(String message) {
        if (message == null) {
            throw new IllegalArgumentException();
        }
        if (message.length() == 0) {
            return "";
        }
        String output = "";
        for (int i = 0; i < message.length(); i++) {
            char thing = message.charAt(i);
            thing = encodeChar(thing);
            output += thing;
        }
        return output;
    }

    private static char encodeChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('a' + (c - 'a' + 3) % 26);
        } else if (c >= 'A' && c <= 'Z') {
            return (char) ('A' + (c - 'A' + 3) % 26);
        }
        return c;
    }

    public static String decode(String encodedMessage) {
        if (encodedMessage == null) {
            throw new IllegalArgumentException();
        }
        if (encodedMessage.length() == 0) {
            return "";
        }
        String output = "";
        for (int i = 0; i < encodedMessage.length(); i++) {
            char thing = encodedMessage.charAt(i);
            thing = decodeChar(thing);
            output += thing;
        }
        return output;
    }

    private static char decodeChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('a' + (c - 'a' + 23) % 26);
        } else if (c >= 'A' && c <= 'Z') {
            return (char) ('A' + (c - 'A' + 23) % 26);
        }
        return c;
    }

    public static String compress(String message) {
        if (message == null) {
            throw new IllegalArgumentException();
        }
        if (message.length() == 0) {
            return "";
        }
        char temp = message.charAt(0);
        int count = 1;
        String output = "";
        for (int i = 1; i < message.length(); i++) {
            char thing = message.charAt(i);
            if (thing == temp) {
                count += 1;
            } else {
                output += temp;
                output += String.valueOf(count);
                temp = thing;
                count = 1;
            }
        }
        output += temp;
        if (count > 1) {
            output += String.valueOf(count);
        }
        return output;
    }

    public static String decompress(String compressedMessage) {
        if (compressedMessage == null) {
            throw new IllegalArgumentException();
        }
        if (compressedMessage.length() == 0) {
            return "";
        }
        String output = "";
        for (int i = 0; i < compressedMessage.length();) {
            char letter = compressedMessage.charAt(i);
            i++;
            if (i >= compressedMessage.length()) {
                output += letter;
                continue;
            }
            if (!Character.isDigit(compressedMessage.charAt(i))) {
                throw new IllegalArgumentException();
            }
            int count = 0;
            while (i < compressedMessage.length() && Character.isDigit(compressedMessage.charAt(i))) {
                count *= 10;
                count += Character.getNumericValue(compressedMessage.charAt(i));
                i++;
            }
            if (count == 0) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < count; j++) {
                output += letter;
            }
        }
        return output;
    }

}
