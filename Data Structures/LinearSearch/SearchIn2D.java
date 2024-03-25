import java.util.Arrays;

public class SearchIn2D {
    public static void main(String[] args) {
        int[][] arr = {
            { 2, 5, 5 },
            { 22, 44, 54, 11 },
            { 7, 32 }
        };
        int target = 54;
        int[] result = Search2D(arr, target);
        System.out.println(Arrays.toString(result));
    }
    static int[] Search2D(int[][] arr, int target) {
        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[row].length; col++) {
                if(arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

}
