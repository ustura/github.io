import java.util.*;
import java.io.*;

public class SCC {
	
	private Set<Edge> graph = null;
	private Map<Integer,Set<Integer>> map = null;
	
	private Deque<Integer> marked = null;
	private int[] f = null ; //finishing times
	private int t = 0;
	
	
	private  class Edge {
		public Integer u = null;
		public Integer v = null;
		
		public Edge(int i,int j) {
			u = new Integer(i);
			v = new Integer(j);
		}
	}
	
	public SCC(int N) {
		 graph = new HashSet<Edge>();
		 map = new TreeMap<Integer,Set<Integer>>();
		 marked = new ArrayDeque<Integer>();
		 
		 f = new int[N];
	}
	
	public void readGraph(File in) throws FileNotFoundException{
		
		Scanner scanner = new Scanner(in);
		
		int i = 0;
		int j=0;
		
		while(scanner.hasNextInt() ){
			i = scanner.nextInt();
			j = scanner.nextInt();
			
			addToMap(i,j);
		}
		
		System.out.println("graph node count :["+ map.keySet().size() + "]");
	}
	
	private void addToMap(Integer i, Integer j) {
		
		Set<Integer> theSet = map.get(i);

		if (theSet == null) {
			theSet = new TreeSet<Integer>();
		}

		theSet.add(j);
		map.put(i,theSet);
		
	}
	
	private void DFS(int startNode) {
		
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		SCC scc = new SCC(875714); //

		scc.readGraph(new File("SCC.txt")); //args[0]
	}
	
}
