// Question: https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;

public class LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        int max = 0;

        for(int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while (!stack.isEmpty()) {
            max = getMax(heights, stack, max, i);
        }

        return max;
    }

    private static int getMax(int[] heights, Stack<Integer> stack, int max, int i) {
        int area;
        int popped = stack.pop();

        if(stack.isEmpty()) {
            area = heights[popped] * i;
        } else {
            area = heights[popped] * (i - 1 - stack.peek());
        }
        
        return Math.max(max, area);
    }
    public static void main(String[] args) {
        LargestRectangleHistogram obj = new LargestRectangleHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(obj.largestRectangleArea(heights));
    }
}
