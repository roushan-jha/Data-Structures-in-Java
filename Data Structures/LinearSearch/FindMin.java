public class FindMin {
    public static void main(String[] args) {
        int[] arr = { 30, 47, 32, 23, 84, 111, 21, 51 };
        int result = Min(arr);
        System.out.println(result);
    }
    static int Min(int[] arr) {
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
