package LinkedLists;

public class KthToLast {


    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int kthToLast(LinkedList.Node head, int k) {

        if (head == null || k == 0) return -1;

        LinkedList.Node first = head;
        LinkedList.Node second = head;

        while (k > 0) {
            if (first == null) return -1;
            first = first.next;
            k -= 1;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.data;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);

        KthToLast toLast = new KthToLast();
        int kLast = toLast.kthToLast(list.getHead(), 1);
        System.out.println(kLast);
    }
}
