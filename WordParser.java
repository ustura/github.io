import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class WordParser {
	
	public String[] dict={"el","ela","elma","armut","portakal"};

	//	Assumption : aStr contains only dictionary words , albeit all concatanated.
	 // inp : elarmut => el armut
	//Psedo
	//  iterate over the string, char by char,
	// check if the substr formed by (beginning to curNdx) is in dict,
	// if it is, append the substr into the return str with a space.
	// move begin ndx to the curNdx, continue until the end of orig string
	
	public static String makeSentence2(String aStr, Set<String> aDict) {
		
		StringBuilder retStr = new StringBuilder();
		
		int begNdx = 0, curNdx = 0;
		String aSub = null;
		while( curNdx < aStr.length()) {
			curNdx++;
			aSub = aStr.substring(begNdx,curNdx);
			if (aDict.contains(aSub) ) {
				retStr.append(aSub).append(" ");
				begNdx = curNdx;
			}
		}
		
//		retStr.append(aSub);
		
		return retStr.toString();
	}

	//PseudoCode
	// Prep step
	// Put the words in the dict into a nAry search tree, where each node will have a single character value
	//	but may have multiple children nodes for each of the characters following the root character.
	//  if there is no child starting with a specific character, that means the word described by the path
	// followed up to the current node is a valid word in the dictionary.
	
	// Decision step: in order to decide whether a string of characters is part of the dictionary,
	// STEP 1 starting with the 1st char of the input string;
	//  save the current character as part of the partial word
	// STEP 2 get the node denoted by the character in the nAry tree, 
	//    if the node is not found, 
			//  if the node is marked as end of word (period)
			//		mark it as a valid word, (append it to and insert space in the output string)
			// otherwise, continue to STEP1 with the next character
					//   clear the partial word, continue to STEP1 with the next character
	//    if the node is found, go to STEP 2 with the next character

	public static String makeSentence(String aStr, Set<String> aDict) {
		
		char[] array = aStr.toCharArray();
		
		StringBuilder prefix = new StringBuilder();
		
		for (int i=0; i<array.length; i++) {
			
			prefix.append(array[i]);
			
			System.out.println("checking [" + aStr + "] for prefix:[" + prefix.toString() + "]");	

			if (aDict.contains(prefix.toString())) {
				if (prefix.length() == array.length) 
					return prefix.toString();
					
					String suffix = makeSentence(new String(array,prefix.length(), array.length-prefix.length()),aDict);
					
					if (suffix != null) {
						prefix.append(" ");
						prefix.append(suffix);
						return prefix.toString();
					}
				
			}
		}
		
		return null;
	}
	// theskyonarmaisblue => the sky onarma is blue
	public static String parse2(String aStr, Set<String> aDict) {
		//Pseudocode
		// starting from the 1st char (begNdx), incrementally check the word composed 
		// by the substring (begNdx, curNDx) of orig string against the dict,
		// if the word is contained, save it to the output string, along with a blank space
		// update begNdx to CurNdx, and curNdx to 1, repeat.
		// this may not find anything in the dict - because the beginning chars
		// might produce a non-valid word, even though substrings of the rest of the orig
		//string contains valid words.
		
		int curNdx = 1;
		boolean done = false;
		String check = null;
 	    StringBuilder ret = new StringBuilder();
	   
	   //skyhopiditheblue
		while(curNdx < aStr.length()) {
			
			check = aStr.substring(0,curNdx);
			if (aDict.contains(check)) {
				ret.append(check).append(" ");
				aStr = aStr.substring(curNdx);
				curNdx = 1;
			}
			else {
				curNdx ++;
			}
		}
		
		return ret.toString();
	}

	// theskyonarmaisblue => the sky onarma is blue
	public static String parse(String aStr, Set<String> aDict) {
		//Pseudo-code
		//use startsWith on the input string for every word in dict,
		// as long as the check returns true on a word, 
		//increment the beg ndx by the length of the dictionay word
		// and continue
		// if the check returns false on all words , increment beg ndx
		// by one, and continue.
		// stop when the beg ndx is at the end .

	   StringBuilder ret = new StringBuilder();
	   
	   //
		while(aStr.isEmpty() == false) {
				
				boolean p = false;
		
			again:	
				{
				for(String aWord:aDict) {
					System.out.println("checking[" + aStr + "] for:[" + aWord + "]");	
				
					if (aStr.startsWith(aWord) ) {
						System.out.println("starts with:[" + aWord + "]");	
						
						//if (aStr.length()aWord.length()
							ret.append(aStr.substring(0,aWord.length()));
							ret.append(" ");
							aStr = aStr.substring(aWord.length());
							System.out.println("aStr:[" + aStr + "]");	
							 p = true;
						 break again;
					}
				}
				
				System.out.println("aStr after the loop:[" + aStr + "]");	
					ret.append(aStr.charAt(0));
					aStr = aStr.substring(1);
				}
			
			System.out.println("consumed dict. aStr now:[" + aStr + "]");	
			
		}
		
		return ret.toString();
	}
	
	public static void main(String[] args)
	{
		String[] dict={"the","sky","is","blue","portakal"};

		List<String> list = Arrays.asList(dict);
		Set<String> set = new TreeSet<String>();
		
//		Util.printList(list);
		
		set.addAll(list);
		
		String out = WordParser.makeSentence2("skyisblue",set);

		System.out.println("out:[" + out + "]");	
	}
}
