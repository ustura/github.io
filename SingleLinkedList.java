import java.util.Random;
public class SingleLinkedList {

	private class Node {
		public Node next = null;
		public int val;
		
		public Node(int aVal) {
			val = aVal;
		}
	}
	
	Node head = null;
	
	public SingleLinkedList() {
	}
	
	public void add(int aVal) {
		if (head == null) {
			head = new Node(aVal);
		}
		else {
			Node node = head;
			
			while(node.next != null) {
				node = node.next;
			}
			node.next = new Node(aVal);
		}
	}
	
	public void print() {
		Node node = head;
		
		while(node != null) {
			System.out.println("," + node.val );
			node = node.next;
		}
	}
	
	public static void main(String[] args)
	{
		int n = 10;
		Random rand = new Random();
		SingleLinkedList aBST = new SingleLinkedList();
		
		while ( n > 0) {
				int k = rand.nextInt() % 100;
				System.out.println("Adding: " + k );
				aBST.add(k);
				n--;
		}
		
		System.out.println("single LL: " );
		aBST.print();
	}

}
