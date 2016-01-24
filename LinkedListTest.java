import java.util.*;

public class LinkedListTest {
	class LLNode {
		LLNode next = null;
		int val;

		public LLNode(int v)  { val = v; } 
	}

	public static LLNode head = null;

	public void dumpLL() {
		
		LLNode node = head;
		System.out.print("[");		
		while(node != null) {
			System.out.printf("%d, ", node.val);		
			node = node.next;
		} 
		System.out.println("]");		
	}
	
	private LLNode addNext(LLNode node, int v) {
		
		if (node == null) {
			node = new LLNode(v);
		}
		else {
			node.next = addNext(node.next,v);
		}
		
		return node;
	}
	
	public  void add(int v) {
		
		LLNode newNode = addNext(head,v);
		
		if (head == null) {
			head = newNode;
		}
	}

	static LLNode reverseHead = null;

	private LLNode reverse(LLNode node) {

		LLNode ret = node;
		
		System.out.println(" checking " + node.val);		
		if (node.next != null && node.next.next == null) {
			System.out.println(" ..reversing " + node.val);		
			if (reverseHead == null) {
				reverseHead = node.next;
			}
			//node.next.next = node;
			
			ret = node.next;
		}
		else {
			LLNode prevNode = reverse(node.next);
			System.out.println(" aNode " + prevNode.val);

			prevNode.next = node;
			node.next = null;
			
			ret = prevNode;
		}
		
		return ret;
	}
	
	Deque<LLNode> deq = new ArrayDeque<LLNode>();
	
	private void reverseStackVersion(LLNode node) {

		 while(node != null ) {
			 deq.offerFirst(node);
			 node = node.next;
		 }
		 
		 LLNode cur = deq.pollFirst();
		 reverseHead = cur;

		 while(deq.isEmpty() == false) {
			LLNode next = deq.pollFirst();
			cur.next = next;
			next.next = null;
			 
			cur = next;
		 }
		 
		 
	}
	
	public void reverse() {
		//reverseStackVersion(head);
		reverse(head);		
		head = reverseHead;
	}
	
	public static void main(String[] args) {
		
		LinkedListTest llTest = new LinkedListTest();
		
		for (int ndx=1; ndx < 4; ndx++) {
			llTest.add(ndx);
		}

		llTest.dumpLL();

		llTest.reverse();
		llTest.dumpLL();
	}
}
