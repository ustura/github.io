
public class LongestNonDecreasing {

public static int find(int[] arr,Integer startP, Integer endP) {

	int ret = 0;
	Integer st = new Integer(0);
	Integer end = new Integer(0);

//	int[] inp = { 8, 7,7,-1,0,3,3,4,-2 };
	
	int ndx = 0;
	while ( ndx < arr.length) {

		st = ndx;

		int cur = 1;
		int ndx2 = ndx + 1;

		while (ndx2 < arr.length) { // && ndx < arr.length) {
			
			if ( arr[ndx] <= arr[ndx2]) {
				cur++;
			   ndx++;
			   ndx2++;
//				System.out.printf("Increment cur to [%d]]\n", cur);
			}
			else {
				break;
			}
		}
		
		end = ndx2;
		
		if (cur > ret) {
			ret = cur;
			startP = st;
			endP = end;
		}
		
		ndx++;
	}
	
	System.out.printf("st [%d] enf [%d]\n", st, end);
	return ret;
	
}

public static void main(String[] args) {

	int[] inp = { 8, 7,7,-1,0,3,3,4,-2 ,1,3,4,5,6,7,7,8,9};
	Integer st = new Integer(0);
	Integer end = new Integer(0);
	
	int ret=  LongestNonDecreasing.find(inp,st,end);

	System.out.println("st: " + st);
	System.out.println("end: " + end);
	System.out.println("Longest : " + ret);

	for(int ndx = st; ndx < end; ndx++)  
		System.out.printf("%d, ", inp[ndx]);
		
	System.out.println();

}
}
