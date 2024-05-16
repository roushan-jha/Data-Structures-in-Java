public class Rabin_Karp {
    public static void main(String[] args) {
        String text = "abcababcd";
        String pattern = "abcd";
        int q = 13;
        rabin_karp(text, pattern, q);
    }

    public final static int d = 10;
    
    static void rabin_karp(String text, String pattern, int q) {
        int n = text.length();
        int m = pattern.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for(i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for(i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for(i = 0; i <= n - m; i++) {
            if(p == t) {
                for(j = 0; j < m; j++) {

                    if(text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }

                if(j == m) {
                    System.out.println("Pattern found at index "+ i);
                }
            }

            if(i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) %  q;
                if(t < 0) {
                    t = t + q;
                }
            }
            
        }
    }
}
