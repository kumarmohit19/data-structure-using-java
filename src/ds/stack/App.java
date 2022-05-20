package ds.stack;

public class App {

	public static void main(String[] args) {
//		Stack theStack = new Stack(3);
//		theStack.push(20);
//		theStack.push(40);
//		theStack.push(60);
//		theStack.push(80);
//		while (!theStack.isEmpty()) {
//			System.out.println(theStack.pop());
//		}
		
		System.out.println(reverseString("hello"));

	}
	
	public static String reverseString(String str){
		Stack<Character> theStack = new Stack<>(str.length());
		for(char c: str.toCharArray()){
			theStack.push(c);
		}
		StringBuilder rev = new StringBuilder("");
		while(!theStack.isEmpty()){
			rev.append(theStack.pop());
					
		}
		return rev.toString();
	}

}
