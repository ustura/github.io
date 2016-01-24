public class Squeeze {

	public static String squeeze(String aStr) {
		if (aStr == null) { 
			return null;
		}
		
		int ndx = 0;
		int zeros = 0;
		char[] arr = aStr.trim().toCharArray();
		StringBuilder dst = new StringBuilder();
		
		while (ndx < arr.length)		{
			if (zeros > 0) {
				dst.append(' ');
				zeros = 0;
			}
			
			while (ndx < arr.length && arr[ndx] != ' ') {
				dst.append(arr[ndx]);
				ndx++;
			}
			while (ndx < arr.length && arr[ndx] == ' ') {
				ndx++;
				zeros++;
			}
		}
		
		return dst.toString();
	}
	
	public static void main(String[] args) {
		
		String str = squeeze(args[0]);
		System.out.println("squeezed : " + str);
		
	}
}
