public class Unit6Exercises {
    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
        System.out.println(factorialRecursive(5));
        System.out.println(fibonnaci(7)); // 13
        System.out.println(fibonnaciRecursive(7));
        System.out.println(sumDigits(9912)); // 21
        System.out.println(sumDigitsRecursive(9912));
        System.out.println(countX("xqx")); // 2
        System.out.println(countXRecursive("xqx")); // 2
        System.out.println(reverseString("bums")); // smub
        System.out.println(reverseStringRecursive("bums"));
        System.out.println(power(4, 3)); // 64
        System.out.println(powerRecursive(4, 3));
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindromeRecursive("racecar"));
        System.out.println(gcd(67, 3)); // 1
        System.out.println(gcdRecursive(67, 3));
        System.out.println(bunnyEars(4)); // 10
        System.out.println(bunnyEarsRecursive(4));
        int[] thing = { 1, 2, 3 };
        System.out.println(binarySearch(thing, 2)); // 1
        System.out.println(binarySearchRecursive(thing, 2));
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

    public static int factorialRecursive(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }

    public static int fibonnaci(int n) {
        int output = 0;
        int temp1 = 0;
        int temp2 = 1;
        if (n == 0) {
            return 0;
        }
        for (int i = 1; i < n + 1; i++) {
            output = temp2;
            temp2 = temp1 + output;
            temp1 = output;
        }
        return output;
    }

    public static int fibonnaciRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonnaciRecursive(n - 1) + fibonnaciRecursive(n - 2);
        }
    }

    public static int sumDigits(int n) {
        int total = 0;
        while (n > 0) {
            int digit = n % 10;
            total += digit;
            n /= 10;
        }
        return total;
    }

    public static int sumDigitsRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumDigitsRecursive(n / 10);
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

    public static int countXRecursive(String strings) {
        if (strings.isEmpty()) {
            return 0;
        }
        int output = Character.toLowerCase(strings.charAt(0)) == 'x' ? 1 : 0;
        return output + countXRecursive(strings.substring(1));
    }

    public static String reverseString(String strings) {
        String output = "";
        int i = strings.length() - 1;
        while (i >= 0) {
            output += strings.charAt(i);
            i--;
        }
        return output;
    }

    public static String reverseStringRecursive(String strings) {
        if (strings == null || strings.length() <= 1) {
            return strings;
        } else {
            return strings.charAt(strings.length() - 1)
                    + reverseStringRecursive(strings.substring(0, strings.length() - 1));
        }
    }

    public static int power(int n1, int n2) {
        return (int) Math.pow(n1, n2);
    }

    public static int powerRecursive(int n1, int n2) {
        if (n2 == 0) {
            return 1;
        }
        return n1 * powerRecursive(n1, n2 - 1);
    }

    public static boolean isPalindrome(String strings) {
        for (int i = 0; i < strings.length(); i++) {
            if (strings.charAt(i) != strings.charAt(strings.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String str) {
        if (str.length() <= 1) {
            return true;
        } else {
            if (str.charAt(0) != str.charAt(str.length() - 1)) {
                return false;
            }
            return isPalindromeRecursive(str.substring(1, str.length() - 1));
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            int thing = a % b;
            return gcdRecursive(b, thing);
        }
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

    public static int bunnyEarsRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return 2 + bunnyEarsRecursive(n - 1);
        }
        return 3 + bunnyEarsRecursive(n - 1);
    }

    public static int binarySearch(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == n) {
                return mid;
            }
            if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int n) {
        return binarySearchRecursive(arr, n, 0, arr.length - 1);
    }

    private static int binarySearchRecursive(int[] arr, int n, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == n) {
            return mid;
        }
        if (arr[mid] < n) {
            return binarySearchRecursive(arr, n, mid + 1, high);
        }
        return binarySearchRecursive(arr, n, low, mid - 1);
    }
}
