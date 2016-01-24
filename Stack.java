import java.util.*;

public class Stack <T extends Comparable> {

  private List<T> mList = null;
  private int mTopNdx = -1;
  
  public Stack(int initSize ) {
	   mList = new ArrayList<T>(initSize);
   }
 
  public T pop() {
	  
	  T ret = null;

	  if (mTopNdx > -1 && mTopNdx < mList.size() )
	   {
		   ret = mList.remove(mTopNdx);
		   mTopNdx --;
	   }
	   
	   return ret;
   }
   
   public void push(T aVal) {
	  
	  mTopNdx ++;
	  mList.add(mTopNdx,aVal);
   }

   public T peek() {
	   T val = pop();
		push(val);
		
		return val;
   }
   
	 public void printStack() {
		 Util.printList(mList);
	 }  
	
  public  void printStackAsArr() {

	  Object val = mList.get(0) ;
	  
	  if (val instanceof Integer) {
		 Integer[] arr = new Integer[5];
		  mList.toArray(arr);

		  assert(arr != null);
		  assert(arr.length == mList.size());
	  
		  Util.printArr(arr);
  	  }

  }
  
  public static void main(String[] args) {
	  
	  Stack<Integer> anInStack = new Stack<Integer>(5);
	  
	  anInStack.push(2);
	  anInStack.push(6);
	  anInStack.push(7);
	  anInStack.push(12);
	  anInStack.push(16);
	  anInStack.push(17);
	  anInStack.push(2);
	  anInStack.push(6);
	  anInStack.push(7);
	  anInStack.push(12);
	  anInStack.push(16);
	  anInStack.push(17);
	  
	  anInStack.printStack();
	  System.out.println(anInStack.pop());
	  anInStack.printStack();
  }
}
