// Question: https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> main;
    Stack<Integer> stack;

    public QueueUsingStack() {
        main = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        main.push(x);
    }

    public int pop() {

        while (!main.isEmpty()) {
            stack.push(main.pop());
        }

        int removed = stack.pop();

        while(!stack.isEmpty()) {
            main.push(stack.pop());
        }

        return removed;
    }

    public int peek() {
        return main.get(0);
    }

    public boolean isEmpty() {
        return main.empty();
    }

    public void display() {
        System.out.println(main);
    }

    public static void main(String[] args) {

        QueueUsingStack queue = new QueueUsingStack();

        System.out.println(queue.isEmpty());
        queue.push(5);
        queue.push(15);
        queue.push(25);
        queue.push(35);
        queue.display();
        System.out.println(queue.pop());  // Output: 5
        System.out.println(queue.peek());
        queue.display();
        System.out.println(queue.isEmpty());

    }
}
