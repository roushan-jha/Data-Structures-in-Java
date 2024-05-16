public class min_max {
    static class Pair {
        int max;
        int min;
    }
    public static void main(String[] args) {
        int[] arr = {44, 53, 32, 54, 86, 24, 85};
        int low = 0;
        int high = arr.length - 1;
        Pair ans = maxMinDivideConquer(arr, low, high);
        System.out.println("Maximum Value: "+ans.max);
        System.out.println("Minimum Value: "+ans.min);
    }
    static Pair maxMinDivideConquer(int[] arr, int low, int high) {
        Pair result = new Pair();
        Pair left, right;
        
        int mid;
        // if only one element
        if(low == high) {
           result.max = arr[low];
           result.min = arr[low];
           return result;
        }

        // if only two elements 
        if(low == high - 1) {
            if(arr[low] < arr[high]) {
                result.min = arr[low];
                result.max = arr[high];
            } else {
                result.min = arr[high];
                result.max = arr[low];
            }
        }

        // if more than two elements
        mid = low + (high - low)/2;
        left = maxMinDivideConquer(arr, low, mid);
        right = maxMinDivideConquer(arr, mid + 1, high);
        result.min = Math.min(left.min, right.min);
        result.max = Math.max(left.max, right.max);
        
        return result;
    }
}
