public class Unit3ExercisesTester {

    public static void main(String[] args) {
        // Test Case - Main Case
        String[] letters = { "abc", "cde", "efg", "hij" };
        // expected output: 3.0 (WORKS)
        System.out.println("Expected 3.0: " + Unit3Exercises.calculateAverageStringLength(letters));
        // Test Case - Edge Case: Null element Array (WORKS)
        letters = new String[] { "abc", "cde", "efg", null, "hij" };
        // expected output: 3.0
        System.out.println("Expected 3.0: " + Unit3Exercises.calculateAverageStringLength(letters));
        // Test Case - Edge Case: Null array (WORKS)
        try {
            letters = null;
            // expected output: 0
            System.out.println("Expected exception: " + Unit3Exercises.calculateAverageStringLength(letters));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the array was null, as intended");
        }
        // Test Case - Main Case (WORKS)
        String testString = "abc";
        System.out.println("Expected cba: " + Unit3Exercises.reverseString(testString));
        // Test Case - Edge Case: String with spaces at the end and in the middle
        // (WORKS)
        testString = " ab c ";
        System.out.println("Expected ' c ba ': " + Unit3Exercises.reverseString(testString));
        // Test Case - Edge Case: String with special characters (WORKS)
        testString = "a1b!c&";
        System.out.println("Expected '&c!b1a': " + Unit3Exercises.reverseString(testString));
        // Test Case - Edge Case: Null string (WORKS)
        try {
            testString = null;
            System.out.println("Expected exception: " + Unit3Exercises.reverseString(testString));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("The method threw an exception when the string was null, as intended");
        }
        // main case (WORKS)
        int[] testArray = { 3, 5, 2, 1, 4 };
        System.out.println("Expected 5: " + Unit3Exercises.findMaxValue(testArray));
        // edge case: negative and zero integers (WORKS)
        testArray = new int[] { -2, -4, 0, -3, -1 };
        System.out.println("Expected 0: " + Unit3Exercises.findMaxValue(testArray));
        // edge case: only negative integers (WORKS)
        testArray = new int[] { -2, -1, -5, -4, -3 };
        System.out.println("Expected -1: " + Unit3Exercises.findMaxValue(testArray));
        // edge case: null array (WORKS)
        testArray = null;
        System.out.println("Expected 0: " + Unit3Exercises.findMaxValue(testArray));
        // main case: palindrome (WORKS)
        String tester = "kayak";
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(tester));
        // main case: non-palindrome (WORKS)
        tester = "kayaak";
        System.out.println("Expected false: " + Unit3Exercises.isPalindrome(tester));
        // edge case: Null string (WORKS)
        tester = null;
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(tester));
        // edge case: Empty String ("") (WORKS)
        tester = "";
        System.out.println("Expected true: " + Unit3Exercises.isPalindrome(tester));
        // main case
        int[] testArray1 = { 4, 2, 6, 1, 5, 3 };
        System.out.println("Expected 12: " + Unit3Exercises.sumEvenNumbers(testArray1));
        // edge case: negative and zero integers
        testArray1 = new int[] { -4, -1, -5, -2, -6, -3 };
        System.out.println("Expected -12: " + Unit3Exercises.sumEvenNumbers(testArray1));
        // edge case: only negative integers
        testArray1 = new int[] { 4, -5, 3, -1, -2, -100 };
        System.out.println("Expected -98: " + Unit3Exercises.sumEvenNumbers(testArray1));
        // edge case: null array
        testArray1 = null;
        System.out.println("Expected 0: " + Unit3Exercises.sumEvenNumbers(testArray1));
        // main case
        int[] testArray2 = { 6, 7, 41 };
        System.out.println("Expected 1766: " + Unit3Exercises.calculateSumOfSquares(testArray2));
        // edge case: null array
        // testArray2 = null;
        // System.out.println("Expected error message: " +
        // Unit3Exercises.calculateSumOfSquares(testArray2));
        // main case
        int testInt = 41;
        System.out.println("Expected 165580141: " + Unit3Exercises.getNthFibonacci(testInt));
        // edge case: negative #
        // testInt = -5;
        // System.out.println("Expected error message: " +
        // Unit3Exercises.getNthFibonacci(testInt));
        // main case
        int[] testArray3 = { 10, 5, 6, 67, 41 };
        System.out.print("Expected {67, 41, 10, 6, 5}: ");
        Unit3Exercises.sortArrayDescending(testArray3);
        // // edge case: null array
        // testArray3 = null;
        // System.out.print("Expected error message: ");
        // Unit3Exercises.sortArrayDescending(testArray3);
        // main case: longest word
        String words = "Michael is a bum, and Alex has pneumonoultramicroscopicsilicovolcanoconiosis";
        System.out.println(
                "Expected pneumonoultramicroscopicsilicovolcanoconiosis: " + Unit3Exercises.findLongestWord(words));
        // main case: equally long word
        words = "Michael is a bum, and Alex has laptops";
        System.out.println(
                "Expected Michael: " + Unit3Exercises.findLongestWord(words));
        // edge case: null/empty input
        // words = null;
        // System.out.println("Expected error message: " +
        // Unit3Exercises.findLongestWord(words));
        // main case
        double principal = 100, rate = 67;
        int years = 5;
        System.out.println("Expected 1298.91986: " + Unit3Exercises.calculateInterest(principal, rate, years));
        // edge case: Negative principal
        principal = -5;
        System.out.println("Expected error message: " + Unit3Exercises.calculateInterest(principal, rate, years));
        // edge case: Negative interest
        principal = 100;
        rate = -5;
        System.out.println("Expected error message: " + Unit3Exercises.calculateInterest(principal, rate, years));
        // edge case: Negative years
        years = -5;
        rate = 67;
        System.out.println("Expected error message: " + Unit3Exercises.calculateInterest(principal, rate, years));
        // main case
        String testString = "100";
        System.out.println("Expected 100: " + Unit3Exercises.parsePositiveInteger(testString));
        // edge case: negative #
        testString = "-50";
        System.out.println("Expected 1: " + Unit3Exercises.parsePositiveInteger(testString));
        // main case
        String[] bums = { "bum0", "bum1", "bum2", "bum3" };
        int index1 = 2;
        System.out.println("Expected bum2: " + Unit3Exercises.getArrayElement(bums, index1));
        // edge case: out of bounds
        index1 = 67;
        System.out.println("Expected null: " + Unit3Exercises.getArrayElement(bums, index1));
        // main case
        int trash = 45441081;
        System.out.println("Expected 6741.0: " + Unit3Exercises.calculateSquareRoot(trash));
        // edge case: negative
        trash = -67;
        System.out.println("Expected NaN: " + Unit3Exercises.calculateSquareRoot(trash));
        // main case
        int[] chopped = { 10, 41, 67, 2 };
        System.out.println("Expected 120: " + Unit3Exercises.sumArrayElements(chopped));
        // edge case: null array
        chopped = null;
        System.out.println("Expected 0: " + Unit3Exercises.sumArrayElements(chopped));
        // main case
        int base = 5;
        int power = 3;
        System.out.println("Expected 125: " + Unit3Exercises.sumArrayElements(chopped));
        // edge case: negative exponent
        power = -5;
        System.out.println("Expected 1: " + Unit3Exercises.sumArrayElements(chopped));
    }
}
