import java.util.ArrayList;

class listToArrayTest { 
	
	public static void main(String[] args) {

	 ArrayList<Integer>  myList = new ArrayList<Integer>(10);
	 
	 myList.add(10);
	 myList.add(20);
	 myList.add(25);
	 
	 Integer iArr[] = new Integer[3];
	 iArr = myList.toArray(iArr);
	 
	 for (int i=0; i<3; i++)
	    System.out.printf("%d\n" ,  iArr[i]);
	    
	 Object oArr[] ; //new Integer[3];
	 oArr = myList.toArray();
	 
	 System.out.printf("o array length %d\n" ,  oArr.length);
	 
	 
	 for (Object o : oArr) {
	    System.out.printf("%d\n" ,  (Integer)o);
		 
	 }
	}

}
