public class SumOfSubset {
    public static void main(String[] args) {
        SumOfSubset sosub = new SumOfSubset();
        int remainingWt = 15;
        int currentWt = 0;
        sosub.subset(currentWt, 0, remainingWt);
    }
    final static int M = 15;
    // final int[] w = { 5, 8, 9, 10 };
    final int[] w = { 25, 10, 15, 20, 5 };
    final int V = 5;
    int[] X = new int[V];
    boolean flag = false;

    public void subset(int currentWt, int c, int remainingWt) {
        if(currentWt == M) {
            display(X);
            flag = true;
            return;
        }
        if(c == V) {
            return;
        }
        subset(currentWt, c + 1, remainingWt - w[c]);

        if(isSafe(currentWt, w, c, remainingWt, V)) {
            X[c] = 1;
            subset(currentWt + w[c], c + 1, remainingWt - w[c]);
            X[c] = 0;
        } 

    }

    static boolean isSafe(int currentWt, int[] w, int c, int remainingWt, int V) {
        if(w[c] <= remainingWt) {
            return true;
        }
        return false;
    }

    public void display(int[] X) {
        for(int x : X) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

}
