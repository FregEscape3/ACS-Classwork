import java.util.ArrayList;

public class Unit3Exercises {

    // Intended: return the average length of the strings in the array.
    public static double calculateAverageStringLength(String[] strs) {
        int sum = 0;
        int count = 0;
        if (strs == null) {
            return 0;
        } else {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] == null) {
                    count++;
                } else {
                    sum += strs[i].length();
                }
            }
            return sum / (strs.length - count);
        }
    }

    // Intended: produce a new string with the characters of the input reversed.
    public static String reverseString(String str) {
        String reversed = "";
        if (str == null) {
            return "";
        } else {
            for (int i = str.length() - 1; i > -1; i--) {
                reversed = reversed + str.charAt(i);
            }
            return reversed;
        }
    }

    public static int findMaxValue(int[] numbers) {
        if (numbers == null) {
            return 0;
        } else {
            int max = numbers[0];
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }
            return max;
        }
    }

    // Intended: check whether the input string reads the same forwards and
    // backwards.
    public static boolean isPalindrome(String str) {
        if (str == null || str == "") {
            return true;
        } else {
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                char a = str.charAt(left);
                char b = str.charAt(right);
                if (a != b) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    // Intended: sum only the even numbers in the array.
    public static int sumEvenNumbers(int[] numbers) {
        int sum = 0;
        if (numbers == null) {
            return 0;
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    sum += numbers[i];
                }
            }
            return sum;
        }
    }
}
