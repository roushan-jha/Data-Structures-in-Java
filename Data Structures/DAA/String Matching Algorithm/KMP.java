public class KMP {
    public static void main(String[] args) {
        String text = "abcababcd";
        String pattern = "abcd";
        kmp_search(text, pattern);
    }
    static void kmp_search(String text, String pattern) {
        int M = pattern.length();
        int N = text.length();
        int j = 0; // pattern index
        int i = 0; // text index
        int[] lps = new int[M];
        computeLps(pattern, lps);

        while ((N - i) >= (M - j)) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if(j == M) {
                System.out.println("Pattern found at index "+ (i - j));
                j = lps[j - 1];
            } 
            if(i < N && text.charAt(i) != pattern.charAt(j)) {
                if(j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

    }
    static void computeLps(String pattern, int[] lps) {
        int M = pattern.length();
        int len = 0;
        lps[0] = 0;
        for(int i = 1; i < M; i++) {
            if(pattern.charAt(i) == len) {
                len++;
                lps[i] = len;
            } else {
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                }
            }
        }
    }
    
}
