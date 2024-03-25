// position of an element in infinite sorted array

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 7, 12, 15, 19, 34, 41, 65, 71, 99 };
        int target = 41;
        int result = ans(arr, target);
        System.out.println(result);
    }

    static int ans(int[] arr, int target) {
        // let initial size of array be 2
        int start = 0;
        int end = 1;

        // double the size of array
        try {
            while (target > arr[end]) {
                int newStart = end + 1; // temp variable
                end = end + (end - start + 1) * 2;
                start = newStart;
            }
        } catch (Exception e) {
            // Array Index out of bounds
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
    
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
