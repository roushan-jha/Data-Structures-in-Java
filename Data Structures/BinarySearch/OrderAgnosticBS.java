public class OrderAgnosticBS {
    public static void main(String[] args) {
        // int[] arr = {-22, -3, -1, 4, 6, 34, 54, 60};
        int[] arr = {90, 77, 55, 43, 23, 21, 4, -4, -45};
        int ans = binarySearch(arr, 4);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(target == arr[mid]) {
                return mid;
            }
            if(isAsc) {
                if(target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
