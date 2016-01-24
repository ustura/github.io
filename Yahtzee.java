
import java.util.*;

class Yahtzee {

public static int maxPoints(int[] toss ) {

	int[] tot = new int[7];
	
	for(int ndx=0; ndx<toss.length; ndx++) {
		tot[toss[ndx]]+=toss[ndx];
	}

	int max=0;
	for(int ndx=1; ndx<tot.length; ndx++) {
		System.out.println("  : " + tot[ndx]);
		if (tot[ndx] > max) max = tot[ndx];
	}	
	return max;
}

public static void main(String[] args) {
	
	int y = Yahtzee.maxPoints(new int[]{ 5, 3, 5, 3, 3 });
	System.out.println("Yahtzee  : " + y);

}
}
