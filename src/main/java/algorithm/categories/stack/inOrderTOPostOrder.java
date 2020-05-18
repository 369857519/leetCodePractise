package algorithm.categories.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class inOrderTOPostOrder {

	public static void main(String[] args) {

	}

	public String inOrderToPostOrder(String inOrderString) {
		char[] chars = inOrderString.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		Set<Character> calSet = new HashSet<>();
		char[] operators = "+-*/()".toCharArray();
		for (int i = 0; i < operators.length; i++) {
			calSet.add(operators[i]);
		}
		for (int i = 0; i < chars[i]; i++) {
			if (calSet.contains(chars[i])) {
				if (chars[i] == ')') {
					while (!stack.empty() && stack.peek() != '(') {
						stringBuilder.append(stack.pop());
					}
					stack.pop();
				} else {
					stack.push(chars[i]);
				}
			} else {
				stringBuilder.append(chars[i]);
			}
		}
		return stringBuilder.toString();
	}

}
