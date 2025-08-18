// Counting Sort is a non-comparison-based, stable sorting algorithm.
// It is particularly efficient when the range of input values is small compared to the number of elements to be sorted.
// Time Complexity: O(N+M)

import java.util.Arrays;

public class CountSort {

    private int[] countingSort(int[] arr) {
        int n = arr.length;

        int maxVal = 0; // for positive int[] array
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        int[] countArr = new int[maxVal + 1];
        for (int i = 0; i < n; i++) {
            countArr[arr[i]]++;
        }

        // Build prefix sum
        for (int i = 1; i <= maxVal; i++) {
            countArr[i] += countArr[i - 1];
        }

        // sorted array
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }

        return res;
    }

    public static void main(String[] args) {
        CountSort cs = new CountSort();
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int[] sorted = cs.countingSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(sorted));
    }
}
