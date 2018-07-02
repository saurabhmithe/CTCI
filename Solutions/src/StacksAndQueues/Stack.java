package StacksAndQueues;

public class Stack {

    private int[] array;
    private int top;
    private int size;
    private boolean error;
    private String errorDescription;

    public Stack(int size) {
        this.size = size;
        array = new int[size];
        top = -1;
    }

    public void push(int data) {
        if ((top + 1) < size) {
            array[++top] = data;
        } else {
            error = true;
            errorDescription = "Stack is full. Unable to push.";
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return array[top--];
        } else {
            error = true;
            errorDescription = "Stack is empty. Unable to pop.";
            return -1;
        }
    }

    public int top() {
        return array[top];
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(array[i]);
        }
    }

    public void printError() {
        System.out.println(errorDescription);
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return top ==  size - 1;
    }

    public boolean isError() {
        return error;
    }
}
