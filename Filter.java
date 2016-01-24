import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Filter {

	public static List<Integer> filter(List<Integer> aList, int k) {
		//Filter those apperaing more than k times
		//O of N
		if (aList == null || aList.size() == 0) {
			return aList;
		}
			
		int[] seen = new int[1000]; //init to zero
		
		for (Integer num: aList){
			seen[num]++;
		}

		for (int ndx=0; ndx<seen.length; ndx++){
			if (seen[ndx] >= k) {
				System.out.println("number [" + ndx + "] appeared more than " + k + " times");
			}
		}
	
		return aList;	
	}
	
	public static void main(String[] args)
	{
		int N = 30;
		final int P = 8;
		
		Random rand = new Random();
		Integer arr[] = new Integer[N];
		
		while ( N > 0) {
				N--;
				//arr[N] = N+1;
				arr[N] = (Math.abs(rand.nextInt()) % 5);
		}

		Arrays.sort(arr);
		Util.printArr(arr);
		List<Integer> list = new ArrayList<Integer>();
		list = Arrays.asList(arr);
		Filter.filter(list,5);
//		System.out.println("reverse length is: " + Palindrome.reverse(str.toString()).length());
		
	}
}
