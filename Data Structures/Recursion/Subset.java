import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void sequence(int[] nums, List<Integer> seq, int index) {
        if(index >= nums.length) {
            System.out.println(seq);
            return;
        }

        // PICK
        seq.add(nums[index]);
        sequence(nums, seq, index + 1);
        seq.remove(seq.size() - 1);  // MUST REMOVE THE ELEMENT WHILE BACKTRACKING
        // NOT PICK
        sequence(nums, seq, index + 1);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> seq = new ArrayList<>();
        sequence(arr, seq, 0);
    }
}
