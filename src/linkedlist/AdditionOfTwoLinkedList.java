package linkedlist;

public class AdditionOfTwoLinkedList {

	/*
	 * 1 -> 2 -> 3
	 * 4 -> 5 -> 6
	 * 
	 * 5 -> 7 -> 9
	 * 
	 * */
	
	private static Node performAdditionOperation(Node head1, Node head2) {
		Integer data1 = getNumberFromList(head1);
		Integer data2 = getNumberFromList(head2);
		
		Integer result = data1+data2;
		
		Node head = convertNumberToList(String.valueOf(result));
		return head;
	}
	
	private static Integer getNumberFromList(Node head) {
		StringBuilder builder = new StringBuilder();		
		while(head != null) {
			builder.append(head.getData());
			head = head.getNext();
		}
		return Integer.parseInt(builder.toString());
	}
	
	private static Node convertNumberToList(String number) {
		Node node = null;
		Node head = null;
		for(int i =0 ; i< number.length(); i++) {
			if(i == 0) {
				node = addNumberInList(Integer.valueOf(String.valueOf(number.charAt(i))), null);
				head = node;
			}
			else node = addNumberInList(Integer.valueOf(String.valueOf(number.charAt(i))), node);			
		}
		return head;
	}
	
	private static Node addNumberInList(Integer data, Node prev) {
		Node node = new Node(data, null);
		if(prev != null)
		prev.setNext(node);
		return node;
	}
	
	public static void main(String[] args) {
		
		Node node3 = new Node(0, null);
		Node node2 = new Node(0, node3);
		Node node1 = new Node(1, node2);
		
		Node node7 = new Node(0, null);
		Node node6 = new Node(0, node7);
		Node node5 = new Node(0, node6);
		Node node4 = new Node(4, node5);
		
		Node result = performAdditionOperation(node1, node4);
		
		printList(result);
	}

	private static void printList(Node node) {
		while(node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}
	
	static class Node{

		private Integer data;
		private Node next;

		public Node(Integer data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}		
	}
}