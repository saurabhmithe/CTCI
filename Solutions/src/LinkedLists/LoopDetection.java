package LinkedLists;

public class LoopDetection {

    /*

    Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.

    DEFINITION:
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
    so as to make a loop in the linked list.

    EXAMPLE
    Input: A -) B -) C -) 0 -) E -) C [thesameCasearlier)
    Output: C

    */

    public int loopDetection(LinkedList.Node head) {
        if (head == null || head.next == null) return -1;
        LinkedList.Node fast = head.next;
        LinkedList.Node slow = head;

        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == slow) {
            int index = 0;
            slow = slow.next;
            LinkedList.Node runner = head;
            while (slow != runner) {
                slow = slow.next;
                runner = runner.next;
                index += 1;
            }
            return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        LinkedList.Node runner = list.getHead();
        LinkedList.Node loop = null;
        while (runner.next != null) {
            runner = runner.next;
            loop = runner;
        }

        list.append(5);
        list.append(6);
        list.append(7);

        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = loop;

        LoopDetection loopDetection = new LoopDetection();
        int loopIndex = loopDetection.loopDetection(list.getHead());
        System.out.println(loopIndex);
    }

}
