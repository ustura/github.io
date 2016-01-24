
public class DynoChicken {

   //BruteForce: while the target is still not reached,
   // assign different counts of each pack (including 0 ) to the total order,
   // and see if it is exactly equals to the order target 
	public static boolean isPossible(int[] packs, int target) {
		
	 int[] cnt = new int[packs.length]; //init to zero
	 int sum = 0;
	 boolean ret = false;
	 int nextPack=0;
	 while (sum < target) {
		 sum = 0;

 		 for(int i=0; i<cnt.length;i++)
			
		 for(int i=0; i<cnt.length;i++)
			sum += packs[i]*cnt[i];
		 if (sum == target) {
			 ret = true;
			
			for(int i=0; i<cnt.length;i++)
			 System.out.println(cnt[i] + "counts of pack:" + packs[i] + "]");
			 
			break;
		}
		nextPack = nextPack++ % cnt.length;
	 }
	 
	 return ret;
	}
	
	public static void main(String[] args)
	{
		int[] packages = {6,9,20};
		System.out.println("isPossible: " + DynoChicken.isPossible(packages,15) );
	}
}
