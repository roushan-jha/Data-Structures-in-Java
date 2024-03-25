public class containsEvenNumberOfDigits {
    public static void main(String[] args) {
        int[] arr = { 43, 511, 534, 39, 384, 38384};
        int result = countNumbersWithEvenDigits(arr);
        System.out.println(result);
        System.out.println(digits(0));
    }
    static int countNumbersWithEvenDigits(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(even(arr[i])) {
                count ++;
            }
        }
        return count;
    }
    static boolean even(int num) {
        int numberofDigits = digits(num);
        if(numberofDigits % 2 == 0) {
            return true;
        }
        return false;
    }
    static int digits(int num) {
        if(num == 0) {
            return 1;
        }
        if(num < 0) {
            num = num * -1;
        }
        int count = 0;
        while(num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }
}
