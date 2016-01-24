import java.util.Set;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class CustomersWho {
	
	static Map<String,LinkedList<String>> map = null;
	
	public static void buy(String item) {
		
		if (map == null) {
			map = new HashMap<String,LinkedList<String>>();
		}
		
		//iterate over all values lists, and append the incoming item.
		//take a copy of the list on final round
		//insert a tuple into map (item, list)

		if (map.get(item) == null) {
			LinkedList<String> aList = new LinkedList<String>();
			map.put(item,aList);
		}

		Set<String> keys = map.keySet();
		LinkedList<String> aList = null;
		for(String aKey: keys) {
//			if (aKey.equals(item)) continue;
			aList = map.get(aKey);
			if (aList == null) {
				aList = new LinkedList<String>();
			}

			aList.add(item);
			map.put(aKey,aList); //??
			//keepList = aList; //keep the last one
		}

	}
	
	public static List<String> relatedPurchases(String item) {
		return (map.get(item));
	}

	public static void printMap() {
		System.out.println(map);
	}

	public static void main(String[] args)
	{
		CustomersWho.buy("xbox");
		CustomersWho.buy("kinect");
		CustomersWho.buy("joystick");
		
		CustomersWho.printMap();
		
		List<String> alsoBought = CustomersWho.relatedPurchases("kinect");
		
		System.out.println("Customer alsoBought");
		for (String p:alsoBought) {
			System.out.println(p);
		}

		
	}
}
