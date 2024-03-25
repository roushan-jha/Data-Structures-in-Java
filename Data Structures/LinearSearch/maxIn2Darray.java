public class maxIn2Darray {
    public static void main(String[] args) {
        int arr[][] = {
            {3, 4, 5},
            {73, 37, 53},
            {12, 43, 65, 75}
        };
        int result = maxElement(arr);
        System.out.println(result);
    }
    static int maxElement(int[][] arr) {
        int max = arr[0][0];
        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[0].length; col++) {
                if(arr[row][col] > max) {
                    max = arr[row][col];
                }
            }
        }
        return max;
    }
}
