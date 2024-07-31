// GENERATE PARENTHESIS: https://leetcode.com/problems/generate-parentheses/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    // BRUTE FORCE APPROACH
    List<String> strL;
    public List<String> generateParenthesis(int n) {
        strL = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        allValidParenthesis(sb, n);
        return strL;
    }

    private void allValidParenthesis(StringBuilder sb, int n) {
        if(sb.length() == n * 2) {
            System.out.println(validParenthesis(sb.toString()));
            if(validParenthesis(sb.toString())) {
                strL.add(sb.toString());
            }
            return;
        }

        sb.append('(');
        allValidParenthesis(sb, n);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        allValidParenthesis(sb, n);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean validParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(stack.isEmpty() && s.length() != 0) {
                return false;
            } else {
                if((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        GenerateParenthesis obj = new GenerateParenthesis();
        System.out.println(obj.generateParenthesis(2));
    }
}
