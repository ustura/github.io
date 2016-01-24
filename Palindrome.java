public class Palindrome {

	public static int makePalindrome(String str) {
		
		char[] arr = str.toCharArray();

		if (str == null && str.length() == 0) {
			return -1;
		}

		int l = 0; 
		int r = str.length()-1;
		int opSum = 0;
		
		while(l<r) {
			short which = equalize(arr,l,r); // returns 0 if equalized to first char, 1 if second char
			if (which == 0 ) {
				opSum += arr[l] - arr[r];
				arr[r] = arr[l];
			}
			else if (which == 1){
				opSum += arr[r] - arr[l];
				arr[l] = arr[r];
			}
			else {
				System.err.println("ERROR:! comparison problem at..:");
			}
			l++; 
			r--;
		}

		System.err.println("Pal:" + new String(arr));
		
		return opSum;
	}
	
	private static short equalize(char[] arr, int lNdx, int  rNdx) {

		short ret = 2;
		
		if (rNdx >=0 && rNdx < arr.length && lNdx >=0 && lNdx < arr.length )
		{
			if (arr[lNdx] > arr[rNdx]) {
			//arr[rNdx] = arr[lNdx];
				ret = 0;
			}
			else {
				//arr[lNdx] = arr[rNdx];
				ret = 1;
			}
		}
		
		return ret;
	}

//in place
	public static String reverse(String str) {
		
		char[] arr = str.toCharArray();
		
		if (str != null && str.length() > 1) {
			int l = 0; 
			int r = str.length()-1;
			
			while(l<r) {
				swap(arr,l,r);
				l++; 
				r--;
			}
		}
		
		return new String(arr);
	}
	
	private static void swap(char[] arr, int rNdx, int lNdx) {

		if (rNdx >=0 && rNdx < arr.length && lNdx >=0 && lNdx < arr.length )
		{
			char tmp = arr[rNdx];
			arr[rNdx] = arr[lNdx];
			arr[lNdx] = tmp;
		}	
	}
	
	public static void main(String[] args)
	{
		StringBuilder str = new StringBuilder();

/*		
		for (int i=0; i<1024; i++) 
			for (int j=0; j<1024; j++) 
				str.append("abcdefgh");
				
		System.out.println("reverse length is: " + Palindrome.reverse(str.toString()).length());
		* */
		System.out.println("makePalindrome op count:: " + Palindrome.makePalindrome(args[0]));		
		
	}
}
