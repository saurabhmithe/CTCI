package Stacks;

import java.util.ArrayList;
import java.util.List;


public class StackOfPlates {

    /*

    Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life,
    we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure
    SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack
    once the previous one exceeds capacity. SetOfStacks. push () and SetOfStacks. pop () should behave identically
    to a single stack (that is, pop ( ) should return the same values as it would if there were just a single stack).

    FOLLOW UP
    Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.

    */

    List<Stack> stacks;
    int stackNo;
    int stackSize = 3;

    public void init() {
        stackNo = 0;
        stacks = new ArrayList<>();
        Stack stack = new Stack(stackSize);
        stacks.add(stack);
    }

    public void push(int value) {
        Stack latestStack = stacks.get(stackNo);
        if (latestStack.isFull()) {
            Stack newStack = new Stack(stackSize);
            newStack.push(value);
            stacks.add(newStack);
            stackNo += 1;
        } else {
            latestStack.push(value);
        }
    }

    public int pop() {
        Stack latestStack = stacks.get(stackNo);
        if (stackNo == 0 && latestStack.isEmpty()) return -1;
        int value = latestStack.pop();
        if (latestStack.isEmpty()) {
            stacks.remove(stackNo);
            stackNo -= 1;
        }
        return value;
    }

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates();
        stackOfPlates.init();
        stackOfPlates.push(10);
        stackOfPlates.push(20);
        stackOfPlates.push(30);
        stackOfPlates.push(40);
        stackOfPlates.push(50);
        stackOfPlates.push(60);
        stackOfPlates.push(70);
        stackOfPlates.pop();
        stackOfPlates.pop();


    }
}
