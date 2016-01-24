/*
Find all permutations of a String
* 
* input: ab
* output : ab, ba
* input : abc
		  a b c
            
* 
* output : abc, bac, bca, acb, cab, cba
* 
* divide input into : 1st char and the rest.
* obtain the permutations of rest of the characters as a Set of Strings
* Modify each permutation in the set by placing the 1st char in front of every character ( in each permutation)
*/

import java.util.Set;
import java.util.HashSet;

public class Permutation {
	
	private static Set<String> hassle(char head, String rest) {

	Set<String> ret = null;
		 
		  if (rest.length() > 1) {
			  Set<String> hpSet = hassle(rest.charAt(0), rest.substring(1));
			  
			  Set<String> tmp = new HashSet<String>();
			  
			  for(String halfPerm : hpSet) {

					int pos = 0;
					while (pos <=  halfPerm.length()) {
						StringBuffer sb = new StringBuffer(halfPerm);
						sb.insert(pos,head);
						tmp.add(sb.toString());
						pos ++;
						sb = null;
					}
			  }//for
			  ret = tmp;
		  }
		  else if (rest.length() == 1) {

			ret = new HashSet<String>();

			  char[] arr = new char[2];

			  arr[0] = head;
			  arr[1] = rest.charAt(0);
			 ret.add(new String(arr));
			 
			  arr[0] = rest.charAt(0);
			  arr[1] = head;
			 ret.add(new String(arr));
		 }
		 else {
			ret = new HashSet<String>();
			  char[] arr = new char[1];

			  arr[0] = head;
			  ret.add(new String(arr));
		 }
		 
		 return ret;
	}
	
	/**
	 */
	public static Set<String> findPermutations(String orig) {
		
		 Set<String> ret = new HashSet<String>();
		 
		 if (orig.length() > 1) {
			 ret = hassle(orig.charAt(0), orig.substring(1));
		 }
		 else if (orig.length() == 1) {
			 ret.add(orig);
		 }
		 return ret;
	}
	
	public static void main(String[] args) {

	String orig = "abcde";
	
	Set<String> permSet = Permutation.findPermutations(orig);
		
	System.out.println("permSet Size: " + permSet.size());
	System.out.println("permSet: " + permSet);
	}
}
