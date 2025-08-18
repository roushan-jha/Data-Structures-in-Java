// Radix Sort is a linear sorting algorithm that sorts elements by processing them digit by digit.
// It is a stable sorting algorithm and uses counting sort as a subroutine.
// Time Complexity: O(d * (n + b)), d - no. of digits, b - base, n - size of array

import java.util.Arrays;

public class RadixSort {

    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // count array for digits 0-9

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // prefix sum
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    private static void radixSort(int[] arr, int n) {
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countingSort(arr, n, exp);
        }
    }
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        radixSort(arr, n);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
