/*
  Write a basic imple of a MinStack that supports operations : push(), pop(), and min() in constant time
  * 
  * MyQuestions :  What type of data do we want to store, read back? Numbers, Strings, complex type?
  * 		: int
  * 
  * Example Input (in this order) :  5, -1, 6, -3
  *  st1    st2
  *   5      5
  *   -1     -1
  *    6      -3
  *    -3   
  * 
  * ms.min() : -3
  * ms.pop() : 
  * ms.min() : -1
  * ms.pop() : 6
* 	ms.min() : -1
* ms.pop() : -1
* 	ms.min() : 5
* ms.pop() : 5
* 	ms.min() : null
* 
*
*      * Pseudo:
  * 1) 
  * init stack with minEl=null
  * push() op compares the pushed value with the minEl, replaces if it is less than minEl
  * pop() compares the topmost val with minEL, scans the internal array for the next min element if it is 
  * 	 popping the current minEL O(N) . 
  * 
  * 2)Keep 2 separate stacks. First one keeps everything pushed into it in ordinary Stack fashion.
  *     Second one keeps only the smallest of all incoming so far.
  * 
  *   push() pushes into stack1 without questioning, into stack2 only if it is lower than the top of stack2
  *   pop() pops from stack1, and from stack2 only if it the value is also top of stack2
  * 
  *      
  * 
*/

import java.util.Random;

public class MinStack <T extends Comparable> {
	
	private Stack<T> stReg = null;
	private Stack<T> stMin = null;
	
	public MinStack(int aSize) {
		stReg = new Stack<T>(aSize);
		stMin = new Stack<T>(aSize);
	}
	
	public void push(T aVal) {
		
		assert(stReg != null);
		assert(stMin != null);
		
		
		T min = stMin.peek();
		
		if (aVal != null ) {
			
			if (min == null ) {
				stMin.push(aVal);
			}
			else {
//				int comparison = aVal.compareTo(min );

				if (aVal.compareTo(min ) <=0 ) {
					stMin.push(aVal);
				}
			}

		stReg.push(aVal);

		}
		else {
			System.err.println("Error inserting val: " + aVal);
		}
	}
	
	public T pop() {
		
		T ret = stReg.pop();
		
		if (ret != null && ret.equals(stMin.peek()) ) {
			stMin.pop();
		}
		
		return ret;
	}
	
	public T min() {
		return  stMin.peek();
	}
	
	public void printStack() {
		System.out.println("regular: ");
		stReg.printStack();
		System.out.println("min: ");
		stMin.printStack();
	}
	
  public static void main(String[] args) {
	  
	  final int CNT = 10;
	  
	  MinStack<Integer> aMinStack = new MinStack<Integer>(5);
	  
	  Random rand = new Random();
	  
	  for(int ndx = 0; ndx < CNT ; ndx ++) {
		  aMinStack.push(rand.nextInt() % 10);
	  }

	 aMinStack.printStack();
	  
	  while (aMinStack.min() != null) {
		  System.out.println("popped:" + aMinStack.pop() + " min: " + aMinStack.min());
		}
	}
}
