//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllMissingNumber {
    public static void main(String[] args) {
        int[] nums = { 1,1 };
        List<Integer> result = missingNumber(nums);
        System.out.println(result);
    }

    static List<Integer> missingNumber(int[] nums) {
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                list.add(i+1);
            }
        }
        return list;
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
