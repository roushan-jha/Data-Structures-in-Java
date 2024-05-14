public class HamiltonianCycle {
    public static void main(String[] args) {
        HamiltonianCycle hmc = new HamiltonianCycle();
        int[][] G = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},
        };
        System.out.println(hmc.hamiltonian(G, 1));
    }

    final int V = 5;
    int[] path = new int[V];

    public int hamiltonian(int[][] G, int pos) {
        if(pos == V) {
            // check is there edge from last vertex to first or not
            if(G[path[pos - 1]][path[0]] == 1) {
                display(path);
                return 1;
            }
            return 0;
        }

        int count = 0;

        for(int v = 1; v < V; v++) {
            // System.out.println(isSafe(G, pos, v));
            if(isSafe(G, pos, v)) {
                path[pos] = v;
                count += hamiltonian(G, pos + 1);
                path[pos] = -1;
            }
        }
        return count;
    }

    public boolean isSafe(int[][] G, int pos, int v) {
        // check is it adjacent to previous vertex we added
        if(G[path[pos - 1]][v] == 0) {
            return false;
        }
        for(int i = 0; i < pos; i++) {
            if(path[i] == v) {
                return false;
            }
        }
        return true;
    }

    public void display(int[] path) {
        for(int vt : path) {
            System.out.print(vt + " ");
        }
        System.out.println();
    }
}
