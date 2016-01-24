/*
Chris | Jones     | C#
Mia | Smith | PHP
Chris | Jones     | Java
Peter | Jones     | C#
Sophia | Wilson | Java
Mia | Wilson | C#
Mia | Smith | C#

Write a program printing all courses and the students, who have joined them, ordered by last name,
*  and then by first name (if the last names match).
*
* c# => Jones Chris, Jones Peter
* ..
* */

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap; //SortedMap impl
import java.util.SortedSet; 
import java.util.Set; 
import java.util.List; 
import java.util.TreeSet; 

public class CourseList {
	
	private Map<String,SortedMap<String,Set<String>>>  courseToStudent = null; //new Map<String,SortedMap<String,String>>();
	
	public CourseList() {
		courseToStudent = new TreeMap<String,SortedMap<String,Set<String>>>();
	}
	
	public void add(String name, String lastName, String course) {
		
		SortedMap<String,Set<String>> aStudentMap = courseToStudent.get(course);
		
		if (aStudentMap == null) {
//			System.out.println("creating studMap for course[ " + course + "]:");
			aStudentMap = new TreeMap<String,Set<String>>();
		}
	
		Set<String> names = aStudentMap.get(lastName);
		if (names == null) {
			//System.out.println("creating studMap for course[ " + course + "]:");
			names = new TreeSet<String>();
		}
		
		names.add(name);
		aStudentMap.put(lastName,names);
		
		courseToStudent.put(course,aStudentMap);
		//System.out.println("courseToStudent map[" + courseToStudent );
	}
	
	public void printList() {
		
		Set<String> courses = courseToStudent.keySet();
		
		for(String aCourse: courses) {

			System.out.println("\nEnrollment for[ " + aCourse + "]");
			
			SortedMap<String,Set<String>> aStudentMap = courseToStudent.get(aCourse);
			Set<String> lastNames = aStudentMap.keySet();
			TreeSet<String> lastNamesSorted = new TreeSet(lastNames);

			for(String aLast: lastNamesSorted) {
				System.out.print("[ " + aLast + ":");
				Set<String> names = aStudentMap.get(aLast);
				TreeSet<String> namesSorted = new TreeSet(names);
				
				for(String aName: namesSorted) {
//					String name = aStudentMap.remove(aLast);
					System.out.print(aName + ",");
				}
				System.out.println("]");
			}
			
		}
	}
	public static void main(String[] args)
	{
		String[] name = {"Chris","Mia","Chris","Peter","Zhia"};
		String[] lastName = {"Jones","Smith","Jones","Jones","Smith"};
		String[] course = {"C#","PHP","Java","C#","PHP"};

		CourseList cs = new CourseList();
			
		for (int i=0; i< name.length; i++) {
			cs.add(name[i],lastName[i],course[i]);
		}
		
		System.out.println("*****************");
		cs.printList();

/*		
		Map<String,List<String>> map = new TreeMap<String,List<String>>();
		
		String last = "Uyan";
		String first = "first_";
		
		for (int i=0; i<5; i++) {
			map.put(last,first+i);
		}

		System.out.println(" map contents[" + map );
		* */
	}
	
}
