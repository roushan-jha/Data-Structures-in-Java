public class splitArraySum {
    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;
        int result = splitArray(nums, k);
        System.out.println(result);
    }
    static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for(int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        //binary search
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int peices = 1;
            for (int num : nums) {
                if(num + sum > mid) {
                    //don't add in subarray
                    sum = num;
                    peices++;
                } else {
                    sum += num;
                }
            }
            if(peices > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
