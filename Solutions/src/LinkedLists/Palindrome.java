package LinkedLists;

public class Palindrome {

    /*

    Implement a function to check if a linked list is a palindrome.

    */

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public boolean palindrome(LinkedList.Node head) {
        LinkedList.Node fast = head;
        LinkedList.Node slow = head;
        LinkedList.Node end = head;
        while (fast.next != null) {
            fast = fast.next.next;
            end = slow;
            slow = slow.next;
        }
        if (fast != null) {
            end = slow;
            slow = slow.next;
        }
        LinkedList.Node prev = null;
        LinkedList.Node next;
        LinkedList.Node current = slow;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        end.next = prev;
        LinkedList.Node runner = head;
        while (prev != null) {
            if (prev.data != runner.data) return false;
            runner = runner.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(3);
        list.append(2);
        list.append(1);

        Palindrome palindrome = new Palindrome();
        boolean isPalindrome = palindrome.palindrome(list.getHead());
        System.out.println(isPalindrome);
    }
}
