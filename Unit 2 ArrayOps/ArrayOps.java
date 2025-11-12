import java.util.ArrayList;

public class ArrayOps {
    public static String printStringArray(String [] input) {
        if (input == null) {
            return "[]";
        } else if (input.length == 0) {
            return "[]";
        }
        String output = "[";
        for (int i = 0; i < input.length; i++) {
            if (i != input.length - 1) {
                output = output + "" + input[i] + ", ";
            } else {
                output = output + "" + input[i] + "]";
            }
        }
        System.out.println(output);
        return output;
    }

    public static String printIntegerArray(int [] input) {
        String output = "[";
        for (int i = 0; i < input.length; i++) {
            if (i != input.length - 1) {
                output = output + "" + input[i] + ", ";
            } else {
                output = output + "" + input[i] + "]";
            }
        }
        System.out.println(output);
        return output;
    }

    public static int findMax(int [] input) {
        int output = input[0];
        for (int i = 0; i < input.length; i++) {
            if (input[i] > output) {
                output = input[i];
            } 
        }
        System.out.println(output);
        return output;
    }

    public static String findLongestString(String [] input) {
        if (input == null) {
            return "";
        }
        String output = input[0];
        for (int i = 0; i < input.length; i++) {
            if (input[i] != null) {
                if (input[i].length() > output.length()) {
                    output = input[i];
                }
            }
        }
        System.out.println(output);
        return output;
    }

    public static double averageStringLength(String [] input) {
        int freq = 0;
        if (input == null) {
            return 0;
        }
        double output = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != null) {
                output += input[i].length();            
            } else {
                freq += 1;
            }
        }
        if (input.length - freq == 0) {
            return 0;
        }
        double output1 = (double) (output / (input.length - freq));
        System.out.println(output1);
        return output1;
    }

    public static int[] countLetterFrequencies(String input) {
        if (input != null) {
            int [] freq = new int[26];
            for (int i = 0; i < input.length(); i++) {
                char ch = Character.toLowerCase(input.charAt(i));
                if (ch >= 'a' && ch <= 'z') {
                    freq[ch - 'a']++;
                }
            }
            return freq;
        } else {
            return new int[0];
        }
    }

    public static int[] removeIntAndScoot(int [] input, int index) {
        if (input == null) {
            return new int[0];
        }
        for (int i = index; i < input.length - 1; i++) {
            input[i] = input[i + 1];
        }
        input[input.length - 1] = 0;
        return input;
    }

    public static int[] resizeIntArray(int [] input) {
        if (input == null) {
            return new int[0];
        } else {
            int [] output = new int[input.length * 2];
            for (int i = 0; i < input.length; i++) {
                output[i] = input[i];
            }
            return output;
        }
    }

    public static String[] addNumToStringArray(String [] input) {
        if (input == null) {
            return new String[0];
        } else {
            String [] output = new String[input.length];
            for (int i = 0; i < input.length; i++) {
                if (input[i] != null) {
                    output[i] = ("#" + i + " " + input[i]);
                } else {
                    output[i] = null;
                }

            }
            return output;
        }
    }

    public static int[] reverseIntArray(int [] input) {
        if (input == null) {
            return new int[0];
        } else {
            int [] output = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                output[i] = input[input.length - i - 1];
            }
            return output;
        }
    }
}