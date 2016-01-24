import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
//import Util.*;

public class NaryTree {

	Map<Character,NaryTree.NaryNode> headMap = null; // will have  26 head nodes at most 
	
	private class NaryNode {
		Character val = null;
		boolean period = false; //whether this node marks the end of word by its character.
		Map<Character,NaryNode> children = null; // will have  26 head nodes at most 
		
		public NaryNode(Character aVal) {
			this.val = aVal;
			children = new TreeMap<Character,NaryNode>();
		}
		
		public NaryNode getChild(Character c) {
			if (c != null) {
				return children.get(c);
			}
			return null;
		}
		
		public NaryNode putChild(Character c) {
			NaryNode child = new NaryNode(c);
			children.put(c, child);
			
			return child;
		}
		
	} //Node

	public NaryTree() {
		headMap = new TreeMap<Character,NaryNode>();
	}
	
  // for each char in the input word, 
  //   get the node for the char , 
  //		if the node is null :
  //					create the node and assign it to the head node if this is the 1st char,
//						create the node and make it a child of the parent node.
 // 		if not null
 // 		continue to the next char, repeat 
 
	public 	void add(String aWord){
		
		if (aWord != null && false == aWord.isEmpty() ) {
			Character c = aWord.charAt(0);
			String sub = null;
			
			if (aWord.length() > 1) {
				sub = aWord.substring(1);
			}
			
			NaryNode p = headMap.get(c);
		
			if (p!= null) {
				addNode(p,c,sub);
			}
			else {
				NaryNode head = new NaryTree.NaryNode(c);
				headMap.put(c,head);
				
				addNode(head,c,sub);
			}
		}
	}
	
	private void addNode(NaryTree.NaryNode parent, Character preChar, String aWord) {

		
		if (aWord == null || aWord.isEmpty() ) {
			parent.period = true;
//			System.out.println("Returning while Adding under :[ " + preChar + "] sub :[" + aWord + "]");
			return ;
		}

	//	System.out.println("Adding under : [" + preChar + "] sub :[" + aWord + "]");

		Character c = aWord.charAt(0);
		String sub = null;
		
		if (aWord.length() > 1) {
			sub = aWord.substring(1);
		}
		
		NaryTree.NaryNode child = parent.getChild(c);
		
		if ( child == null) {
			//System.out.println("Adding a child for :[ " + preChar + "] child C :[" + c + "]");
			child = parent.putChild(c);
		}

		addNode(child,c,sub);
	}
	
	Deque<NaryTree.NaryNode> q = new ArrayDeque<NaryTree.NaryNode>();
	ArrayList<Character> curWord = new ArrayList<Character>();
	
	/**
	 */
	public void dumpDict() {
	
 	 //Set<NaryTree.NaryNode> heads =  headMap.keySet();
 	 Set<Character> heads =  headMap.keySet();
	
	  for(Character head: heads) {
		   if (head != null) {
			q.offerLast(headMap.get(head));
			dfs();
		  }
	  } 
	  
	   
	}//dumpDict
	
	private void dfs() {
		
		if (q!= null) {
			NaryTree.NaryNode next = q.pollFirst();
			
			if (next != null) {
				 curWord.add(next.val);
				 if (next.period) {
					 printWord(curWord);
				 }

				Set<Character> children =  next.children.keySet();
				
				for(Character c: children) {
				   if (c != null) {
						q.offerLast(next.children.get(c));
					  }
				}
				
				dfs();
				
				if (curWord.size() > 0 )
					curWord.remove(curWord.size()-1);
				
			}
		}
	}

	private void printWord(	ArrayList<Character> list) {

		System.out.print("[");
		for (int ndx = 0; ndx < list.size(); ndx ++) {
			System.out.print(list.get(ndx));
		 }
		System.out.print("]");

	}

	StringBuilder ret = new StringBuilder();

	private int parseTree(NaryNode parent, String aStr) {

		int retNdx = 0;
		
		if (aStr != null && false == aStr.isEmpty() ) {
			Character c = aStr.charAt(0);
			ret.append(c);

			if (parent.period) {
				ret.append(" ");
			}

			String sub = null;
			
			if (aStr.length() > 1) {
				sub = aStr.substring(1);
			}

			NaryNode child = parent.getChild(c);
			
			if (child != null) {
				retNdx = parseTree(child,sub) + 1;
			}
			
		}
		
		return retNdx;
	}
	
	public String parse(String aStr) {

		while (aStr != null && false == aStr.isEmpty() ) {
			Character c = aStr.charAt(0);
			NaryNode head = headMap.get(c);
			
			int curNdx = 0;
			
			
			if (head != null) {

				String sub = null;
				
				if (aStr.length() > 1) {
					sub = aStr.substring(1);
				}
				
				curNdx = parseTree(head,sub);
				System.out.println("curNdx:[" + curNdx + "]");
				
				if (curNdx > 0)
					aStr = aStr.substring(curNdx);
				else
					aStr = "";
				
				System.out.println("aStr:[" + aStr + "]");
			}
			
		}
		
		return ret.toString();
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
