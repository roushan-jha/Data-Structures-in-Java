public class SudokoSolver {
    public static void main(String[] args) {
        int[][] sudoko = new int[][]{
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
        };
        
        if(solve(sudoko)) {
            display(sudoko);
        } else {
            System.out.println("CAN NOT SOLVE");
        }

    }
    
    static boolean solve(int[][] sudoko) {

        int n = sudoko.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(sudoko[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if you found some empty element in row, then break
            if(emptyLeft == false) {
                break;
            }
        }
        
        if(emptyLeft == true) {
            return true;
            // SUDOKO SOLVED
        }

        // backtrack
        for(int number = 1; number <= 9; number++) {
            if(isSafe(sudoko, row, col, number)) {
                sudoko[row][col] = number;
                if(solve(sudoko)) {
                    // found the answer
                    return true;
                } else {
                    // backtrack
                    sudoko[row][col] = 0;
                }
            }
        }

        return false; // SUDOKO CAN NOT BE SOLVED

    }

    static void display(int[][] sudoko) {
        for(int[] row : sudoko) {
            for(int num : row) {
                System.out.print(num + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }

    static boolean isSafe(int[][] sudoko, int row, int col, int num) {
        // check the row
        for(int i = 0; i < sudoko.length; i++) {
            // check if the is in the row
            if(sudoko[row][col] == num) {
                return false;
            }
        }

        // check the col
        for(int[] nums : sudoko) {
            // check if the number is int col
            if(nums[col] == num) {
                return false;
            }
        }

        // check in the  3 X 3 box
        int sqrt = (int)(Math.sqrt(sudoko.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart; r < rowStart + sqrt; r++) {
            for(int c = colStart; c < colStart + sqrt; c++) {
                if(sudoko[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
