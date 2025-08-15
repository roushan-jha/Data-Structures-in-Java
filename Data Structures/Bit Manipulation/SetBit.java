public class SetBit {
    public boolean isSet(int number, int position) {
        // Can be solve using leftshift operator or rightshift operator
        boolean leftShift = (number & (1 << position)) != 0;
        boolean rightShift = ((number >> position) & 1) != 0;

        return leftShift && rightShift;
    }

    public int set(int number, int position) {
        int ans = number | (1 << position);
        return ans;
    }

    public int clear(int number, int position) {
        int ans = ~(1 << position) & number;
        return ans;
    }

    public int toggle(int number, int position) {
        int ans = number ^ (1 << position);
        return ans;
    }
    public static void main(String[] args) {
        SetBit obj = new SetBit();
        // 13 -> 1101
        System.out.println(obj.isSet(13, 2)); // true
        System.out.println(obj.isSet(13, 1)); // false
        System.out.println(obj.set(9, 2)); // 9 -> 13
        System.out.println(obj.set(7, 2)); // 7 -> 7 (already set)
        System.out.println(obj.clear(13, 2)); // 9
        System.out.println(obj.toggle(13, 2)); // 9
        System.out.println(obj.toggle(9, 2)); // 13
    }
}
