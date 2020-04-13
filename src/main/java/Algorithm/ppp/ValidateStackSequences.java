package Algorithm.ppp;

import java.util.Stack;

public class ValidateStackSequences {

	public static void main(String[] args) {
		int[] pushed = new int[]{1, 2, 3, 4, 5};
		int[] popped = new int[]{1, 2, 3, 4, 5};
		ValidateStackSequences validateStackSequences = new ValidateStackSequences();
		System.out.println(validateStackSequences.validateStackSequences(pushed, popped));
	}

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed.length==0){
			return true;
		}
		Stack<Integer> stk = new Stack<>();
		int len = pushed.length;
		int pushPivot = 0;
		int popPivot = 0;
		do {
			if (stk.empty() || popped[popPivot] != stk.peek()) {
				stk.push(pushed[pushPivot++]);
			} else {
				stk.pop();
				++popPivot;
			}
		} while (!(stk.empty() && pushPivot == len)
			&& !(pushPivot == len && popPivot != len && popped[popPivot] != stk.peek()));
		return pushPivot == pushed.length && popPivot == popped.length;
	}
}
