import java.util.*;

class RichestPerson {
    public static void main(String[] args) {
        int[][] accounts = {{1,5}, {7, 3}, {3, 5}};
        int result = maximumWealth(accounts);
        System.out.println(result);
    }
    static int maximumWealth(int[][] accounts) {
        int[] arr = new int[accounts.length];
        Arrays.fill(arr, 0);
        // int sum = 0;
        for(int i = 0; i < accounts.length; i++) {
            for(int j = 0; j < accounts[0].length; j++) {
                arr[i] = arr[i] + accounts[i][j];
            }
            // sum = 0;
        }
        System.out.println(Arrays.toString(arr));
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
