import java.util.Arrays;
import java.util.ArrayList;

public class MergeArrays {

 //extra space
	public <T extends Comparable> T[] merge1(T[] arr1, T[] arr2) {
	
	 T[] retArr = null;

	 return retArr;	
	}

	public static int[] merge1(int[] arr1, int[] arr2) {
    /*
     * Assumption : arrays are sorted
     *  while both arrays are non-empty
     *     compare elements at front of each,
     *     copy smaller (or larger) to dest
     *     increment dest ndx
     *     increment src arr ndx
     * 
     *    copy remaining contents of non-empty arr into dest
     * 
     */
     	
	 int[] retArr = null;

	 retArr = new int[arr1.length + arr2.length];
	 
	 int ndx1 = 0;
	 int ndx2 = 0;
	 int ndxSrc = 0;
	 int ndxDest = 0;
	 int srcArr[] = null;
	 
	 while (ndx1 < arr1.length && ndx2 < arr2.length ) {
		 if (arr1[ndx1] < arr2[ndx2]) {
			retArr[ndxDest] = arr1[ndx1++];
		 }
		 else {
			retArr[ndxDest] = arr2[ndx2++];
		 }
		 ndxDest ++;
	 }

	System.out.println("ndx1: "+ ndx1);
	 if (ndx1 < arr1.length ) {
		 //System.arrayCopy(retArr,ndxDest, arr1,ndx1,arr1.length - ndx1 - 1);
		 while (ndx1 < arr1.length) {
				retArr[ndxDest++] = arr1[ndx1++];
			}
	 }
	 
	System.out.println("ndx2: "+ ndx2);
	 if (ndx2 < arr2.length ) {
		 while (ndx2 < arr2.length) {
				retArr[ndxDest++] = arr2[ndx2++];
			}
	 }
	 
	 return retArr;	
	}

	public static int[] merge2(int[] arr1, int[] arr2) {
    /*  
     * Assumption : both arrays are sorted
     * In-place merging:
     *   -1 5 7
     *    4 6 10 12
     * 
     *  pick the shorter array as the source
     *  
     *  init src and dst ndx = last elements indexes of both
     *  init putNdx = dstNdx - 1
     *     compare the last elements of each
     *        while src el < dest el, decrement dest ndx , limit it to 0
     
     *       if dstNdx >= 0 
     *     insert current src element after dstndx ( essentially shifting dest elements to left by one)
     *       else 
     *      insert before dstNdx
     *     decrement src ndx by one
     * 
     *  Time complexity = O(n)
     *  Space complexity = N + M for input arrays, and a temp location
     * */
     

     int[] src = arr1.length < arr2.length ? arr1:arr2;     
     int[] dest = arr1.length < arr2.length ? arr2:arr1;
     
     int srcNdx = src.length - 1;
     int dstNdx = dest.length - 1;
     
     
     while (srcNdx > -1) {
		 while( dstNdx > -1 && src[srcNdx] < dest[dstNdx])  {
			  dstNdx  = dstNdx > -1 ? dstNdx-1 : -1;
		      System.out.println("--> dstNdx" + dstNdx );
		  }

		System.out.println("Inserting " + src[srcNdx] + " after loc: " + dstNdx );
		dest = insert(dest,dstNdx, src[srcNdx]); 
	  
		Util.printArr(dest);
  	    srcNdx --;
	 } //while src
     
	 return dest;
	 
    }
    
    //insert aVal into dst[dstNdx+1]
    //Can insert as last element . (ndx = length-1)
    private static int[]  insert(int[] dst, int dstNdx, int aVal) {
	
	   //  dst: 1 2 3  10 11 12 13, 
	   //  target: 1 2 3 _ 
	   //  dstNdx: 2
	   //  9
	    //target  1 2 3 _ _ 
	    //target  1 2 3 9 _ 
	    System.out.println("dst.length" + dst.length );
		int target[] = new int[dst.length + 1 ];

		if (dstNdx >= 0) {
			System.arraycopy(dst,0, target,0, dstNdx + 1); //1st part
		}
		
		//Util.printArr(target);
		target[dstNdx + 1] = aVal;
		System.arraycopy(dst,dstNdx + 1, target, dstNdx + 2, dst.length - dstNdx - 1); //2nd part

		return target;
	}
    
	
	public static void main(String[] args) {
		
		int[] arr1 = { -5, -1, 2, 7, 16 };
		int[] arr2 = { 1, 5, 6, 8, 9,12,13,15 };
		//int[] arr2 = { 15 };
		
		int[] ret = MergeArrays.merge2(arr1,arr2);
		
		Util.printArr(ret);
	}
}
