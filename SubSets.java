/*
Find all subssets of a given set
* 
* Method signature: 
* public Set<Set> findSubSets(Set aSet);
* 
* Example input: { 0, 1, 2 }
* output  : null, 0 , 1 , 2 , {0, 1}, { 1, 2} , {0, 3 } , { 0,1,2}
* 
* Given a set S with N elements: 
* 
*  if S is empty, return null
* 
* Take an element E out of S 
*  find the subsets of the smaller set by calling self 
*  Augment the resulting set of subsets by adding E into the set by itself
*   and by adding E into every subset of the resulting set (except empty-null subset)
* 
*  Example input run:
*  given {null} , returns : a set containing a null object
*  given {a}, returns : a set containing a null object, and a
*  given {a,b}, returns : a set containing a null ,  a , b, { a,b}
*  
*/

import java.util.Set;
import java.util.SortedSet;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;

public class SubSets <T> {

	
	public Set<SortedSet<T>> findSubSets(SortedSet<T> aSet) {
		
		Set<SortedSet<T>> aSS = null;
			
		if (aSet != null) {
			
				T E = aSet.first();
			if (aSet.size() > 0) {

				boolean stat = aSet.remove(E);
				assert(stat);

				Set<SortedSet<T>> aTmp = new HashSet<SortedSet<T>>();
				
				aSS = findSubSets(aSet);
//				System.out.println("aSS after findSubSets: " + aSS);
				
				if (aSS != null) {
					
					aTmp.addAll(aSS);
//					System.out.println("aTmp: " + aTmp);
					
					Iterator<SortedSet<T>> it = aSS.iterator();
					
					while (it.hasNext() ) {
						SortedSet<T> sOld = (SortedSet<T>) it.next();
						SortedSet<T> s = new TreeSet<T>();
						s.addAll(sOld);
//						System.out.println("s: " + s);
						s.add(E);
//						System.out.println("s more: " + s);
						aTmp.add(s);
//					    System.out.println("aTmp more: " + aTmp);
					}
				}

				SortedSet<T> onlyE = new TreeSet<T>();
				onlyE.add(E);
//				System.out.println("onlyE" + onlyE);

				aTmp.add(onlyE);
//				System.out.println("aTmp: " + aTmp);
				aSS = aTmp;
			}
		}

//		System.out.println("aSS: " + aSS);
		return aSS;
	}
     	
	public static void main(String[] args) {
		
		SortedSet<String> initSet = new TreeSet<String>();
		initSet.add("a");
		initSet.add("b");
		initSet.add("c");
		initSet.add("d");
		initSet.add("e");
		
		SubSets<String> finder = new SubSets<String>();
		Set<SortedSet<String>>  subSet = finder.findSubSets(initSet);
		
		System.out.println("subSet Size: " + subSet.size());
		System.out.println("subSet: " + subSet);
		
	}
}
