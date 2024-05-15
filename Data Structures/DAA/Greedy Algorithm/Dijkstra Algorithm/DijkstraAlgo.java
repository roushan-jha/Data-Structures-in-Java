import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;

    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

public class DijkstraAlgo {
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(new ArrayList<>(List.of(2, 2))); // Edge from vertex 0 to vertex 1 with weight 10
        adj.get(1).add(new ArrayList<>(List.of(3, 3)));  // Edge from vertex 0 to vertex 2 with weight 5
        adj.get(2).add(new ArrayList<>(List.of(4, 7)));  // Edge from vertex 1 to vertex 3 with weight 3
        adj.get(2).add(new ArrayList<>(List.of(3, 1)));  
        adj.get(3).add(new ArrayList<>(List.of(5, 3)));  // Edge from vertex 2 to vertex 1 with weight 2
        adj.get(4).add(new ArrayList<>(List.of(6, 1)));  // Edge from vertex 2 to vertex 3 with weight 9
        adj.get(5).add(new ArrayList<>(List.of(6, 5)));  // Edge from vertex 3 to vertex 4 with weight 2
        adj.get(5).add(new ArrayList<>(List.of(4, 2)));

        int S = 1; // Source vertex

        // Call Dijkstra's algorithm
        List<Integer> path = dijkstra(V, adj, S);
        System.out.println(path);
        // int[] distances = dijkstra(V, adj, S);

        // Output the distances from the source vertex to all other vertices
        // for (int i = 1; i <= V; i++) {
        //     System.out.println("Distance from vertex " + S + " to vertex " + i + ": " + distances[i]);
        // }
    }

    static List<Integer> dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // min-heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V+1];
        int[] parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            dist[i] = (int)(1e9);
            parent[i] = i;
        }
        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[V] == 1e9) {
            path.add(-1);
            return path;
        }
        int node = V;
        while( parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);

        return path;
    }
}
