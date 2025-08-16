// Cyclic Sort is used When the numbers are from (1 - N) or (0 - (N - 1)) unordered
// Worst Case - n
// Many questions are based on this sorting technique. And it does not require any extra space.

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 3, 2 };
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (i != correctIndex) { //arr[i] != arr[correctIndex]
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
