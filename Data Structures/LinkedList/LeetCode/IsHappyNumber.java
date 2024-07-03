//Question: https://leetcode.com/problems/happy-number/description/
///////////////////////////////////////////////////////////////////

public class IsHappyNumber {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquareOfDigits(slow);
            fast = findSquareOfDigits(findSquareOfDigits(fast));
        } while (slow != fast);

        if(slow == 1) {
            return true;
        }

        return false;
    }

    private int findSquareOfDigits(int number) {
        int square = 0;

        while (number > 0) {
            int rem = number % 10;
            square += rem * rem;
            number /= 10;
        }

        return square;
    }

    public static void main(String[] args) {
        IsHappyNumber obj = new IsHappyNumber();
        System.out.println(obj.isHappy(2));
    }
}

//////////////////////////////////////////////////////////////////////