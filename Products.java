import java.util.Random;
import java.util.Collections;

public class Products {

	public static void printPairs(int[] arr, int P) {
		
		System.out.println("P is: " + P);
		//O N2
		for (int first = 0; first < arr.length; first++) {
			if ( P > arr[first] && ( P / arr[first]) == 0 ) continue;
			if ( P < arr[first] ) continue;
			
			for (int sec = 0; sec < arr.length; sec++)
			{
				 if (( arr[first] * arr[sec] ) == P ) {
					System.out.println("[" + arr[first] + "," + arr[sec] + "]");
				 }
			}
		}
	}
	
	public static void main(String[] args)
	{
		int N = 20;
		final int P = 8;
		
		Random rand = new Random();
		int arr[] = new int[N];
		
		while ( N > 0) {
				N--;
				arr[N] = N+1;
				//arr[N] = (rand.nextInt() % 5);
		}

		Util.printArr(arr);
		Products.printPairs(arr,Math.abs(rand.nextInt() % 1000));
//		System.out.println("reverse length is: " + Palindrome.reverse(str.toString()).length());
		
	}
}
