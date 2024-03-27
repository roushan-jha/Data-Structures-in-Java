//Selection sort works good for small list/array
//Unstable sorting algorithm
//Best case - n^2 and Worst Case - n^2

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 1, 4 };
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, last, maxIndex);
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for(int i = start; i <= end; i++) {
            if(arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
