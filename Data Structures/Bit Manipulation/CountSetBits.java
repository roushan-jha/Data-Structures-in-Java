public class CountSetBits {
    public int bruteForce(int n) {
        int count = 0;
        while (n > 1) {
            if(n % 2 == 1) count++;
            n = n / 2;
        }
        if(n == 1) count++;
        return count;
    }

    public int better(int n) {
        int count = 0;
        while (n > 1) {
            count += n & 1;
            n = n >> 1;
        }
        if(n == 1) count++;
        return count;
    }

    public int optimized(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountSetBits obj = new CountSetBits();
        int n = 15;
        
        System.out.println(obj.bruteForce(n));
        System.out.println(obj.better(n));
        System.out.println(obj.optimized(n));
    }
}
