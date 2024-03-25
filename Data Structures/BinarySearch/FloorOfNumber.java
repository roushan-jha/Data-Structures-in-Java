public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = { 0, 3, 7, 11, 15, 26, 31};
        int target = 12;
        int result = floor(arr, target);
        System.out.println(result);
    }
    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(target < arr[mid]) {
                end = mid - 1;
            } else if(target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }
}
