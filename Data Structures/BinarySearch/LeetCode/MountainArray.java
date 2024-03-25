// find the index of peak element in mountain array or bitonic array
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 3, 2, 1};
        int result = peakIndexInMountainArray(arr);
        System.out.println(result);
    }
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start != end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]) {
                end = mid;
            } else if(arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                return -1;
            }
        }
        return end; //or start
    }
}

//Same solution works for this question.
//https://leetcode.com/problems/find-peak-element/
/*
Input: nums = [1,2,1,3,5,6,4] - multiple peaks
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */ 