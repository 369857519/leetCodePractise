package categories.tree;

import Utils.NestedInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

	List<NestedInteger> nestedIntegers;
	Stack<NestedInteger> stack = new Stack<>();

	public NestedIterator(List<NestedInteger> nestedList) {
		nestedIntegers = nestedList;
	}

	public void traverse(List<NestedInteger> list) {
		while (stack.isEmpty()) {
			//让子元素优先入栈
			if(stack.peek().isInteger()){
				stack.pop();
			}else{
				List<NestedInteger> subList=stack.pop().getList();
			}
		}
	}

	@Override
	public Integer next() {
		return 0;
	}

	@Override
	public boolean hasNext() {
		return false;
	}
}

