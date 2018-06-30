package LinkedLists;

public class Partition {

    /*

    Write code to partition a linked list around a value x, such that all nodes less than x
    come before all nodes greater than or equal to x. lf x is contained within the list,
    the values of x only need to be after the elements less than x (see below).

    The partition element x can appear anywhere in the "right partition";
    it does not need to appear between the left and right partitions.

    EXAMPLE
    Input: 3 -> 5 -> 8 -> 5 ->10 -> 2 -> 1[partition=5)
    Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

     */

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public LinkedList.Node partition(LinkedList.Node head, int value) {
        LinkedList.Node smallerHead = null;
        LinkedList.Node smallerRunner = null;
        LinkedList.Node largerHead = null;
        LinkedList.Node largerRunner = null;
        LinkedList.Node next = head.next;

        while (head != null) {
            head.next = null;
            if (head.data < value) {
                if (smallerHead == null) {
                    smallerHead = head;
                    smallerRunner = smallerHead;
                } else {
                    smallerRunner.next = head;
                    smallerRunner = smallerRunner.next;
                }
            } else {
                if (largerHead == null) {
                    largerHead = head;
                    largerRunner = largerHead;
                } else {
                    largerRunner.next = head;
                    largerRunner = largerRunner.next;
                }
            }
            head = next;
            if (next != null) next = next.next;
        }
        smallerRunner.next = largerHead;
        return smallerHead;
    }


    public static void main(String[] args) {

        // Create a custom Linked List
        LinkedList list = new LinkedList();
        list.append(3);
        list.append(5);
        list.append(8);
        list.append(5);
        list.append(10);
        list.append(2);
        list.append(1);

        Partition par = new Partition();
        LinkedList.Node head = par.partition(list.getHead(), 5);

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

}
