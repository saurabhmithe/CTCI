package Stacks;

public class ThreeInOne {

    /*

    Describe how you could use a single array to implement three stacks.

    */

    int[] tops = {-1, -1, -1};
    int[] values = new int[10];
    int[] indices = new int[10];
    int nextAvailable = 0;

    public boolean push(int stackNo, int value) {
        if (nextAvailable == -1) return false;
        values[nextAvailable] = value;
        int newTopOfStack = nextAvailable;
        nextAvailable = indices[nextAvailable];
        indices[newTopOfStack] = tops[stackNo];
        tops[stackNo] = newTopOfStack;
        return true;
    }

    public int pop(int stackNo) {
        int top = tops[stackNo];
        tops[stackNo] = indices[top];
        int num = values[top];
        indices[top] = top;
        values[top] = 0;
        nextAvailable = top;
        return num;
    }

    public void init() {
        for (int i = 0; i < indices.length - 1; i++) {
            indices[i] = i + 1;
        }
        // Setting next index as -1 since there is no more space for any value.
        indices[indices.length - 1] = -1;
    }

    public static void main(String[] args) {
        ThreeInOne threeInOne = new ThreeInOne();
        threeInOne.init();
        threeInOne.push(0, 5);
        threeInOne.push(0, 6);
        threeInOne.push(0, 7);
        threeInOne.push(1, 8);
        threeInOne.push(1, 9);
        threeInOne.push(1, 10);
        threeInOne.push(2, 11);
        threeInOne.push(2, 12);
        threeInOne.push(2, 13);
        threeInOne.push(1, 14);
        threeInOne.pop(2);
    }
}
