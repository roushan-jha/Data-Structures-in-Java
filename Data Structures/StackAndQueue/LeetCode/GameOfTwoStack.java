// Question - HackerRank: https://www.hackerrank.com/challenges/game-of-two-stacks/problem

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameOfTwoStack {


    public int twoStacks(int maxSum, int[] A, int[] B) {
        return twoStacks(maxSum, A, B, 0, 0) - 1;
    }

    public int twoStacks(int maxSum, int[] A, int[] B, int sum, int count) {

        if(sum > maxSum) {
            return count;
        }

        if(A.length == 0 || B.length == 0) {
            return count;
        }

        int left = twoStacks(maxSum, Arrays.copyOfRange(A, 1, A.length), B, sum + A[0], count + 1);

        int right = twoStacks(maxSum, A, Arrays.copyOfRange(B, 1, B.length), sum + B[0], count + 1);
        
        return Math.max(left, right);
    }

    //////////////////////////////////////////////////////////////////////////
    // Arguments as a List<Integer>

    public int twoStacks(int maxSum, List<Integer> A, List<Integer> B) {
        return twoStacks(maxSum, A, B, 0, 0) - 1;
    }

    public int twoStacks(int maxSum, List<Integer> A, List<Integer> B, int sum, int count) {

        if(sum > maxSum) {
            return count;
        }

        if(A.size() == 0 || B.size() == 0) {
            return count;
        }

        int left = twoStacks(maxSum, A.subList(1, A.size()), B, sum + A.get(0), count + 1);

        int right = twoStacks(maxSum, A, B.subList(1, B.size()), sum + B.get(0), count + 1);
        
        return Math.max(left, right);
    }

    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);
        GameOfTwoStack gs = new GameOfTwoStack();

        System.out.print("Enter number of games: ");
        int g = sc.nextInt();

        for(int i = 0; i < g; i++) {
            System.out.print("Enter size of two array and target value: ");
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();

            // int[] a = new int[m];
            // int[] b = new int[n];

            // System.out.print("Enter elements of first array: ");
            // for(int j = 0; j < m; j++) {
            //     a[j] = sc.nextInt();
            // }

            // System.out.print("Enter elements of second array: ");
            // for(int k = 0; k < n; k++) {
            //     b[k] = sc.nextInt();
            // }

            // System.out.println("Number of Moves: "+gs.twoStacks(x, a, b));

            //////////////////////////////////////////////////////////////////////

            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();

            System.out.print("Enter elements of first array: ");
            for(int j = 0; j < m; j++) {
                A.add(sc.nextInt());
            }

            System.out.print("Enter elements of second array: ");
            for(int k = 0; k < n; k++) {
                B.add(sc.nextInt());
            }

            System.out.println("Number of Moves: "+gs.twoStacks(x, A, B));
        }

        sc.close();

    }
}
