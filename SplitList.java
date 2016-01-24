
import java.util.*;

public class SplitList {

	
	public static void main(String[] args)
	{
		Comparator<Integer> revComp = Collections.reverseOrder();
		
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(16,revComp);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		
		Integer[] arr = {1000,500,200,1,5,10,50,70,70,100};
		
		Arrays.sort(arr);
		int N = 2;
		System.out.println("searching :"+ N + " foudn at " + Arrays.binarySearch(arr,N));
		System.out.println("searching :"+ N + " foudn at " + Arrays.binarySearch(arr,N,Collections.reverseOrder()));
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

		Collections.sort(list);
		System.out.println("list size :"+ list.size());
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();

		System.out.println("sorted list" );
		for (int i: list){
		 System.out.print(i + " ");
		
		System.out.println();

		}
//		Integer top = ((ArrayList<Integer>)list).remove(0);
		boolean t = false;

		while(list.size() > 0) {
			 if (t ) {
				 list1.add(list.remove(0));	
				 t = false;
			}
			else {
				 list2.add(list.remove(0));	
				 t = true;
			}
		}

		int tot1 = 0, tot2 = 0;
		
		for (int i: list1){
		 System.out.print(i + " ");
		tot1 += i;
		}
		System.out.println("tot1 " + tot1);
		 
		for (int i: list2){
		 System.out.print(i + " ");
		tot2 += i;
		}
		
		System.out.println("tot2 " + tot2);
	}
}
