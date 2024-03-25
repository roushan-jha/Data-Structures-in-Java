//Question: https://leetcode.com/problems/search-in-rotated-sorted-array/

public class searchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = { 7,8,1,2,3,4,5,6 };
        int target = 2;
        int result = search(nums, target);
        System.out.println(result); 
        //duplicate elements in array
        int[] arr = { 2, 9, 2, 2, 2 };
        System.out.println(search(arr, 9));     
    }
    static int search(int[] nums, int target) {
        int pivot = findPivotWithDuplicate(nums);

        if(pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        // 3 cases
        if(nums[pivot] == target) {
            return pivot;
        }
        if(target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        } 
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
        
    }
    static int binarySearch(int[] arr, int target, int start, int end) {
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
        return -1;
    }
    //this will not work for duplicate values
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
    //this will work for duplicate elements
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
