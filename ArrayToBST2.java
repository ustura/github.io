import java.util.Random;
import java.util.Arrays;

public class ArrayToBST2 {

	private class Node {
		Node right;
		Node left;
		int val;
		
		public Node(int aVal) {
			 val = aVal;
		}
	}
	
	Node head = null;

	//Pseudo
	//assump: arr is sorted.
	// split arr in the middle. make the left and right halves subtrees of the node made by the middle element.
	// do this recursively on each half.
	//   Node head = makeBst(mid,arr,0,N-1);

	public void makeBST(int[] arr) {
		int N = arr.length;
		head = makeBST(arr[N/2],arr,0,N-1);
	}
	
	private Node makeBST(int aRootVal,int[] arr, int beg,int end) {
		
		if (end < beg ) return null;
		
		Node ret = new Node(aRootVal);
		
		//base case : beg == end
		int mid = beg + (end-beg)/2;
		
		if (beg == end) {
			Node child = new Node(arr[mid]);

			if (arr[mid]<=aRootVal ) 
				ret.left = child;
			   else
				ret.right = child;
		}
		else {
			Node right = makeBST(arr[mid],arr,beg, mid - 1); 
			Node left = makeBST(arr[mid],arr,mid + 1,end); 
		}
		
		return ret;
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

//		Arrays.sort(arr);
		//Util.printArr(arr);
		//System.out.println("*****************");

		ArrayToBST aBST = new ArrayToBST();
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
		
		aBST.makeBST(arr2);

		System.out.println("*****************");
		aBST.listInOrder();
	}
}
