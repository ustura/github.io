public class StickCuts {

	public static int cuts(int[] arr) {
		
	}
	
	public static void main(String[] args)
	{
		Random rand = new Random();
//		Integer arr[] = new Integer[N];

		int N = 5;
		int[] arr = new int[N];

		while ( N > 0) {
				N--;
				//arr[N] = N+1;
				arr[N] = (Math.abs(rand.nextInt()) % 5);
		}

		System.out.println("StickCuts count:: " + StickCuts.cuts(arr));		

	}
}
