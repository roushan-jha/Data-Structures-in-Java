import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int weight;
    int node;
    public Pair(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }
}

public class PrimsAlgo {
    public static void main(String[] args) {
        int V = 8;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>(List.of(2, 6))); 
        adj.get(0).add(new ArrayList<>(List.of(4, 4))); 
        adj.get(0).add(new ArrayList<>(List.of(6, 2)));
        adj.get(0).add(new ArrayList<>(List.of(7, 5)));  
        adj.get(1).add(new ArrayList<>(List.of(2, 7)));
        adj.get(1).add(new ArrayList<>(List.of(7, 6)));
        adj.get(1).add(new ArrayList<>(List.of(5, 5)));
        adj.get(1).add(new ArrayList<>(List.of(3, 4)));
        adj.get(2).add(new ArrayList<>(List.of(0, 6)));
        adj.get(2).add(new ArrayList<>(List.of(7, 9)));
        adj.get(2).add(new ArrayList<>(List.of(1, 7)));
        adj.get(2).add(new ArrayList<>(List.of(3, 8)));
        adj.get(2).add(new ArrayList<>(List.of(6, 7)));
        adj.get(3).add(new ArrayList<>(List.of(1, 4)));
        adj.get(3).add(new ArrayList<>(List.of(2, 8)));
        adj.get(3).add(new ArrayList<>(List.of(6, 5)));
        adj.get(4).add(new ArrayList<>(List.of(0, 4)));
        adj.get(4).add(new ArrayList<>(List.of(5, 5)));
        adj.get(4).add(new ArrayList<>(List.of(6, 8)));
        adj.get(4).add(new ArrayList<>(List.of(7, 8)));
        adj.get(5).add(new ArrayList<>(List.of(1, 5)));
        adj.get(5).add(new ArrayList<>(List.of(4, 5)));
        adj.get(5).add(new ArrayList<>(List.of(7, 3)));
        adj.get(6).add(new ArrayList<>(List.of(0, 2)));
        adj.get(6).add(new ArrayList<>(List.of(2, 7)));
        adj.get(6).add(new ArrayList<>(List.of(3, 5)));
        adj.get(6).add(new ArrayList<>(List.of(4, 8)));
        adj.get(7).add(new ArrayList<>(List.of(0, 5)));
        adj.get(7).add(new ArrayList<>(List.of(4, 8)));
        adj.get(7).add(new ArrayList<>(List.of(1, 6)));
        adj.get(7).add(new ArrayList<>(List.of(2, 9)));
        adj.get(7).add(new ArrayList<>(List.of(5, 3)));

        int S = 0;
        System.out.println(Prims(V, adj, S));
    }

    static int Prims(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // min-heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        
        int[] visited = new int[V];
        pq.add(new Pair(0,0));
        int sum = 0;
        while(pq.size() != 0) {
            int wt = pq.peek().weight;
            int node = pq.peek().node;
            pq.remove();

            if(visited[node] == 1) continue;
            // add it to mst
            visited[node] = 1;
            sum += wt;

            for(int i = 0; i < adj.get(node).size(); i++) {
                int eWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(visited[adjNode] == 0) {
                    pq.add(new Pair(eWt, adjNode));
                }
            }
        }
        return sum;
    }
}

