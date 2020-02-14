package categories.math;

import java.util.Stack;

public class SimpleCaculator227 {

	public static void main(String[] args) {
		SimpleCaculator227 simpleCaculator227 = new SimpleCaculator227();
		simpleCaculator227.calculate("3+2*2");
	}

	public int calculate(String s) {
		int res = 0, num = 0;
		Stack<Integer> stack = new Stack<>();
		int lastOpr = '+';
		for (char character : (s + "+").toCharArray()) {
			if (character == ' ') {
				continue;
			}
			if (Character.isDigit(character)) {
				num = num * 10 + (character - '0');
			} else {
				switch (lastOpr) {
					case '+':
						stack.push(num);
						break;
					case '-':
						stack.push(-num);
						break;
					case '*':
						stack.push(stack.pop() * num);
						break;
					case '/':
						stack.push(stack.pop() / num);
						break;
					default:
						return -1;
				}
				num = 0;
				lastOpr = character;
			}

		}
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}
}
