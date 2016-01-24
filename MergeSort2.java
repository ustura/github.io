import java.util.*;

public class MergeSort2 {

// Sort an array using a simple but inefficient merge sort.
public static int[] mergeSortSimple( int[] data ){
	if( data.length < 2 ){
	return data;
	}

	// Split the array into two subarrays of approx equal size.
	int mid = data.length / 2;
	int[] left = new int[ mid ];
	int[] right = new int[ data.length - mid ];
	System.arraycopy( data, 0, left, 0, left.length );
	System.arraycopy( data, mid, right, 0, right.length );
	// Sort each subarray, then merge the result.
	mergeSortSimple( left );
	mergeSortSimple( right );

	return merge( data, left, right );
}

// Merge two smaller arrays into a larger array.
private static int[] merge( int[] dest, int[] left, int[] right ){

int dind = 0;
int lind = 0;
int rind = 0;

// Merge arrays while there are elements in both
while ( lind < left.length && rind < right.length ){
	if ( left[ lind ] <= right[ rind ] ){
	dest[ dind++ ] = left[ lind++ ];
	} else {
	dest[ dind++ ] = right[ rind++ ];
	}
}

// Copy rest of whichever array remains
while ( lind < left.length )
	dest[ dind++ ] = left[ lind++ ];
while ( rind < right.length )
	dest[ dind++ ] = right[ rind++ ];

return dest;
}

	public static void main(String[] args) {

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
		
		int[] sorted = MergeSort2.mergeSortSimple(arr);
		
		System.out.println("\nMERGE SORTED");
		for (int i:sorted) {
			System.out.print(i + " ");
		}
		System.out.println();
}
}
