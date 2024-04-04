//https://leetcode.com/problems/set-mismatch/
import java.util.Arrays;

public class setMisMatch {
    public static void main(String[] args) {
        int[] nums = { 1,2,2,4 };
        int[] ans = findErrorNums(nums);
        System.out.println(Arrays.toString(ans));
    }
    static int[] findErrorNums(int[] nums) {
        cyclicSort(nums);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                result[0] = nums[i];
                result[1] = (i+1);
            }
        }
        return result;
    }
    /*static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        result[0] = findDuplicate(nums);
        result[1] = missingNumber(nums);

        return result;
    }
    static int findDuplicate(int[] nums) {
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                return nums[i];
            }
        }
        return -1;
    }
    static int missingNumber(int[] nums) {
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                return (i+1);
            }
        }
        return nums.length;
    } */
    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (i != correctIndex) {
                if(arr[i] == arr[correctIndex]) {
                    i++;
                } else {
                    swap(arr, i, correctIndex);
                }
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
