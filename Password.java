import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
//import java.util.StringBuilder;

public class Password {

	static Map<Character,Character> map = new  TreeMap<Character,Character> ();
	
	static{
		map.put('a','@');
		map.put('s','$');
		map.put('o','0');
	}	

	 // inp : aso
	 //out: @so,@$o,@$0, ...  number of permutations ; 2^N, N: number of replaceable chars in input

	 // METHOD 1- will come back later.
	 // init q with the initial pwd
	 // pull the first element from the q
	 //iterate over each char of pwd, look it up in the map, if a replacement is returned, 
	 //make the replacement,  add the new suggestion 
	 //into the return set, also into a queue of unprocessed passwords.
	 
	 //METHOD 2
	 // String
	 // base case: if str is null, return null
	 //			   if str contains a single char:
	 //			      make a list of 2 strings, one with the orig char, the other with the replaced char.
	 // 	       otherwise continue with the rest:
	 //			 call self on the first char of the input, then the rest.
				//append the returnt set of 2nd call to every item in the 1st returned set
	 // ----
	 // Find the index of the first replaceable (any) char in the input string
	 // replace it, save the substring up to and including to that char, call proc recursively on the rest of the string
	 // append each returned part at the end of the saved string, add each into the returned set
	 // return the set
	 
	 
	public static Set<String> suggest(String aPwd) {
		
		Set<String> retSet = null;
		String prefix = null;
		
		if (aPwd == null || aPwd.length() == 0) return null;
		
		//char[] arr = aPwd.toCharArray();
		retSet = new TreeSet<String>();
		
		if (aPwd.length() == 1) {
//			System.out.println("1 Adding [" + aPwd + "] to retSet");
			retSet.add(aPwd);
			Character rep = map.get(aPwd.charAt(0));
			if(rep != null) {
				String repStr = new String("" + rep);
				retSet.add( repStr);
	//			System.out.println("1 Adding [" + repStr + "] to retSet");
			}
		}
		else {
			prefix=aPwd.substring(0,1);
			
			Set<String> prefList = suggest(prefix);
			Set<String> sufList = suggest(aPwd.substring(1));
			
			for(String suf: sufList){
				
				for(String pref: prefList){
					retSet.add(pref+suf);
//					System.out.println("prefix: " + prefix + " Adding [" + suf + "] to retSet");
				}
			}
		}//else
	
		return retSet;
	}

	//Pseudo
	// init return set to empty.
	// Iterate over each char, and check if it is replaceable.
	// if it is , that's a split point. That is, take the substr up to the current index - not including it -
	// then produce two strings, one with the replaced char, the other with the original.
	//  pass -> pass, p@ss
	// pass->  pass, pa$s
	//  iterate over the list of returned set, replace the char at the curNdx with the replaceable in each pwd string,
	// and augment the orig returned set with them.
	// add those two to the returned set.
	//
	public Set<String> suggest2(String aPwd) {

		Set<String> retSet = new TreeSet<String>();
		
		if(aPwd == null ) return null;
		
		char[] pwd = aPwd.toCharArray();

		for (int ndx=0; ndx<pwd.length; ndx++) {

			Character c = new Character(pwd[ndx]);

			if (map.containsKey(c) ) {


				for(String retStr: retSet){
					StringBuilder aSuggestion = new StringBuilder();
					aSuggestion.append(retStr.substring(0,ndx));
					aSuggestion.append(map.get(c));

					if (ndx+1<pwd.length)
						aSuggestion.append(retStr.substring(ndx+1));
					
				}
				
				StringBuilder aSuggestion = new StringBuilder();
				aSuggestion.append(aPwd.substring(0,ndx));
				aSuggestion.append(map.get(c));

				if (ndx+1<pwd.length)
					aSuggestion.append(aPwd.substring(ndx+1));
					
				retSet.add(aSuggestion.toString());
			}//if
		}//for
		
		return retSet;
	}
	
	//private static Set<String> suggest(
	public static void main(String[] args)
	{
		Set<String> sugSet = Password.suggest(args[0]);
		System.out.println("size: " + sugSet.size());

		for(String aSug: sugSet) {
			System.out.println(aSug);
		}

	}
}
