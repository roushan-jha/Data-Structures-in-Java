public class TSP {
    static int n = 4;
    static int[][] G = {
       {0, 10, 15, 20},
       {5, 0, 9, 10},
       {6, 13, 0, 12},
       {8, 8, 9, 0}
    };
    static int visited_all = (1 << n) - 1;
    static int[][] DP = new int[16][4];
    static int tsp(int mask, int position) {
       if (mask == visited_all) {
          return G[position][0];
       }
       if (DP[mask][position] != -1) {
          return DP[mask][position];
       }
       int answer = Integer.MAX_VALUE;
       for (int city = 0; city < n; city++) {
          if ((mask & (1 << city)) == 0) {
             int newAnswer = G[position][city] + tsp(mask | (1 << city), city);
             answer = Math.min(answer, newAnswer);
          }
       }
       DP[mask][position] = answer;
       return answer;
    }
    public static void main(String[] args) {
       for (int i = 0; i < (1 << n); i++) {
          for (int j = 0; j < n; j++) {
              DP[i][j] = -1;
          }
       }
       System.out.println("Minimum Distance Travelled -> " + tsp(1, 0));
    }
 }