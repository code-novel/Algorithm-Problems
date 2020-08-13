import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1918_후위표기식{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();++i) {
			char c=s.charAt(i);
			switch(c) {
				case '*' :
				case '/' :
					if(stack.empty()) {
						stack.add(c);
					}else {
						char tmp=stack.peek();
						if(tmp=='*'||tmp=='/') {
							System.out.print(stack.pop());
						}
						stack.add(c);
					}
					break;
				case '+' :
				case '-' :
					if(stack.empty()) {
						stack.add(c);
					}else {
						while(!stack.isEmpty()&&stack.peek()!='(') {
							System.out.print(stack.pop());
						}
						stack.add(c);
					}
					break;
				case '(' :
					stack.add(c);
					break;
				case ')' :
					while(stack.peek()!='(') {
						System.out.print(stack.pop());
					}
					stack.pop();
					break;
					default :
						System.out.print(c);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}