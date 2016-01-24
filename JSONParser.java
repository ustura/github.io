import java.util.StringTokenizer;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Collection;

public class JSONParser {

 // { "key": val, => "\w":\w,  where 2nd w can be quoted - string,
 //											     non-quoted numeric - number
 //											     non-quoted alphnumeric - true/false boolean
//					"\w": [ \w,\w,..] array

	private class JSONType {
		/*
		String strVal;
		Integer iVal;
		Double dVal;
		Boolean bVal;
		* */
		Object val = null;
		int type; // 0: String, 1: Integer, 2:Double, 3:boolean
		
		public JSONType(Object aVal, int aType){
			switch(aType) {
				case 0:
					//strVal = (String)aVal;
					val = (String)aVal;
					break;
				case 1:
					//iVal = (Integer)aVal;
					val = (Integer)aVal;
					break;
				case 2:
					//dVal = (Double)aVal;
					val = (Double)aVal;
					break;
				case 3:
					//System.out.println("JSONTtype got boolean in [" + aVal + "]");
					val = (Boolean) aVal;
					//bVal = (Boolean) aVal;
					break;
				default :
			}
			type = aType;
		}
		
		/*
		public int hashCode() {
			int retHash = 0;
			switch(this.type) {
				case 0:
					retHash = ((String)val).hashCode();
					break;
				case 1:
					retHash = ((Integer)val).hashCode();
					break;
				case 2:
					retHash = ((Double)val).hashCode();
					break;
				case 3:
					retHash = ((Boolean)val).hashCode();
					break;
				default :
			}
			System.out.println("hashCode [" + retHash + "]");
			
			return retHash;
		}

		public boolean equals(Object rhs) {
			
			boolean ret = false;
			
			switch(this.type) {
				case 0:
					ret = ((String)val).equals(rhs);
				case 1:
					ret = ((Integer)val).equals(rhs);
				case 2:
					ret = ((Double)val).equals(rhs);
				case 3:
					ret = ((Boolean)val).equals(rhs);
				default :
			}

			System.out.println("equals [" + ret + "]");
			
			return ret;
		}
*/
	}
	
	private Map<String,JSONType> map;
//	private Map<String,Object> map;
	
	public JSONParser() {
		map = new TreeMap<String, JSONType>();
//		map = new TreeMap<String,Object>();
	}
	
	public void parse(String aJsonStr) {
		
		StringTokenizer st = new StringTokenizer(aJsonStr,"{}:,");
		
		String key = null;
		String val = null;
		while(st.hasMoreElements()) {
			key = ((String) st.nextElement()).replace("\"","");
			val = (String) st.nextElement();

			System.out.println(key + ":" + val);

			if (val.indexOf("\"") >= 0 ) {
				//string
				map.put(key,new JSONType(val,0));
//				map.put(key,val);
			}
			else 
			{
				Double dVal = null;
				Integer iVal = null;
				
				try {
					dVal = Double.parseDouble(val);
					
					assert(dVal != null);
					if (val.indexOf(".") == -1) { //integer
						//iVal = Integer.parseInteger(val);
						iVal = new Integer((int) dVal.intValue());
						assert(iVal != null);
						map.put(key,new JSONType(iVal,1)); //Integer
//						map.put(key,iVal); //Integer
					}
					else {
						map.put(key,new JSONType(dVal,2)); //Double
//						map.put(key,dVal); //Double
					}
				}
				catch(NumberFormatException e) {
					//boolean
					System.out.println("found boolean at [" + key + "]");
					Boolean bVal = Boolean.parseBoolean(val);
					assert(bVal != null);
//					if (val.equalsIgnoreCase("true")) {
						map.put(key,new JSONType(bVal,3)); 
//						map.put(key,bVal); 
	//				}
		//			else if (val.equalsIgnoreCase("false")) {
			//			map.put(key,new JSONType(false,3)); 
				//	}
				}
			}
		}//while
		
		/*
		Set<String> aKeySet = map.keySet();
		
		for (String aKey: aKeySet) {
			System.out.println("key [" + aKey + "]");
			JSONType aVal= map.get(aKey);
			System.out.println("aVal [" + aVal.val + "]");
		}
		*/
		Collection<JSONType> aValSet = map.values();

		for (JSONType aVal: aValSet) {
			/*
			switch(aVal.type) {
				case 0:
				System.out.println("aVal [" + aVal.getAs(0) + "]");
				case 1:
				System.out.println("aVal [" + aVal.getAs(1) + "]");
				case 2:
				System.out.println("aVal [" + aVal.getAs(2) + "]");
				case 3:
				System.out.println("aVal [" + aVal.getAs(3) + "]");
				default :
			}
			System.out.println("aVal [" + aVal.val + "]");
			* */
		}

	}
	
	public JSONType get(String aUserKey) {
		
		JSONType aVal= null;

//		System.out.println("Getting Userkey [" + aUserKey + "]");

		if (map.containsKey(aUserKey) ) {
			System.out.println("found key [" + aUserKey + "]");
			aVal= map.get(aUserKey);
		}
		else {
			System.out.println("key not found  [" + aUserKey + "]");
		}

		return aVal;
	}
	
	public static void main(String[] args)
	{
		/*
		{
		 "first": "John",
		 "last": "Doe",
		 "age": 39,
		 "sex": "M",
		 "salary": 70000,
		 "registered": true
		}
 		 */
 		 String inp = "{\"first\": \"John\",\"last\": \"Doe\",\"age\": 39,\"sex\": \"M\",\"salary\": 70000,\"registered\": true }";
		
		JSONParser jp = new JSONParser();
		jp.parse(inp);
		
		JSONParser.JSONType firstName = jp.get("first");
		JSONParser.JSONType reg = jp.get("registered");
	//	JSONParser.JSONType salary = jp.get("salary");
//		String firstName = (String) jp.get("first");
//		Integer salary = (Integer) jp.get("salary");
		
		System.out.println("firstName[" + firstName.val +"]");
		System.out.println("reg[" + reg.val +"]");
	//	System.out.println("salary" + salary);
	}
}
