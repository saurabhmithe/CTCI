package StacksAndQueues;

import java.util.Stack;

public class SortStack {

    /*

    Write a program to sort a stack such that the smallest items are on the top.
    You can use an additional temporary stack, but you may not copy the elements
    into any other data structure (such as an array). The stack supports the
    following operations: push, pop, peek, and isEmpty.

    */

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return stack;

        Stack<Integer> temp = new Stack<>();
        temp.push(stack.pop());
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num >= temp.peek()) temp.push(num);
            else {
                while (!temp.isEmpty() && temp.peek() > num) {
                    stack.push(temp.pop());
                }
                temp.push(num);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(40);
        stack.push(30);
        stack.push(10);
        stack.push(20);
        stack.push(50);
        stack.push(70);
        stack.push(60);
        Stack<Integer> sortedStack = sortStack(stack);
        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }
    }

}
