package LinkedLists;

public class DeleteMiddleNode {

    /*

    Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
    not necessarily the exact middle) of a singly linked list, given only access to that node.

    EXAMPLE
    Input: the node c from the linked list a - >b- >c - >d - >e- >f
    Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f

     */

    public void deleteMiddleNode(LinkedList.Node pointer) {
        if (pointer != null && pointer.next != null) {
            pointer.data = pointer.next.data;
            pointer.next = pointer.next.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);
        list.append(60);
        list.append(70);

        LinkedList.Node runner = list.getHead();
        for (int i = 0; i < 3; i++) {
            runner = runner.next;
        }

        DeleteMiddleNode deleteNode = new DeleteMiddleNode();
        deleteNode.deleteMiddleNode(runner);

        LinkedList.Node current = list.getHead();
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}
