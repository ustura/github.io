import java.util.*;

class Test {
	
	public static int[] getBCD(int n) {
	
		int[] ret = new int[100];
		int tmp = n;
		int d = 0;
		int ndx = 0;
		
		while(tmp >0 && ndx < 100){
			d = tmp % 10;
			ret[ndx++] = d;
			tmp = tmp/10;
		}
		
		int[] ret2 = null; //new int[ndx];
		
		ret2 = Arrays.copyOfRange(ret,0,ndx);
		
		return ret2;
	}


	public static boolean isPalindrome(int n) {
		return isPalindrome(getBCD(n));
	}
	
	private static boolean isPalindrome(int[] arr) {
		
		int lNdx =  0;
		int rNdx = arr.length - 1;
		boolean ret = true;
		
		while(lNdx <= rNdx) {
			if ( arr[rNdx] != arr[lNdx] )
			{
				ret = false;
				break;
			}
			lNdx++;
			rNdx--;
		}
		
		return ret;
	}
	
public static void main(String[] args) {

	Scanner scn = new Scanner(System.in);

	int T = 0;
	if (scn.hasNextInt()) {
		T = scn.nextInt();
	}

	while(scn.hasNextInt()) {
		
		int N = scn.nextInt();
		System.out.println("isPali  : " + Test.isPalindrome(N));
		//Util.printArr(Test.getBCD(N));

	//	char[] arr = Integer.toString(N).toCharArray();
	
	}
	}
}
