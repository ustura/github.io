import java.util.Random;
import java.util.List;

public class Util {

 public static <T> void printList(List<T> list) {
	System.out.println("list.size:" + list.size());
	
	for (int ndx = 0; ndx < list.size(); ndx ++) {
		System.out.println("ndx :" + ndx + ": val [" + list.get(ndx) + "]");
	 }
  }

 public static <T> void printArr(T[] arr) {
	System.out.println("arr.length:" + arr.length);
	
	for (int ndx = 0; ndx < arr.length; ndx ++) {
		System.out.print(arr[ndx] + " ");
	 }
	System.out.println();
  }
  
   public static void printArr(int[] arr) {
	System.out.println("arr.length: " + arr.length );
	
	for (int ndx = 0; ndx < arr.length; ndx ++) {
		System.out.print(arr[ndx] + " ");
	 }
	System.out.println();
  }

	public static int[][] get2DMaze(int aRowCnt, int aColCnt) {
		
		 int [][] maze = new int[aRowCnt][];
		 Random rand = new Random();

		 int rowNdx = 0;
		 for (int[] aRow: maze) {
			  aRow = new int[aColCnt];
			  
			  for (int aColNdx = 0; aColNdx < aColCnt; aColNdx++) {
				   aRow[aColNdx] = Math.abs(rand.nextInt() % 2);
				   //System.out.print(aRow[aColNdx] + " ");
			  }

			 maze[rowNdx] = aRow;
			  
	         //System.out.println();
			 rowNdx ++;
		 }
			
		 return maze;
	}
}
