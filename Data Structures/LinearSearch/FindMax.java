public class FindMax {
    public static void main(String[] args) {
        int[] arr = { 30, 47, 32, 23, 84, 111, 21, 51 };
        int result = Max(arr);
        System.out.println(result);
    }
    static int Max(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
