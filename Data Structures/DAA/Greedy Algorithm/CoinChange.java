import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {
        int[] change = {2, 5, 10, 20}; // must be sorted
        int target = 20;
        List<Integer> ans = coinChange(change, target);
        System.out.println(ans);
    }
    
    static List<Integer> coinChange(int[] change, int target) {
        List<Integer> coins = new ArrayList<>();

        for(int i = change.length - 1; i >= 0; i--) {
            while(target >= change[i]) {
                target -= change[i];
                coins.add(change[i]);
            }
        }

        return coins;
    }
}
