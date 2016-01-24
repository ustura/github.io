import java.util.Random;
import java.util.Arrays;

public class ArrayToBST {

	private class Node {
		Node right;
		Node left;
		int val;
		
		public Node(int aVal) {
			 val = aVal;
		}
	}
	
	Node head = null;

	public void makeBST(int[] arr) {
		//inp: sorted arr
		// take the middle element, make it the head of BST
		// call makeBST on left half, on right half recursively
		// make returning nodes head's left and right children 
	
			int mid = arr.length/2;

			System.out.println("head for:[" + mid + "] val :[" + arr[mid] + "]");
//			head = new Node(arr[mid]);
			
	//		head.left = makeBST(head,arr,0,Math.max(0,mid-1));
		//	head.right = makeBST(head,arr,Math.min(arr.length-1,mid+1), arr.length-1);
			
			head = makeBST(head,arr,0, arr.length-1);		

	}	
	private Node makeBST(Node parent, int[] arr, int st, int end) {
		
		// will return the root of the subtree created within.
		 // end-st == 0 // if arr.length == 1 , create a single node, make it left/right child of parent depending.
		// end - st == 1 if arr.length == 2 , create two nodes, make them left/right children of parent
		//if end - st > 1, 
		//	divide arr into two, st, mid, end  . 
		//	  
		//call self on each half. make returning nodes left/right children of parent
		//else - return null
		
		System.out.println("st:[" + st + "] end :[" + end + "]");
		
		Node retNode = null;
		
		if ( st < 0 || st > arr.length || end < 0 || end > arr.length  )  {
			return null;
		}
		
		if ( (end - st) > 0) {
			int mid = st + ((end - st)/2);

			System.out.println("mid [" + mid + "] creating Node for val[" + arr[mid] + "]");
			retNode = new Node(arr[mid]);
			
//			retNode.left = makeBST(retNode,arr,st,Math.max(st,mid-1));
//			retNode.right = makeBST(retNode,arr,Math.min(end,mid+1), end);
			retNode.left = makeBST(retNode,arr,st,mid-1);
			retNode.right = makeBST(retNode,arr,mid+1, end);
			
			if (parent == null) {
				parent = retNode;
			}
		
		}
		else  if ((end - st) == 0) {
			System.out.println("st equals end [" + st + "] creating Node for val[" + arr[st] + "]");
			retNode = new Node(arr[st]);
		}
		
		
		return retNode;
	}	
	
	public void listInOrder() {
		 inOrder(head);
	}
	
	private void inOrder(Node node) {
		
		if (node == null) {
			return ;
		}
		
		inOrder(node.left);
		System.out.println(node.val);
		inOrder(node.right);
	}

	
	public static void main(String[] args)
	{
		int n = 10;
		int[] arr = new int[n];
		
		Random rand = new Random();
		while ( n > 1) {
			arr[n-1] = rand.nextInt() % 100;
			n--;
		}

		Arrays.sort(arr);
		Util.printArr(arr);
		System.out.println("*****************");

		ArrayToBST aBST = new ArrayToBST();
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
		
		aBST.makeBST(arr);

		System.out.println("*****************");
		aBST.listInOrder();
	}
}
