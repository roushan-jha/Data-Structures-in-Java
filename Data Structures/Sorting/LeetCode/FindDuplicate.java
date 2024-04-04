//https://leetcode.com/problems/find-the-duplicate-number/

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = { 3,1,3,4,2 };
        int result = findDuplicate(nums);
        System.out.println(result);
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
