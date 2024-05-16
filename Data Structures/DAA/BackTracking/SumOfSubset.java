public class SumOfSubset {
    public static void main(String[] args) {
        SumOfSubset sosub = new SumOfSubset();
        int remainingWt = 15;
        int currentWt = 0;
        System.out.println(sosub.subset(currentWt, 0, remainingWt));
    }
    final static int M = 15;
    final int[] w = { 5, 8, 9, 10 };
    // final int[] w = { 25, 10, 15, 20, 5 };
    final int V = 4;
    int[] X = new int[V];

    public int subset(int currentWt, int c, int remainingWt) {
        if(c == V) {
            display(X);
            return 1;
        }
        
        int count = 0;

        if(isSafe(currentWt, w, c, remainingWt, V)) {
            X[c] = 1;
            count += subset(currentWt + w[c], c + 1, remainingWt - w[c]);
            X[c] = 0;
        } else {
            X[c] = 0;
            count += subset(currentWt, c + 1, remainingWt - w[c]);
        }  

        return count;
    }

    static boolean isSafe(int currentWt, int[] w, int c, int remainingWt, int V) {
        if(w[c] > currentWt) {
            return false;
        }
        if(currentWt + w[c] > M) {
            return false;
        }
        if(currentWt + remainingWt < M) {
            return false;
        }
        
        return true;
    }

    public void display(int[] X) {
        for(int x : X) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

}
