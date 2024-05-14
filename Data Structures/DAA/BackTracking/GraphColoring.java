public class GraphColoring {
    public static void main(String[] args) {
        GraphColoring coloring = new GraphColoring();
        int[][] graph = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 },
        };
        int m = 3;
        System.out.println(coloring.M_Coloring(graph, m, 0));
    }

    final int V = 4;
    int[] color = new int[V];

    int M_Coloring(int[][] graph, int m, int v) {
        if(v == V) {
            display(color);
            return 1;
        }
        int count = 0;
        for(int c = 1; c <= m; c++) {
            if(isSafe(graph, v, c)) {
                color[v] = c;
                count += M_Coloring(graph, m, v + 1);
                // if(M_Coloring(graph, m, v + 1)) {
                //     return true;
                // }
                color[v] = 0;
            }
        }
        return count;
    }

    boolean isSafe(int[][] graph, int v, int c) {
        for(int i = 0; i < V; i++) {
            if(graph[i][v] == 1 && c == color[i]) {
                return false;
            }
        }
        return true;
    }

    void display(int[] color) {
        for(int c : color) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
