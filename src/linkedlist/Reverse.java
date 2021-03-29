package linkedlist;

public class Reverse {

	/*
	 * 
	 * 1 -> 2 -> 3 -> null
	 * 3 -> 2 -> 1 -> null 
	 * 
	 * */
	
	private static Node reverseLinkedList(Node head) {
		Node current = head;
		Node prev = null;
		Node next = null;
		
		while(current  != null) {
			next = current.getNext(); // 2 3 null
			current.setNext(prev); // null 1 2
			prev = current; // 1 2 3
			current = next; // 2 3 null
		}
		head = prev;
		return head;
	}
	
	public static void main(String[] args) {

		Node node3 = new Node("3",null);
		Node node2 = new Node("2",node3);
		Node node1 = new Node("1",node2);
		
		Node head=reverseLinkedList(node1);
		
		printList(head);
	}

	private static void printList(Node head) {
		while(head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}
	
}

class Node{
	private String data;
	private Node next;
	
	public Node(String data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}