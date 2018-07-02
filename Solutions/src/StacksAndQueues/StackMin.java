package StacksAndQueues;

import java.util.Stack;

public class StackMin {

    /*

    How would you design a stack which, in addition to push and pop,
    has a function min which returns the minimum element? Push,
    pop and min should all operate in 0(1) time.

    */

    /**
     * Time Complexity - O(1)
     * Space Complexity - O(n)
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public int getMin() {
        return minStack.peek();
    }

    public void push(int value) {
        if (minStack.isEmpty() || value < minStack.peek()) {
            minStack.push(value);
        }
        stack.push(value);
    }

    public int pop() {
        if (!stack.isEmpty() && !minStack.isEmpty() && stack.peek() == minStack.peek()) {
            minStack.pop();
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        stackMin.push(10);
        stackMin.push(20);
        System.out.println(stackMin.getMin());
        stackMin.push(30);
        stackMin.push(5);
        stackMin.push(12);
        System.out.println(stackMin.getMin());
        stackMin.pop();
        System.out.println(stackMin.getMin());
        stackMin.pop();
        System.out.println(stackMin.getMin());
    }
}
