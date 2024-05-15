import java.util.ArrayList;
import java.util.List;

public class BellmanFordAlgo {
    public static void main(String[] args) {

        int V = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(List.of(0, 1, 5))); // Edge from vertex 0 to vertex 1 with weight 5
        adj.add(new ArrayList<>(List.of(0, 2, 3))); // Edge from vertex 0 to vertex 2 with weight 3
        adj.add(new ArrayList<>(List.of(1, 2, 6))); // Edge from vertex 1 to vertex 2 with weight 6
        adj.add(new ArrayList<>(List.of(1, 3, 2))); // Edge from vertex 1 to vertex 3 with weight 2
        adj.add(new ArrayList<>(List.of(2, 3, 7))); // Edge from vertex 2 to vertex 3 with weight 7
        adj.add(new ArrayList<>(List.of(3, 4, 1)));

        // System.out.println(adj);
        int S = 0;

        int[] distances = bellman_ford(V, adj, S);
        
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Distance from vertex " + S + " to vertex " + i + ": " + distances[i]);
        }
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S) {
        int[] dist = new int[V];

        for(int i = 0; i < V; i++) {
            dist[i] = (int)(1e8);
        }

        dist[S] = 0;

        for(int i = 0; i < V - 1; i++) {
            for(ArrayList<Integer> it: adj) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for(ArrayList<Integer> it: adj) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            int[] temp = new int[1];
            if(dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}