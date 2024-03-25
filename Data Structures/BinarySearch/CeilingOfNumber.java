public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = { 0, 3, 7, 11, 15, 26, 31};
        int target = 32;
        int result = ceiling(arr, target);
        System.out.println(result);
    }
    static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        if(target > arr[end]) {
            return -1;
        }
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(target < arr[mid]) {
                end = mid - 1;
            } else if(target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
