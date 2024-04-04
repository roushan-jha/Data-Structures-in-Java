//https://leetcode.com/problems/missing-number/

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = { 1 };
        int result = missingNumber(nums);
        System.out.println(result);
    }

    static int missingNumber(int[] nums) {
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i];
            if (arr[i] < arr.length && i != correctIndex) {
                swap(arr, i, correctIndex);
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
