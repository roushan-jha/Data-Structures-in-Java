// QuickSort is a sorting algorithm based on the Divide and Conquer that picks an element as a pivot and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array.
// Hoare's Vs Lomuto Partition Algorithm
// It is a more efficient partitioning algorithm that uses two pointers to scan the array.
// QuickSort is not a stable sort.
// Time Complexity: O(n log n) - Best or Average Case, O(n^2) - Worst Case

import java.util.Arrays;

public class QuickSort {
    // Hoare's Partition Algorithm
    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[l]; // take pivot from the left

        int i = l;
        int j = r;
        while (i < j) {
            while (arr[i] <= pivot && i < r) {
                i++;
            }

            while (arr[j] > pivot && j > l) {
                j--;
            }

            if (i < j) {
                // Swap elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap pivot with arr[j]
        arr[l] = arr[j];
        arr[j] = pivot;
        return j;
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivotIndex = partition(arr, l, r);
            quickSort(arr, l, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, r);
        }
    }
    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
