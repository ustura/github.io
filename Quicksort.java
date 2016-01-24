import java.util.Random;
import java.util.Arrays;

public class Quicksort {

	public static void sortInPlace(int[] arr) {
		
		if (arr == null || arr.length == 1) return ;
		
		//pick the 1st element as the pivot, scan the entire array putting elements smaller than the pivot to the left of it,
		// and the bigger elements to the right.
		// 
		// then call proc on the left and right subarrays recursively (split at the pivot ndx)
		// 
		// example run : 5 4 3  => 3 4 5
//						 5 3 4    4 3 5
			int p = 0; //partition index
			qsort(p,arr,0,arr.length-1);
	}
	
	private static void qsort(int pNdx, int[] arr, int beg, int end) {

//		int beg = 1, end = arr.length - 1;

		if ( beg < end) {
			qCount++;
			System.out.print("\n qsort! p,b,e : " + pNdx + " " + beg + " " + end + " ");
			//0 1 3
			int p =  partition(pNdx,arr,beg,end); //mid = partition ndx
			if (p > beg) {
				qsort(0,arr,beg,p-1);
			}
			if (p < end) {
				qsort(p+1,arr,p+1,end);
			}
		}

	}
	

	public static int partCount = 0;
	public static int qCount = 0;
	
	
	private static int partition(int pNdx,int[] arr, int b, int e) {

		int left = b;
		int right = e;
		int v = arr[left];
//		Util.printArr(arr);
		
		System.out.print("partition! pNdx,b,e : " + pNdx + " " + b + " " + e + " \n");
		int i = left; //or l-1

		if (right > left) {
			int j = right;
			
			while(i<j) {
				while(arr[i] <= v)  { i++;
									if (i>=right) break;
								}
				while(arr[j] >= v)  { j--;
									if (j <= left) break;
								}
				swap(arr,i,j);
			}
			
			swap(arr,left,i);
		}
		
		return i;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static boolean isSorted(int[] arr) {
		boolean ret = false;

		int ndx = 1;
		for (; ndx< arr.length; ndx++) {
			if (arr[ndx-1] > arr[ndx])
			break;
		}
		
		if (ndx == arr.length) ret = true;
		
		return ret;
	}
	
	public static void main(String[] args)
	{
		int n = 50;
//		int[] arr = new int[n];
		
		Random rand = new Random();
		while ( n > 1) {
	//		arr[n-1] = rand.nextInt() % 100;
			n--;
		}

		//int[] arr2 = {0,-1,-1,-2};
//		int[] arr2 = {4,3,2,1,1,2,3,4};
//		int[] arr = {1,2,3,4};
		int[] arr = {5,4,3,2};

//		Util.printArr(arr2);

		Quicksort.sortInPlace(arr);
		System.out.println("*****************");
		Util.printArr(arr);
		System.out.println("isSorted:" + Quicksort.isSorted(arr) + " partitoned " + Quicksort.partCount + " qsorted " + Quicksort.qCount + " times!");
	}

}
