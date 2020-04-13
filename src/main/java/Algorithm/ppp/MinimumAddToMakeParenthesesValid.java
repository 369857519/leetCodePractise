package Algorithm.ppp;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
	public int minAddToMakeValid(String S) {
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<S.length();i++){
			char currentValue=S.charAt(i);
			if(stack.empty()){
				stack.push(S.charAt(i));
			}else{
				if(currentValue==')'){
					if(stack.peek()==')'){
						stack.push(currentValue);
					}else{
						stack.pop();
					}
				}else if(currentValue=='('){
					stack.push(currentValue);
				}
			}
		}
		return stack.size();
	}
}
