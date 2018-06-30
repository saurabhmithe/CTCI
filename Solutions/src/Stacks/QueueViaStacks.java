package Stacks;

import java.util.Stack;

public class QueueViaStacks {

    /*

    Implement a MyQueue class which implements a queue using two stacks.

    */

    /**
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     */
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int value) {
        s1.push(value);
    }

    public int dequeue() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) return -1;
            else {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        QueueViaStacks queueViaStacks = new QueueViaStacks();
        queueViaStacks.enqueue(10);
        queueViaStacks.enqueue(20);
        queueViaStacks.enqueue(30);
        queueViaStacks.dequeue();
    }

}
