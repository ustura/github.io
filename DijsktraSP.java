import java.util.*;
import java.io.*;

public class DijsktraSP {
	
	private Map<Integer,List<Integer>> map = null;
	private Map<Integer,List<Integer>> mapW = null;
	
	public DijsktraSP() {
		 map = new TreeMap<Integer,List<Integer>>();
		 mapW = new TreeMap<Integer,List<Integer>>();
	}

	/* Reads the line :
	 * 1	80,982	163,8164	170,2620
	 */
	public void readGraph(File in) throws FileNotFoundException, IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(in));

		String aRow = br.readLine();
		
		while (aRow != null ) {
//			Scanner scanner = new Scanner(aRow);
//			scanner.useDelimiter(" ,");
			System.out.println("row :["+ aRow + "]");

			StringTokenizer t = new StringTokenizer(aRow);
				
			int sourceNode = 0;
			if (t.hasMoreTokens()) {
				String str = t.nextToken();
				System.out.println("str: [" + str +"]");
				sourceNode = Integer.parseInt(str);
				System.out.println(" sourceNode :["+ sourceNode + "]");
			}

			int destNode=0;
			int weight=0;

			StringTokenizer t2 = new StringTokenizer(aRow.substring(0)," ,");

			while(t2.hasMoreTokens() ){
				destNode = Integer.parseInt(t2.nextToken());
				weight = Integer.parseInt(t2.nextToken());
				System.out.println(" destNode :["+ destNode + "] w: "  + weight + "]");
				
//				addToMap(sourceNode, destNode);
//				addToMapW(sourceNode, weight);
			}
		break;
		// aRow = br.readLine();
		}
		
		System.out.println("graph node count :["+ map.keySet().size() + "]");
	}

	private void addToMap(Integer i, Integer j) {
		
		List<Integer> theList = map.get(i);

		if (theList == null) {
			theList = new ArrayList<Integer>();
		}

		theList.add(j);
		map.put(i,theList);
	}
	
	private void addToMapW(Integer i, Integer w) {
		
		List<Integer> theList = mapW.get(i);

		if (theList == null) {
			theList = new ArrayList<Integer>();
		}

		theList.add(w);
		mapW.put(i,theList);
	}
	
	private void findShortestPath(int sourceNode) {
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		DijsktraSP scc = new DijsktraSP(); // 875714 ??

		scc.readGraph(new File("dijkstraData.txt")); //args[0]
	}
	
}
