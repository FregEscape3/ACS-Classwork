import java.util.ArrayList;

public class ArrayListPractice {

    public static void main(String[] args) {
        ArrayList<String> fruitList = new ArrayList<String>();
        fruitList.add("apple");
        fruitList.add("pear");
        fruitList.add("banana");
        fruitList.add("grape");
        fruitList.add("peach");
        fruitList.add("pineapple");
        fruitList.add("orange");

        ArrayList<String> fruitList2 = new ArrayList<String>();
        fruitList2.add("apple");
        fruitList2.add("pear");
        fruitList2.add("banana");
        fruitList2.add("grape");
        fruitList2.add("peach");
        fruitList2.add("pineapple");
        fruitList2.add("orange");

        System.out.println("Odd length count: " + countOddLength(fruitList));
        System.out.println("Odd length count: " + countOddLengthForEachLoop(fruitList));

        System.out.println("removeString method - from the front of the Arraylist");
        removeStrings(fruitList, 'p');
        System.out.println(fruitList);

        System.out.println("removeString method - from the end of the Arraylist");
        removeStrings2(fruitList2, 'p');
        System.out.println(fruitList2);

        // ArrayList numberList = new ArrayList<Integer>();
        // numberList.add(5);
        // numberList.add(6);
        // numberList.add(5);
        // numberList.add(3);
        // numberList.add(3);
        // numberList.add(5);
        // numberList.add(2);
        // System.out.println("number of fives: " + numCount(numberList, 5));

    }

    // returns the number of Strings in the ArrayList with an odd length.
    public static int countOddLength(ArrayList<String> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() % 2 == 1) {
                count++;
            }
        }
        return count;
    }

    // returns the number of Strings in the ArrayList with an odd length using a
    // For-Each Loop.
    public static int countOddLengthForEachLoop(ArrayList<String> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (String string : list) {
            if (string.length() % 2 == 1) {
                count++;
            }
        }
        return count;
    }

    // removes all Strings in the ArrayList that begin with the same letter as
    // firstLetter. Remove
    // them by iterating from the beginning of the list.
    public static void removeStrings(ArrayList<String> list, char firstLetter) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(0) == firstLetter) {
                list.remove(list.get(i));
            }
        }

    }

    // removes all Strings in the ArrayList that begin with the same letter as
    // firstLetter. Remove
    // them by iterating from the end of the list.
    public static void removeStrings2(ArrayList<String> list, char firstLetter) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).charAt(0) == firstLetter) {
                list.remove(list.get(i));
            }
        }
    }

    // counts and returns the number of times a the integer number is found in the
    // ArrayList. It
    // iterates through the list using a For-Each Loop.
    public static int numCount(ArrayList<Integer> list, int number) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (Integer integer : list) {
            if (integer == number) {
                count++;
            }
        }
        return count;
    }

}