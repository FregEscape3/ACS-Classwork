public class Unit6Exercises {
    public static void main(String[] args) {
        factorial(5); // 120
        fibonnaci(7); // 13
        sumDigits(9912); // 21
        countX("xqx"); // 2
        reverseString("bums"); // smub
        power(4, 3); // 64
        isPalindrome("racecar"); // true
        gcd(67, 3); // 1
        bunnyEars(4); // 10
    }

    public static int factorial(int n) {
        int output = 1;
        if (n == 0) {
            return 1;
        }
        for (int i = 1; i < n + 1; i++) {
            output *= i;
        }
        return output;
    }

    public static int fibonnaci(int n) {
        int output = 0;
        int temp1 = 0;
        int temp2 = 1;
        if (n == 0) {
            return 0;
        }
        for (int i = 1; i < n + 2; i++) {
            output = temp2;
            temp2 = temp1 + output;
            temp1 = output;
        }
        return output;
    }

    public static int sumDigits(int n) {
        int total = 0;
        while (n > 0) {
            int digit = n % 10;
            total += digit;
            n = n - digit;
        }
        return total;
    }

    public static int countX(String strings) {
        int output = 0;
        for (int i = 0; i < strings.length(); i++) {
            if (strings.toLowerCase().charAt(i) == 'x') {
                output++;
            }
        }
        return output;
    }

    public static String reverseString(String strings) {
        String output = "";
        for (int i = strings.length() - 1; i >= 0; i++) {
            output += strings.charAt(i);
        }
        return output;
    }

    public static int power(int n1, int n2) {
        return (int) Math.pow(n1, n2);
    }

    public static boolean isPalindrome(String strings) {
        for (int i = 0; i < strings.length(); i++) {
            if (strings.charAt(i) != strings.charAt(strings.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int bunnyEars(int n) {
        int ears = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 0) {
                ears += 2;
            } else {
                ears += 3;
            }
        }
        return ears;
    }

    public static int binarySearch(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
