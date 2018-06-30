package LinkedLists;

public class Intersection {

    /*

    Given two (singly) linked lists, determine if the two lists intersect.
    Return the intersecting node. Note that the intersection is defined
    based on reference, not value. That is, if the kth node of the first
    linked list is the exact same node (by reference) as the jth node
    of the second linked list, then they are intersecting.

    */

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int intersection(LinkedList.Node head1, LinkedList.Node head2) {
        boolean isIntersection = false;
        LinkedList.Node runner1 = head1;
        LinkedList.Node runner2 = head2;
        int len1 = 1;
        int len2 = 1;
        while (runner1.next != null) {
            runner1 = runner1.next;
            len1 += 1;
        }
        while (runner2.next != null) {
            runner2 = runner2.next;
            len2 += 1;
        }
        if (runner1 == runner2) isIntersection = true;

        if (isIntersection) {
            LinkedList.Node pri;
            LinkedList.Node sec;
            int diff;
            if (len1 > len2) {
                pri = head1;
                sec = head2;
                diff = len1 - len2;
            } else {
                pri = head2;
                sec = head1;
                diff = len2 - len1;
            }
            while (diff > 0) {
                pri = pri.next;
            }
            int index = 0;
            while (sec != null) {
                if (pri == sec) return index;
                pri = pri.next;
                sec = sec.next;
                index += 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.append(1);
        list1.append(2);
        list1.append(3);
        list1.append(4);
        list1.append(5);
        list1.append(6);
        list1.append(7);

        list2.append(1);
        list2.append(2);
        list2.append(3);

        LinkedList.Node runner1 = list1.getHead();
        LinkedList.Node runner2 = list2.getHead();

        while (runner1.data != 4) {
            runner1 = runner1.next;
        }
        while (runner2.next != null) {
            runner2 = runner2.next;
        }
        runner2.next = runner1;

        Intersection intersection = new Intersection();
        int intersectionIndex = intersection.intersection(list1.getHead(), list2.getHead());
        System.out.println(intersectionIndex);
    }

}
