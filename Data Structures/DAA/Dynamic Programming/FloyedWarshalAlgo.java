public class FloyedWarshalAlgo {
    public static void main(String[] args) {
        int[][] G = {
            { 0, 5, -1, 10 },
            { -1, 0, 3, -1 },
            { -1, -1, 0, 1 },
            { -1, -1, -1, 0 }
        };
        floyed_warshal(G);
        display(G);
    }

    static void floyed_warshal(int[][] matrix) {
        int n = matrix.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e8);
                }
            }
        }

        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1e8) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    static void display(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(" " +matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
