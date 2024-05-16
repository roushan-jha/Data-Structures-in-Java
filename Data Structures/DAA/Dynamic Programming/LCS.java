public class LCS {
    public static void main(String[] args) {
        String str1 = "blackboard";
        String str2 = "crack";

        int m = str1.length();
        int n = str2.length();

        int ans = lcs(str1, str2, m, n);
        System.out.println(ans);
    }

    static int lcs(String s1, String s2, int m, int n) {

        if(m == 0 || n == 0) {
            return 0;
        }
        if(s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return (1 + lcs(s1, s2, m - 1, n - 1));
        } else {
            return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
        }
    }
}
