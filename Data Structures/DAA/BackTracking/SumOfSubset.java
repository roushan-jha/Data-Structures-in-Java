public class SumOfSubset {
    public static void main(String[] args) {
        SumOfSubset sosub = new SumOfSubset();
        int[] w = { 8, 9, 5, 10 };
        int sum = 0;
        int target = 15;
        System.out.println(sosub.subset(w, sum, target, 0));
    }
    final int M = 15;
    final int V = 4;
    int[] X = new int[V];

    public int subset(int[] w, int sum, int target, int c) {
        if(c == V) {
            display(X);
            return 1;
        }
        int count = 0;
        if(isSafe(w, sum, target, M, c)) {
            X[c] = 1;
            count += subset(w, sum + w[c], target - w[c], c + 1);
            X[c] = 0;
        } 
        count += subset(w, sum, target, c + 1);
        return count;
    }

    public boolean isSafe(int[] w, int sum, int target, int M, int c) {
        if(c >= V - 1 && target != 0) {
            return false;
        }
        if(w[c] > target) {
            return false;
        }
        // check subset sum should not be greater than maximum sum
        if(sum > M) {
            return false;
        }

        if(sum + target < M) {
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
