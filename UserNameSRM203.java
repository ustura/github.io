import java.util.*;

class UserNameSRM203 {

private int getSuff(String suff) {
	
	return 1;
}

public static String suggest(String[] arr, String wants) {
	
	Set<Integer> nums = new TreeSet<Integer>();

	boolean inSet = false;	
	
	for(String exists : arr) {
		 
		 if (exists.startsWith(wants)) {

			 String suff = exists.substring(wants.length());
			System.out.println("exists  : " + exists +
			 " suff: " + suff  + " suflen " + suff.length());
			 
			 if (suff.length() > 0 ) {
				 try {
					Integer n = Integer.parseInt(suff);
					nums.add(n);
				}
				catch(Exception e) {
				}
			}
			else {
				nums.add(0);
			}
			inSet = true;
		 }
	}
	
	if (inSet == false) {
		return wants;
	}

	int ret = 0 ; Collections.min(nums);

for(Integer i: nums) 
	System.out.println("i  : " + i);
	
	Iterator<Integer> it = nums.iterator();
//	if (it.hasNext() ) it.next() ;

	while(it.hasNext() ) {
		Integer n = it.next();
		if ((n-ret) > 0) {
			ret++;
			break;
		}
	}
	
	if (ret == 0 )
	 ret = Collections.max(nums) + 1;

	return (wants+ret);
	
}

public static void main(String[] args) {

/*
	String[] inp = {"grokster2", "BrownEyedBoy", "Yoop", "BlueEyedGirl", 
	 "grokster", "Elemental", "NightShade", "Grokster1"};
	String wants = "grokster";
*/

String[] inp = {"MasterOfDisaster", "TygerTyger1", "DingBat", "Orpheus", 
 "WolfMan", "MrKnowItAll"};
String wants = "TygerTyger";

	String sugg = UserNameSRM203.suggest(inp,wants);
	System.out.println("suggested  : " + sugg);

}
}
