public class countRotation {
    public static void main(String[] args) {
        int[] nums = { 7,8,1,2,3,4,5,6 };
        System.out.println(count(nums)); 
    }
    static int count(int[] arr) {
        int pivot = findPivot(arr);
        return pivot + 1;
    }
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        //there are 4 cases
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if(arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    static int findPivotWithDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        //there are 4 cases
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
                //is start pivot
                if(arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                //is end pivot 
                if(arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
