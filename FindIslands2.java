
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


public class FindIslands2 {
	
	private int ROW_CNT = 5; //number of rows
	private int COL_CNT = 5;

	private int[][] mMaze = null;
	private Cell[][] mCellMaze = null;

	private class Cell {
		int row,col;
		int islandID = 0;
		
		public Cell(int x, int y, int aVal) {
			row = x;
			col = y;
			islandID = aVal;
		}
	}
	
	public FindIslands(int aRow, int aCol) {
		mMaze = Util.get2DMaze(aRow,aCol);
		mCellMaze = new Cell[aRow][aCol] ;

		ROW_CNT = aRow;
		COL_CNT = aCol;

	}
/*
	//Search with BFS:
	// while the queue is not empty
	// Pull the element in front of the queue , process :
		 mark cell as visited 
		 if the cell contains a 1:
		 to decide whether the cell is part of an island marked earlier;
		 check neighbouring cells (every cell will have its coordinates written) 
		 to see if they were visited and marked (they will be marked with island ID, starting with 2)
		 if any of them was visited, mark this one with the same island ID, therefore marking as visited
	// Put the unvisited neighbors of the visited cell at the  end of the queue,
	
	//return the maks island ID - 2 as the number of islands.
	 Requires an additional Cell class  with coords, and islandID 
	*/
	
	Deque<Cell> deq = neq ArrayDeque<Cell>();
	
	public int findIslandCount() {

		mCellMaze[0][0] = new Cell(0,0,mMaze[0][0]);
		deq.offerLast(mCellMaze[0][0]);
		
		mMaze[0][0] = 0;
		Cell next = deq.pollFirst();
		
		while (next != null) {
			// visit cell, check neighboring cells -
			visitSelfAndNeighbours(next.row, next.col);
			
			next = deq.pollFirst();
		}
	}

	private void visitSelfAndNeighbours(int x, int y) {
		// if the self is land (1) and 
		//		if any of the neighbours in orig map is marked with an islandID greater than 1
		//			mark self on map as the islandID of the neighbor
		//  	else
		//  		mark self on map as the next bigger islandID
		//  else do nothing (has 0)
		
		//invariant: neither visited cell nor its neighbours contain a 1 anymore.
		
		Cell cell = mCellMaze[x][y];
		if (cell == null) { return; //TODO throw exception to the caller }
		
		if (cell.islandID == 1) {
			int connectedID = getConnectedIslandID(cell);
			if (connectedID > 1) {
				cell.islandID = connectedID;
				mCellMaze[x][y] = cell; //updated 
				
			}
		}
	}

	private int getConnectedIslandID(Cell cell) {

		
		int top,right, bottom, left = 0;
		
		if (cell.y-1 >=0)
			top = mMaze[cell.x][cell.y-1];
			
		if (cell.x+1 < ROW_CNT)
			right = mMaze[cell.x+1][cell.y];
			
		if (cell.y+1 < COL_CNT)
			bottom = mMaze[cell.x][cell.y+1];

		if (cell.x-1 >= 0)
			left = mMaze[cell.x-1][cell.y];
			
		retID = top;
		retID = (retID == 0 ? right);
		retID = (retID == 0 ? bottom);
		retID = (retID == 0 ? left);

		return retID;
	}

	private void insertNeighborsIntoQ(int x, int y) {

		Cell top,right, bottom, left = null;
					
		if (y-1 >=0) {
			//top = mMaze[cell.x][cell.y-1];
			mCellMaze[x][y-1] = new Cell(x,y-1,mMaze[x][y-1]);
			deq.offerLast(mCellMaze[x][y-1]);
		}
			
		if (x+1 < ROW_CNT) {
			//right = mMaze[cell.x+1][cell.y];
			mCellMaze[x+1][y] = new Cell(x+1,y,mMaze[x+1][y]);
			deq.offerLast(mCellMaze[x+1][y]);
		}
			
		if (y+1 < COL_CNT) {
			//bottom = mMaze[cell.x][cell.y+1];
			mCellMaze[x][y+1] = new Cell(x,y+1,mMaze[x][y+1]);
			deq.offerLast(mCellMaze[x][y+1]);
			
		}
		
		if (x-1 >= 0) {
			//left = mMaze[cell.x-1][cell.y];
			mCellMaze[x-1][y] = new Cell(x-1,y,mMaze[x-1][y]);
			deq.offerLast(mCellMaze[x-1][y]);
		}
	}
/*
	public int findIslandCount() {
		
		int rowNdx = 0;
		int colNdx = 0;
			for (int[] row: mMaze) {
				for (int val: row) {
					deq.offerFirst(new Cell(rowNdx,colNdx,val));
					colNdx ++;
				}
				rowNdx ++;
			}
	}
*/	
	public static void main(String[] args) {
		
		FindIslands fi = new FindIslands(5,5);
		
		System.out.printf("There are [%d] islands\n", fi.findIslandCount());
		
		fi.printMaze();
	}
}	
