// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

public class MinBitsFlips extends CountSetBits {
    public int minBitsFlipsToConvert(int start, int goal) {
        int ans = start ^ goal;
        return super.optimized(ans);
    }
    public static void main(String[] args) {
        MinBitsFlips obj = new MinBitsFlips();
        int start = 2;
        int goal = 1;

        System.out.println(obj.minBitsFlipsToConvert(start, goal));
    }
}
