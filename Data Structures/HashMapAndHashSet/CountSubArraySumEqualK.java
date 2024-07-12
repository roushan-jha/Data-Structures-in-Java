// Question: https://leetcode.com/problems/number-of-subarrays-with-and-value-of-k/description/
///////////////////////////////////////////////////////////////////////////////////////////////

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumEqualK {

    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer, Long> previousAndCounts = new HashMap<>();
        
        for (int num : nums) {
            HashMap<Integer, Long> currentAndCounts = new HashMap<>();
            if (num == k) {
                ans++;
            } 
            currentAndCounts.put(num, 1L);

            for (Map.Entry<Integer, Long> entry : previousAndCounts.entrySet()) {
                int previousAnd = entry.getKey();
                long count = entry.getValue();
                int newAnd = previousAnd & num;
                
                if (newAnd == k) {
                    ans += count;
                }
                
                currentAndCounts.merge(newAnd, count, Long::sum);
            }       
            previousAndCounts = currentAndCounts;
        }
        return ans;
    }

    public static void main(String[] args) {

        CountSubArraySumEqualK obj = new CountSubArraySumEqualK();

        int[] nums = {1, 1, 2};
        System.out.println(obj.countSubarrays(nums, 1));
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////