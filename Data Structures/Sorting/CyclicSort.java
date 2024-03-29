// Cyclic Sort is used When the numbers are from (1 - N) unordered
// Worst Case - n

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = { 7, 6, 5, 2, 4, 1, 3 };
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void cyclicSort(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIndex = arr[i] - 1;
            if(i != correctIndex) { //arr[i] != arr[correctIndex]
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
    }
    // static void cyclicSort(int[] arr) {
    //     //index = value - 1;
    //     for(int i = 0; i < arr.length; i++) {
    //         while (i != arr[i] - 1) {
    //             swap(arr, i, arr[i] - 1);
    //         }
    //     }
    // }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
