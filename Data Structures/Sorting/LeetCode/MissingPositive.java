//https://leetcode.com/problems/first-missing-positive/
import java.util.Arrays;

public class MissingPositive {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        int ans = firstMissingPositive(nums);
        System.out.println(ans);
    }
    static int firstMissingPositive(int[] nums) {
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length; i++) {
            if(i != nums[i] - 1) {
                return (i+1);
            }
        }
        return nums.length + 1;
    }
    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && i != correctIndex) {
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
    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}