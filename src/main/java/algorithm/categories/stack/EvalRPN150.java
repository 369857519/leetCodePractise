package algorithm.categories.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalRPN150 {

	public static void main(String[] args) {
		EvalRPN150 evalRPN150 = new EvalRPN150();
		evalRPN150.evalRPN(new String[]{"2", "1", "+", "3", "*"});
		evalRPN150.evalRPN(
			new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
	}

	public int evalRPN(String[] tokens) {
		Stack<String> stk = new Stack<>();
		Set<String> operator = new HashSet<>();
		operator.add("+");
		operator.add("-");
		operator.add("*");
		operator.add("/");
		if (tokens.length == 1) {
			return Integer.parseInt(tokens[0]);
		}
		int res = 0;
		for (String token : tokens) {
			if (!operator.contains(token)) {
				stk.push(token);
			} else {
				int num2 = Integer.parseInt(stk.pop());
				int num1 = Integer.parseInt(stk.pop());
				switch (token) {
					case "+":
						res = num1 + num2;
						break;
					case "-":
						res = num1 - num2;
						break;
					case "*":
						res = num1 * num2;
						break;
					case "/":
						res = num1 / num2;
						break;
				}
				stk.push(String.valueOf(res));
			}
		}
		return res;
	}
}
