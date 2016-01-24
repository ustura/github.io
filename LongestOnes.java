
public class LongestOnes {
	
	public static int getMagicNdx(int[] arr) {
		int max = 0;
		int curMax = 0;
		int retNdx=-1;
		int ret = -1;
		
		int ones = 0;
		int zeros = 0;
		
		int ones2 = 0;
		
		int ndx = 0;
		
		
		while( ndx < arr.length) {
			
			while(ndx < arr.length &&  arr[ndx] == 1 ) {
				System.out.printf("ndx: %d, ones %d\n", ndx,ones);
				ones ++;
				ndx++;
			}
			while(ndx < arr.length &&  arr[ndx] == 0 ) {
				System.out.printf("ndx: %d, zeros %d\n", ndx,zeros);
				zeros ++;
				ndx++;
			}

			if (zeros > 1) {
				// discard earlier ones  
				ones = 0;
				System.out.printf("Discarding earlier ones. ndx: %d, zeros %d\n", ndx,zeros);
			}
			else  {
				
				retNdx = ndx-1;
				curMax = ones + ones2 + 1;
				System.out.printf("ndx: %d, retNdx %d zeros %d ones %d, ones2 %d, max %d curMax %d\n", ndx,retNdx, zeros, ones,ones2,max,curMax);
				
				if (curMax > max) {
					ret = retNdx;
					max = curMax;
				}
				
				ones2 = ones;
				ones = 0;
				
				}

			zeros = 0;

			}
		
		return ret;
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 1,1,0,0,1,0,1,1,1,0,1,1,1};
		
		int ndx = getMagicNdx(arr);
		
			System.out.println("Ndx : " + ndx);
	}
}
