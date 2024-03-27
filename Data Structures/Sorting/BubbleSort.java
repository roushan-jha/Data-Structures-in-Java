//BubbleSort is an Inplace sorting algorithm - no new array is created
//BubbleSort is also known as Exchange sort or Sinking sort
//It is a Stable sorting algorithm - order is maintained

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
       int[] nums = { 2, 3, 5, 1, 4 };
       bubbleSort(nums);
       System.out.println(Arrays.toString(nums));
    }
    static void bubbleSort(int[] arr) {
        boolean swapped;
        for(int i = 0; i < arr.length; i++) {
            swapped = false;
            for(int j = 1; j < arr.length - i; j++) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
}
