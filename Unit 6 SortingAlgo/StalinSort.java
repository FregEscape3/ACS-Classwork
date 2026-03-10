import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class StalinSort {
    int[] nums;

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    public StalinSort(int size) {
        nums = new int[size];
    }

    public void fillArr(int[] nums) {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(nums.length * 67 - 41);
        }
    }

    public void sort(int[] nums) {
        if (nums.length == 0) {
            this.nums = nums;
            return;
        }
        ArrayList<Integer> kept = new ArrayList<>();
        kept.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= kept.get(kept.size() - 1)) {
                kept.add(nums[i]);
            }
        }
        int[] arr = new int[kept.size()];
        for (int i = 0; i < kept.size(); i++) {
            arr[i] = kept.get(i);
        }
        this.nums = arr;
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
