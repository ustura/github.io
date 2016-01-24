import java.util.Random;
import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;

public class CompTest {

	
	public static void main(String[] args)
	{
		Comparator<Integer> revComp = Collections.reverseOrder();
		
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(16,revComp);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int N = 5;
		
		Random rand = new Random();
		
		while ( N > 0) {
				N--;
				int x = rand.nextInt() % 200;
				System.out.println("x:"+x);
				pq.offer(x);
		}

//		Integer v = Collections.binarySearch(pq,new Integer(5));
		//System.out.println("searched v :"+ v);
		Integer v = null;
		v = pq.poll();
		while (v != null) {
			//System.out.println("max polled :"+ v);
			System.out.printf("max polled :%8d\n",v);
			v = pq.poll();
		}
		/*
		System.out.println("max polled :"+ );
		System.out.println("max polled :"+ pq.poll());
		System.out.println("max polled :"+ pq.poll());
		System.out.println("max polled :"+ pq.poll());
		System.out.println("max polled :"+ pq.poll());
		System.out.println("max polled :"+ pq.poll());
		System.out.println("max polled :"+ pq.poll());
		*/
	}

}
