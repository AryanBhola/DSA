package dsa;
import java.util.Stack;
public class DuplicateParanthesis {

	public static void main(String[] args) {
		String str = "(((a+(b)))+(c+d))";
		System.out.print(check(str));
	}
	public static boolean check(String str) {
		Stack<Character> s = new Stack<>();
		for(int i=0;i<str.length();i++) {
		    char ch = str.charAt(i);
			//closing bracket case
		    if(ch == ')') {
		    int	count = 0;
		    while(!(s.peek() == '(')) {
		    	s.pop();
		    	count++;
		    }
		    if(count<1) {
		    	return true;
		    }
		    else {
		    	s.pop();
		    }
		    }
			//opening bracket, operator ... case
		    else {
		    	s.push(ch);
		    }
			
}
		return false;
	}
	
	

}
