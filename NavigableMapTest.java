import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest {
	
	private class TTest extends Thread {
		public  synchronized void run() { }
	}
	
    public static void main(String[] args) {
        NavigableMap<String, String> colors = new TreeMap<String, String>();
        colors.put("RED", "Red");
        colors.put("BLUE", "Blue");
	        System.out.println(colors.get("BLUE"));
	    }
	}
