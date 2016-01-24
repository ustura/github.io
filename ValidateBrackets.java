import java.util.Deque;
import java.util.ArrayDeque;

public class ValidateBrackets {

	static Deque stack = null;
	
	static final Character OPEN_BRACKET = '{';
	static final Character CLOSE_BRACKET = '}';
	
	public static boolean validate(String aStr) {
	
	stack = new ArrayDeque();	
	
		for (int i=0; i < aStr.length(); i++) {
			Character c = aStr.charAt(i);
			
			if (c.equals(OPEN_BRACKET)) {
				stack.push(1);
			}
			else if (c.equals(CLOSE_BRACKET)) {
				stack.pop();
			}
		}
		
		return (! (stack.size() > 0));
	}
	
	public static void main(String[] args)
	{
		String str1 = "{{{}{}{}}}" ; //valid
		String str2 = "{{{}{}{}}" ; //valid
		
		System.out.println(" is valid: " + ValidateBrackets.validate(str2));

	}
}
