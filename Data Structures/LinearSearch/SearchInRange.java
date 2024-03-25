
public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {2, 4, 22, 43, 1, 10};
        int target = 1;
        int result = linearSearch(arr, target, 2, 4);
        System.out.println(result);
    }

    //linearSearch function
    static int linearSearch(int[] arr, int target, int start, int end) {

        if(arr.length == 0) {
            return -1;
        }

        //search for element
        for(int index = start; index <= end; index++) {
            int element = arr[index];
            if(element == target) {
                return index;
            }
        }

        return -1;
    }
}