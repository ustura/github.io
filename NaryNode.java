public class NaryNode
{
	
	private Character val = null;
	
	private SortedMap<Character,NaryNode> children = null;
	
	public NaryNode(Character c) {
		val = c;
	}
	public static void main(String[] args)
	{
		 String[] dict={"el","ela","elma","armut","portakal"};

		NaryTree nt = new NaryTree();
		
		for(String aWord:dict) {
			nt.add(aWord);
		}
		
		//nt.dumpDict();
		String out = nt.parse("elmo");

		System.out.println("out:[" + out + "]");
	}
}
