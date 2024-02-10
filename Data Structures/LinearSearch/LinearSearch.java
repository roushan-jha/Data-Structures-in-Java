
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 22, 43, 1, 10};
        int target = 11;
        int result = linearSearch(arr, target);
        System.out.println(result);
    }

    //linearSearch function
    static int linearSearch(int[] arr, int target) {

        if(arr.length == 0) {
            return -1;
        }

        //search for element
        for(int index = 0; index < arr.length; index++) {
            int element = arr[index];
            if(element == target) {
                return index;
            }
        }

        return -1;
    }
}