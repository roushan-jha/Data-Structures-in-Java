// COMBINATION SUM-I: https://leetcode.com/problems/combination-sum/description/
// COMBINATION SUM-II: https://leetcode.com/problems/combination-sum-ii/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetSumEqK {

    // private static void subsetSumEqK(int[] arr, int index, Set<List<Integer>> set, List<Integer> seq, int sum, int target) {
    //     if(index >= arr.length) {
    //         if(sum == target) {
    //             set.add(new ArrayList<>(seq));
    //         }
    //         return;
    //     }

    //     // PICK
    //     seq.add(arr[index]);
    //     sum += arr[index];
    //     subsetSumEqK(arr, index + 1, set, seq, sum, target);
    //     seq.remove(seq.size() - 1);
    //     sum -= arr[index];

    //     // NOT PICK 
    //     subsetSumEqK(arr, index + 1, set, seq, sum, target);
    // }



    // private static boolean oneSubsetSumEqK(int[] arr, int index, Set<List<Integer>> set, List<Integer> seq, int sum, int target) {
    //     if(index >= arr.length) {
    //         if(sum == target) {
    //             set.add(new ArrayList<>(seq));
    //             return true;
    //         }
    //         return false;
    //     }

    //     // PICK
    //     seq.add(arr[index]);
    //     sum += arr[index];
    //     if(oneSubsetSumEqK(arr, index + 1, set, seq, sum, target)) return true;
    //     seq.remove(seq.size() - 1);
    //     sum -= arr[index];

    //     // NOT PICK 
    //     if(oneSubsetSumEqK(arr, index + 1, set, seq, sum, target)) return true;

    //     return false; // NO SUB-SEQUENCE FOUND
    // }



    private static int numOfSubsets(int[] arr, int index, int sum, int target) {
        if(index >= arr.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        // PICK
        sum += arr[index];
        int left = numOfSubsets(arr, index + 1, sum, target);
        sum -= arr[index];

        // NOT PICK 
        int right = numOfSubsets(arr, index + 1, sum, target);

        return left + right;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 1, 2};
        int target = 8;
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> seq = new ArrayList<>();
        // GIVES ALL THE SUB-SEQUENCES
        // PRINTS ALL THE SUB-SEQUENCES (With duplicates) eg. [[1,7], [7,1]]
        // System.out.println("All sub-sequences!");
        // subsetSumEqK(arr, 0, set, seq, 0, target);

        // System.out.println(set);

        // GIVE ANY ONE SUB-SEQUENCE
        // System.out.println("Any One!");
        // oneSubsetSumEqK(arr, 0, set, seq, 0, target);

        // System.out.println(set);

        // COUNT NO. OF SUB-SEQUENCES
        System.out.println(numOfSubsets(arr, 0, 0, target));
    }
}
