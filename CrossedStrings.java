/*
Interleaving of stringsThree strings say A,B,C are given to you.
 Check weather 3rd string is interleaved from string A and B. Ex: A=”abcd” B=”xyz” C=”axybczd”. answer is yes.
 */
public class CrossedStrings {

	public static boolean isInterleaved(String str1,String str2,String str3) {
		
		boolean ret = true;
		
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		char[] c = str3.toCharArray();
		
		int ndxA=0, ndxB=0, ndxC=0;
		
		while(ndxC < c.length ) 
		{
			if ( c[ndxC] == a[ndxA] ) {
				ndxA++;
			}
			else if ( c[ndxC] == b[ndxB] ) {
				ndxB++;
			}
			else {
				ret = false;
				break;
			}
			ndxC ++;
		}
		
		return ret;
	}
	
	public static void main(String[] args)
	{
		String  A = "abcd";
		String  B = "xyz";
		String  C = "axycbzd";
		
		System.out.println(" is interleaved: " + CrossedStrings.isInterleaved(A,B,C));
	}


}
