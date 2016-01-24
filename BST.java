import java.util.Random;
import java.util.Deque;
import java.util.ArrayDeque;

public class BST {
	
	private class Node {
		Node right;
		Node left;
		int val;
		
		public Node(int aVal) {
			 val = aVal;
		}
	}
	
	Node head = null;
	
	public void add(int aVal) {
		
		Node node = addNode(head,aVal);
		
		if (head == null) head = node;
	}
	
	private Node addNode(Node node, int val) {
		
		 if (node  == null) {
			  node = new Node(val);
		 }
		 else if (val  < node.val) {
			 node.left = addNode(node.left,val);
		 }
		 else {
			node.right = addNode(node.right,val);			 
		 }
		 
		 return node;
	}
	
	public int getCount() {
		return getCountUnder(head);
	}
	
	private int getCountUnder(Node node) {
		 
		 int ret = 0;

		 if (node != null ) {
			 ret = getCountUnder(node.left) + getCountUnder(node.right) + 1;
		 }
		 
		 return ret;
	}
	
	public void inOrder() {
		 //inOrder(head);
		 inOrderIterative(head);
	}

	public void preOrder() {
		 preOrder(head);
	}

	Deque<Node> deq = new ArrayDeque<Node>();

	public void levelOrder() {

		 deq.clear();
 		 deq.push(head);

		 //levelOrder(head);
		 zigzagOrder(head);
		 
		 while(deq.size()>0) {
			 Node node = deq.pollLast();
			 if (node != null) {
				System.out.println( node.val + " ");
			}
		 }
	}

	private void inOrderIterative(Node node) {

		deq.clear();
//		deq.push(node);

		do{
			//System.out.println( "Pushing: " + node.val + " ");
			while (node != null){
				//deq.push(node);
				deq.offerFirst(node);
				node = node.left;
			}
			
			node = deq.pollFirst();
			System.out.println( node.val + " ");

			node = node.right;
			while (node == null){
				//node = deq.pop();
				node = deq.pollFirst();
				if (node != null) {
					//System.out.println( "Popped: " + node.val + " ");
					System.out.println( node.val + " ");
					node = node.right;
				}
			}
				
			} while (node != null) ;
	}	
	
	private void inOrder(Node node) {
		
		if (node == null) {
			return ;
		}
		
		inOrder(node.left);
		System.out.println(node.val);
		inOrder(node.right);
	}

	private void preOrder(Node node) {
		
		if (node == null) {
			return ;
		}
		
		System.out.println(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}

	private void levelOrder(Node node) {
		
		if (node == null) {
			return ;
		}
		
		if (node.left != null) {
			//deq.addLast(node.left);
			deq.push(node.left);
		}
		if (node.right != null) {
			//deq.addLast(node.right);
			deq.push(node.right);
		}
		levelOrder(node.left);
		levelOrder(node.right);
	}

	boolean zig = false;
	private void zigzagOrder(Node node) {
		
		if (node == null) {
			return ;
		}
		
		if (zig) {
			if (node.left != null) {
				//deq.addLast(node.left);
				deq.push(node.left);
			}
			if (node.right != null) {
				//deq.addLast(node.right);
				deq.push(node.right);
			}
		}
		else {
			if (node.right != null) {
				//deq.addLast(node.right);
				deq.push(node.right);
			}
			if (node.left != null) {
				//deq.addLast(node.left);
				deq.push(node.left);
			}
		}
		
		levelOrder(node.left);
		levelOrder(node.right);
		
		zig = (zig == true ? false:true);
	}
	
	public boolean isBST() {
		//return true if:
		// 		  the max of the left subtree is less than or equal to the root
		// AND    the min of the righ subtree is more than the root
		//		false otherwise
		System.out.println("isBST: head [" + head.val +"]");

		return (isBST(head,Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	private boolean isBST(Node node, int maxLeft, int minRight) 
	{
		if (node == null) return true;
		
//		System.out.println("isBST:  [" + node.val +"] maxLeft [" +maxLeft+ "] minRight [" + minRight+ "]");

		if (node.val < maxLeft || node.val >= minRight) {
			return false;
		}
		
		//System.out.println("isBST: node val [" + node.val +"]");

		return ( isBST(node.left, maxLeft, node.val) && 
				  isBST(node.right, node.val, minRight) );
	}
	
	public static void main(String[] args)
	{
		BST aBST = new BST();

/*		
		int n = 5;
		Random rand = new Random();
		while ( n > 0) {
				aBST.add(rand.nextInt() % 100);
				try {
					Thread.sleep(20);
					n--;
				}
				catch(Exception e ) {
				}
		}
	*/
		aBST.add(5);
		aBST.add(10);
		aBST.add(3);
		aBST.add(4);
		aBST.add(2);
		aBST.add(7);
		aBST.add(20);
		
		System.out.println("Count is: " + aBST.getCount());
		System.out.println("inOrder*************************");
		aBST.inOrder();

//		System.out.println("preOrder*************************");
//		aBST.preOrder();

//		System.out.println("zigZagOrder*************************");
//		aBST.levelOrder();


	//	System.out.println("Integer max: " + Integer.MAX_VALUE);
//		System.out.println("Integer min: " + Integer.MIN_VALUE);
		System.out.println("this BT is a BST: " + aBST.isBST());
		
		
	}
	 
}
