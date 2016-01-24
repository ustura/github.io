import java.util.Arrays;

public class Anagram {

	public static boolean is(String s1, String s2) {
		
		if (s1.length() != s2.length() ) return false;

		//iterate thru first string, keeping the count of each char in an int array, indexed by char 
		//iterate thru 2nd, generating the same signature,
		//compare arrays, return true if they are identical, false otherwise
		
		int[] sign1 = getSignature(s1);
		int[] sign2 = getSignature(s2);
		
		return (Arrays.equals(sign1,sign2));
		
	}
	
	private static int[] getSignature(String str) {
		int[] sign = new int[26];
		
		if (str != null) {
			String s = str.toLowerCase();
			for(int ndx=0; ndx<s.length(); ndx++) {
				int v = s.charAt(ndx) - 'a';
				System.out.println("s.charAt(ndx)" + v);
				sign[s.charAt(ndx)-'a'] ++;
			}
		}
		
		System.out.println();
		
		return sign;
	}
	public static void main(String[] args)
	{
		if (args.length < 2) {
			return;
		}
		String str1 = args[0];
		String str2 = args[1];
		
		System.out.println("is Anagram: " + Anagram.is(str1,str2) );
	}
}
