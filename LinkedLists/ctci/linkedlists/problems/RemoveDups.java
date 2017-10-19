package ctci.linkedlists.problems;

import java.util.HashSet;

import ctci.linkedlists.core.LinkedList;
import ctci.linkedlists.core.LinkedList.Node;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * @author saurabh_mithe
 *
 */
public class RemoveDups {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		initializeLinkedList(list);
		removeDuplicatesUsingBruteForce(list.getHead());
		list.print();
		
		list.clear();
		initializeLinkedList(list);
		removeDuplicatesUsingBuffer((list.getHead()));
		list.print();
	}

	private static void removeDuplicatesUsingBruteForce(Node head) {
		Node p1 = head;

		while (p1.getNext().getNext() != null) {
			Node p2 = p1.getNext();
			Node previous = p1;
			while (p2 != null) {
				if (p2.getData() == p1.getData()) {
					previous.setNext(p2.getNext());
					previous = p2;
				}
				p2 = p2.getNext();
				previous = previous.getNext();
			}
			p1 = p1.getNext();
		}
	}

	private static void removeDuplicatesUsingBuffer(Node head) {
		HashSet<Integer> uniqueNodeData = new HashSet<Integer>();

		Node pointer = head;
		Node previous = pointer;
		while (pointer != null) {
			if (!uniqueNodeData.contains(pointer.getData())) {
				uniqueNodeData.add(pointer.getData());
				previous = pointer;
			} else {
				previous.setNext(pointer.getNext());
			}
			pointer = pointer.getNext();
		}
	}
	
	private static void initializeLinkedList(LinkedList list) {
		list.append(10);
		list.append(12);
		list.append(45);
		list.append(32);
		list.append(99);
		list.append(36);
		list.append(32);
		list.append(43);
		list.append(12);
	}
}
