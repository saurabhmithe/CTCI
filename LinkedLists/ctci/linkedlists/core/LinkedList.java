package ctci.linkedlists.core;

public class LinkedList {

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public void print() {
			System.out.print(this.data + "  ");
		}

		public int getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	private Node head;
	private boolean error;

	public LinkedList() {
		head = null;
	}

	public void insert(int data, int position) {
		if (position <= getListLength() && position >= 0) {
			Node newNode = new Node(data);
			Node currentNode = head;

			if (position == 0) {
				newNode.next = head;
				head = newNode;
			} else {
				for (int i = 1; i < position; i++) {
					currentNode = currentNode.next;
				}
				Node temp = currentNode.next;
				currentNode.next = newNode;
				newNode.next = temp;
			}
		} else {
			setError();
			System.out.println("Unable to insert " + data + ".Invalid position");
		}
	}

	public void append(int data) {
		Node newNode = new Node(data);
		Node currentNode = head;
		if (head != null) {
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		} else {
			head = newNode;
		}
	}

	public Node moveToEndNode(Node startingNode) {
		while (startingNode.next != null) {
			startingNode = startingNode.next;
		}
		return startingNode;
	}

	public void trimToSize(int size) {
		Node currentNode = head;
		if (size < 0) {
			setError();
			System.out.println("Size cannot be negative.");

		} else if (size > getListLength()) {
			setError();
			System.out.println("The list lenght is smaller than the trim size. No changes will be done.");
		} else if (size == 0) {
			head = null;
		} else {
			for (int i = 1; i < size; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = null;
		}
	}

	public int getElementAtPosition(int position) {
		if (position < 0 || position > getListLength() - 1) {
			setError();
			System.out.println("Unable to delete. Invalid position.");
			return -1;
		} else {
			Node currentNode = head;
			for (int i = 1; i < position; i++) {
				currentNode = currentNode.next;
			}
			return currentNode.data;
		}
	}

	public void deleteAtPosition(int position) {
		if (position < 0 || position > getListLength() - 1) {
			setError();
			System.out.println("Unable to delete. Invalid position.");
		} else {
			Node currentNode = head;
			if (position == 0) {
				head = head.next;
			} else {
				for (int i = 1; i < position; i++) {
					currentNode = currentNode.next;
				}
				currentNode.next = currentNode.next.next;

			}
		}
	}

	public void reverse() {
		Node currentNode = head;
		Node previousNode = null;

		while (currentNode != null) {
			Node nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		head = previousNode;
	}

	public void reverseRecursion(Node node) {
		if (node.next == null) {
			this.head = node;
			return;
		}
		reverseRecursion(node.next);
		Node prev = node.next;
		prev.next = node;
		node.next = null;
	}

	public Node getHead() {
		return head;
	}

	public int getListLength() {
		Node currentNode = head;
		int length = 0;
		while (currentNode != null) {
			length += 1;
			currentNode = currentNode.next;
		}
		return length;
	}

	public void print() {
		Node currentNode = head;
		while (currentNode != null) {
			currentNode.print();
			currentNode = currentNode.next;
		}
		System.out.println("\n");
	}

	public void setError() {
		this.error = true;
	}

	public boolean isError() {
		return error;
	}
	
	public void clear() {
		head = null;
	}
}
