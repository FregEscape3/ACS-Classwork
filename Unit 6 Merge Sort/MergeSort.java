public class MergeSort {
    public static int[] mergeArrays(int[] arrA, int[] arrB) {
        int[] output = new int[arrA.length + arrB.length];
        int indexA = 0;
        int indexB = 0;
        for (int i = 0; i < output.length; i++) {
            if (indexA < arrA.length && indexB < arrB.length && arrA[indexA] <= arrB[indexB]) {
                output[i] = arrA[indexA];
                indexA++;
            } else if (indexA < arrA.length && indexB < arrB.length && arrA[indexA] > arrB[indexB]) {
                output[i] = arrB[indexB];
                indexB++;
            } else if (indexA == arrA.length && indexB < arrB.length) {
                output[i] = arrB[indexB];
                indexB++;
            } else {
                output[i] = arrA[indexA];
                indexA++;
            }
        }
        return output;
    }
}
