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

    public static int calculateSumOfSquares(int[] numbers) {
        if (numbers == null) {
            throw new NullPointerException("Your trash cuz ur null");
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Math.pow(numbers[i], 2);
        }
        return sum;
    }

    public static int getNthFibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Your a bum cuz ur negative");
        }
        if (n == 1) {
            return n;
        }
        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void sortArrayDescending(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("You are a bum cuz you are null");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("{ ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + " }");
    }

    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence == "") {
            throw new NullPointerException("ts is empty/null");
        }
        String[] words = sentence.split(" ");
        String longestWord = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }
        return longestWord;
    }

    public static double calculateInterest(double principal, double rate, int years) {
        if (principal < 0 || rate < 0 || years <= 0) {
            throw new IllegalArgumentException("negative numbers are NOT allowed");
        }
        for (int i = 0; i < years; i++) {
            principal += principal * (rate / 100);
        }
        return principal;
    }

    public static int parsePositiveInteger(String str) {
        int number = Integer.parseInt(str);
        if (number < 0) {
            try {
                str = "false string";
                number = Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println(e);
                return 1;
            }
        }
        return number; // Method should return 1 if it's negative
    }

    public static String getArrayElement(String[] arr, int index) {
        try {
            String temp = arr[index];
        } catch (Exception e) {
            System.out.println(e + "; Null array bruzz");
            return null;
        }
        return arr[index];
    }

    public static double calculateSquareRoot(int number) {
        try {
            Math.sqrt(number);
        } catch (Exception e) {
            System.out.println(e + "; Negative number bro");
            return Double.NaN;
        }
        return Math.sqrt(number);
    }

    public static int sumArrayElements(int[] array) {
        int sum = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
        } catch (Exception e) {
            System.out.println(e + "; You are very null");
            return 0;
        }
        return sum;
    }

    public static double calculatePower(double base, int exponent) {
        try {
            Math.pow(base, exponent);
        } catch (Exception e) {
            System.out.println(e + "; Negative exponent bro");
            return 1;
        }
        return Math.pow(base, exponent);
    }
}
