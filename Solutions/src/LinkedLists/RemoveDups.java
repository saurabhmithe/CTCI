package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

    /*

    Write code to remove duplicates from an unsorted li nked list. FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?

     */

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public void removeDups(LinkedList.Node head) {
        Set<Integer> set = new HashSet<>();
        LinkedList.Node current = head;
        LinkedList.Node prev = null;
        while (current != null) {
            if (!set.contains(current.data)) {
                set.add(current.data);
                prev = current;
                current = current.next;
            } else {
                prev.next = current.next;
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {

        // Create a custom Linked List
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(6);

        // Remove duplicates from the list
        RemoveDups removeDups = new RemoveDups();
        removeDups.removeDups(list.getHead());

        // Print the updated list
        LinkedList.Node current = list.getHead();
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}
