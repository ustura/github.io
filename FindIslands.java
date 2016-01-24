/*
Question: You are given a 2d array filled with 1s and 0s. A 0 represents water and a 1 represents land (see figure below). 
* Connected 1s represent a single island. 
* Write a function to find the number of islands from a given 2d array.
* 
* My questions:  Is diagonal connectedness required ? Or only lateral ?  NO
*  How big can the 2d array be?  MAX 100 x 100
* 
* My Assumptions; the maze is bounded by the row,col size.
* 
*/


public class FindIslands {
	
	private int ROW_CNT = 5; //number of rows
	private int COL_CNT = 5;
	
	private int[][] mMaze = null;

	public FindIslands(int aRow, int aCol) {
		mMaze = Util.get2DMaze(aRow,aCol);

		ROW_CNT = aRow;
		COL_CNT = aCol;

	}
	

	private int visitSelfAndNeighbours(int aRow, int aCol, int aMarkVal) {

		int totalOnes = 0;
		
		if (aRow <0 || aRow > ROW_CNT-1 || aCol < 0 || aCol > COL_CNT-1) {
			return 0;
		}
		
		if (mMaze[aRow][aCol] == 1) {
			totalOnes = 1;
			mMaze[aRow][aCol] = aMarkVal;
			totalOnes += visitSelfAndNeighbours(aRow-1, aCol,aMarkVal); //Top
			totalOnes += visitSelfAndNeighbours(aRow, aCol+1,aMarkVal); //Right
			totalOnes += visitSelfAndNeighbours(aRow+1, aCol,aMarkVal); //Down
			totalOnes += visitSelfAndNeighbours(aRow, aCol-1,aMarkVal); //Left
		}
		
 	   //System.out.println("totalOnes: " + totalOnes);
		return totalOnes  ;
		
	}

/**
 */
	public int findIslandCount() {

	 int mark = 2;
	 int aRowNdx  = 0;
	 
	 for (int[] aRow: mMaze) {
		  for (int aColNdx = 0; aColNdx < aRow.length; aColNdx++) {

			  int ones = visitSelfAndNeighbours(aRowNdx,aColNdx,mark);
	
			   printMaze();
			   
			  if (ones >= 1) {
				  System.out.println("Found an island id: " + mark);
				  mark ++;
			  }
		  }

		  aRowNdx ++;
	  }//for aRow

	return mark - 2;
	}

	public void printMaze() {
	 for (int[] aRow: mMaze) {
			assert(aRow != null);
		  for (int aColNdx = 0; aColNdx < COL_CNT; aColNdx++) {
			   System.out.print(aRow[aColNdx] + " ");
		  }
	   System.out.println();
	 }
     System.out.println("------------------------");

	}
	public static void main(String[] args) {
		
		FindIslands fi = new FindIslands(5,5);
		
		System.out.printf("There are [%d] islands\n", fi.findIslandCount());
		
		fi.printMaze();
	}
}
