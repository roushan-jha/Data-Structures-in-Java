// Question: https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class ValidParanthesis {

    Stack<Character> stack;

    public ValidParanthesis() {
        stack = new Stack<>();
    }

    public boolean isValidParanthesis(String str) {
        for(int ch = 0; ch < str.length(); ch++) {
            if(str.charAt(ch) == '(' || str.charAt(ch) == '{' || str.charAt(ch) == '[') {
                stack.push(str.charAt(ch));
            } else if(stack.isEmpty() && str.length() != 0) {
                return false;
            } else {
                if(str.charAt(ch) == ')') {
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                if(str.charAt(ch) == '}') {
                    if(stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                if(str.charAt(ch) == ']') {
                    if(stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        
        ValidParanthesis p = new ValidParanthesis();

        System.out.println(p.isValidParanthesis("(())()"));
        
    }
}
