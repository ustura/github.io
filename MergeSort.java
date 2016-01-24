import java.util.*;


public class MergeSort {


//public static int[] merge(int[] l, int[] r) {
public static int[] merge(int[] arr, int left, int mid, int right ) {
	
	
	int[] leftArr = new int[mid - left + 1];
	System.arraycopy(arr,left,leftArr,0,mid - left);
	leftArr[leftArr.length-1] = Integer.MAX_VALUE;

	int[] rightArr = new int[right - mid +1];
	System.arraycopy(arr,mid,rightArr,0,right - mid);
	rightArr[rightArr.length-1] = Integer.MAX_VALUE;

	int[] ret = new int[right - left];

	int lNdx = 0;
	int rNdx = 0;
	int retNdx = 0;
	
	while (retNdx < ret.length ) {
	// while (lNdx < left.length  && rNdx < right.length) {
		 if ( leftArr[lNdx] < rightArr[rNdx] ) {
			 ret[retNdx++] = leftArr[lNdx++];
		 }
		 else {
			 ret[retNdx++] = rightArr[rNdx++];
		 }
	 }

	return ret;
	
}

private static int[] mergeSort(int[] arr, int left, int right) {

int[] ret = null;
	 if ( left < right ) {
	  
	  int mid = (left + right ) / 2;
	  
	  mergeSort(arr,left,mid);
	  mergeSort(arr,mid+1, right);
	  
	  ret = merge(arr,left,mid,right);
	}
	  return ret;
  
}

public static int[] sort(int[] arr) {
	
	 mergeSort(arr,0,arr.length-1);
	 return arr;
}


	public static void main(String[] args) {

/*
		int n = Integer.parseInt(args[0]);
		int[] arr = new int[n];
		
		Random rand = new Random();
		int r ;
		while ( n > 0) {
			r = rand.nextInt() % 100;
			System.out.print(r + " ");
			arr[n-1] = r;
			n--;
		}
		
		int[] sorted = MergeSort.sort(arr);
		
		System.out.println("\nMERGE SORTED");
		for (int i:sorted) {
			System.out.print(i + " ");
		}
		System.out.println();
*/	 
	int[] list1 = { 5,10,20,40, 41,42,43,44,45 };
	int[] list2 = { 4,7,16,18 };
	int[] all = { 4,7,16,18, 5,10,20,40, 41,42,43,44,45 };
	
	//int[] ret = MergeSort.merge(list1,list2);
	int[] ret = MergeSort.merge(all,0,4,all.length-1);
	
	for( int i: all ){ 
		System.out.print(i + " " );
	}
	System.out.println();
	} //main
}		
