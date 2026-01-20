import java.util.ArrayList;

public class Unit4Exercises {

    // Method 1: matchingEndSequences
    public static boolean matchingEndSequences(int[] nums, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[nums.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Method 2: hasThreeConsecutive
    public static boolean hasThreeConsecutive(int[] nums) {
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2 && nums[i + 1] % 2 == nums[i + 2] % 2) {
                return true;
            }
        }
        return false;
    }

    // Method 3: generateNumberSequence
    public static int[] generateNumberSequence(int start, int end) {
        int[] bums = new int[end - start];
        for (int i = 0; i < bums.length; i++) {
            bums[i] = start + i;
        }
        return bums;
    }

    // Method 4: fizzBuzz
    public static String[] fizzBuzz(int start, int end) {
        String[] bum = new String[end - start];
        for (int i = 0; i < bum.length; i++) {
            bum[i] = "";
            if ((start + i) % 3 == 0) {
                bum[i] = bum[i] + "Fizz";
            }
            if ((start + i) % 5 == 0) {
                bum[i] = bum[i] + "Buzz";
            }
            if ((start + i) % 3 != 0 && (start + i) % 5 != 0) {
                bum[i] = bum[i] + (start + i);
            }
        }
        return bum;
    }

    // Method 5: moveEvenBeforeOdd
    public static int[] moveEvenBeforeOdd(int[] nums) {
        int count1 = 0;
        int[] bumss = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                bumss[count1] = nums[i];
                count1++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                bumss[count1] = nums[i];
                count1++;
            }
        }
        return bumss;
    }

    // ArrayList Methods

    // Method 1: noNegatives
    public static ArrayList<Integer> noNegatives(ArrayList<Integer> nums) {
        // to-do: implement the method
        return new ArrayList<>();

    }

    // Method 2: excludeTeenNumbers
    public static ArrayList<Integer> excludeTeenNumbers(ArrayList<Integer> nums) {
        // to-do: implement the method
        return new ArrayList<>();
    }

    // Method 3: appendY
    public static ArrayList<String> appendY(ArrayList<String> strs) {
        // to-do: implement the method
        return new ArrayList<>();
    }

    // Method 4: squarePlus10
    public static ArrayList<Integer> squarePlus10(ArrayList<Integer> nums) {
        // to-do: implement the method
        return new ArrayList<>();
    }

}