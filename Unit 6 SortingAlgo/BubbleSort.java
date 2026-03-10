import java.util.Random;

public class BubbleSort {
    int[] nums;

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public BubbleSort(int size) {
        nums = new int[size];
    }

    public void fillArr(int[] nums) {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(nums.length * 67 - 41);
        }
    }

    public void sort(int[] nums) {
        if (nums.length <= 0) {
            return;
        }
        boolean sorted = false;
        int stopIndex = nums.length;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < stopIndex - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    sorted = false;
                }
            }
            stopIndex--;
        }

        System.out.println("Array sorted!");
    }

    public String toString() {
        String output = "Array: {";
        for (int i : nums) {
            output += " " + i + " ";
        }
        output += "}";
        return output;
    }
}