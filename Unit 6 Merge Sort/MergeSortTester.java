public class MergeSortTester {
    public static void main(String[] args) {
        int[] test1 = { 1, 3, 5, 7, 9, 10 };
        int[] test2 = { 6, 8, 10, 12, 14, 15, 17 };
        int[] bums = MergeSort.mergeArrays(test1, test2);
        for (int i : bums) {
            System.out.print(i + " ");
        }
        System.out.println("");
        int[] test3 = { -1, 0, 3, 5, 6, 7 };
        int[] test4 = { -3, -2, 1, 2, 4, 8, 9, 10 };
        int[] bums1 = MergeSort.mergeArrays(test3, test4);
        for (int i : bums1) {
            System.out.print(i + " ");
        }
    }
}
