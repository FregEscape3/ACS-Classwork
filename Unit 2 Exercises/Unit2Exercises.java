import java.util.ArrayList;

public class Unit2Exercises {
    public static String alarmClock(int day, boolean vacation) {
        if (day == 6 || day == 0) {
            if (vacation == true) {
                return "off";
            } else {
                return "10:00";
            }
        } else {
            if (vacation == true) {
                return "10:00";
            } else {
                return "7:00";
            }
        }
    }

    public static boolean love6(int a, int b) {
        if (a == 6 || b == 6) {
            return true;
        } else if (a + b == 6) {
            return true;
        } else if (a - b == 6 || b - a == 6) {
            return true;
        }
        return false;
    }

    public static int redTicket(int a, int b, int c) {
        if (a == 2 && b == 2 && c == 2) {
            return 10;
        } else if (a == b && b == c) {
            return 5;
        } else if (c != a && b != a) {
            return 1;
        }
        return 0;
    }

    public static String fizzString(String str) {
        if (str.startsWith("f") && str.endsWith("b")) {
            return "FizzBuzz";
        } else if (str.startsWith("f")) {
            return "Fizz";
        } else if (str.endsWith("b")) {
            return "Buzz";
        } else {
            return str;
        }
    }

    public static String doubleChar(String str) {
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            word = word + character + "" + character;
        }
        return word;
    }

    public static int countHi(String str) {
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            String find = str.substring(i, i + 2);
            if (find.equals("hi")) {
                count += 1;
            }
        }
        return count;
    }

    public static int countCode(String str) {
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            String find = str.substring(i, i + 2);
            String find1 = str.substring(i + 3, i + 4);
            if (find.equals("co") && find1.equals("e")) {
                count += 1;
            }
        }
        return count;
    }

    public static int countEvens(int [] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int thingy = nums[i];
            if (thingy % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public static int bigDiff(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        return max - min;
    }

    public static int sum13(int[] nums) {
        boolean thing = false;
        int sum = 0;
        int index = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                thing = true;
                index = i;
                break;
            }
        }
        for (int i = 0; i < index; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static int[] fizzArray(int n) {
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    public static boolean haveThree(int[] nums) {
        int count = 0;
        boolean thing = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 3) {
                count += 1;
            }
            if (nums[i] == 3 && nums[i + 1] == 3) {
                thing = true;
            }
        }
        if (nums[nums.length - 1] == 3) {
            count += 1;
        }
        if (count == 3 && thing == false) {
            return true;
        } else {
            return false;
        }
    }

    public static String[] fizzArray2(int n) {
        String [] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = String.valueOf(i);
        }
        return array;
    }

    public static int[] zeroFront(int[] nums) {
        int[] newArray = new int[nums.length];
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            newArray[i] = 0;
        }
        int index = zeroCount;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newArray[index] = nums[i];
                index++;
            }
        }
        return newArray;
    }

    public static String[] wordsWithout(String[] words, String target) {
        ArrayList<String> thing = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i] != target) {
                thing.add(words[i]);
            }
        }
        String[] output = new String[thing.size()];
        for (int i = 0; i < thing.size(); i++) {
            output[i] = thing.get(i);
        }
        return output;
    }

    public static int scoresAverage(int[] scores) {
        int index = scores.length / 2;
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < index; i++) {
            sum += scores[i];
        }
        for (int i = index; i < scores.length; i++) {
            sum1 += scores[i];
        }
        int output = Math.max(sum, sum1);
        return output / index;
    }

    public static boolean scoresIncreasing(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int scoresSpecial(int[] a, int[] b) {
        int special1 = 0;
        int special2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 10 == 0) {
                if (a[i] > special1) {
                    special1 = a[i];
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] % 10 == 0) {
                if (b[i] > special2) {
                    special2 = b[i];
                }
            }
        }
        return special1 + special2;
    }

    public static String firstTwo(String str) {
        if (str.length() >= 2) {
            return str.substring(0, 2);
        } else {
            if (str.length() == 1) {
                return str + "*";
            } else {
                return "**";
            }
        }
    }

    public static double divide(int a, int b) {
        int num1 = Math.max(a, b);
        int num2 = Math.min(a, b);
        if (a == 0 || b == 0) {
            return 0.0;
        }
        return (double) num1 / num2;
    }

    public static boolean catDog(String str) {
        int cat1 = 0;
        int dog1 = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("cat")) {
                cat1 += 1;
            }
            if (str.substring(i, i + 3).equals("dog")) {
                dog1 += 1;
            }
        }
        return dog1 == cat1;
    }

    public static String mixString(String a, String b) {
        String result = "";
        int max = Math.max(a.length(), b.length());
        for (int i = 0; i < max; i++) {
            if (i < a.length()) {
                result = result + a.charAt(i);
            }
            if (i < b.length()) {
                result = result + b.charAt(i);
            }
        }
        return result.toString();
    }

    public static String repeatEnd(String str, int n) {
        String end = str.substring(str.length() - n);
        String result = "";
        for (int i = 0; i < n; i++) {
            result = result + end;
        }

        return result;
    }

    public static boolean endOther(String a, String b) {
        String lower1 = a.toLowerCase();
        String lower2 = b.toLowerCase();
        if (lower1.endsWith(lower2) || lower2.endsWith(lower1)) {
            return true;
        } else {
            return false;
        }
    }
}
