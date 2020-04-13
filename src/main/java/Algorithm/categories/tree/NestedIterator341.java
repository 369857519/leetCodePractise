package Algorithm.categories.tree;

import Algorithm.Utils.MyNestedInteger;
import Algorithm.Utils.NestedInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator341 implements Iterator<Integer> {

	public static void main(String[] args) {
		List<NestedInteger> arr = new ArrayList<>();
		arr.add(new MyNestedInteger(2));
		arr.add(new MyNestedInteger(3));
		MyNestedInteger ele1 = new MyNestedInteger(arr);
		MyNestedInteger ele2 = new MyNestedInteger(2);
		List<NestedInteger> arr3 = new ArrayList<>();
		arr3.add(new MyNestedInteger(1));
		arr3.add(new MyNestedInteger(1));
		MyNestedInteger ele3 = new MyNestedInteger(arr3);

		List<NestedInteger> arrTest = new ArrayList<>();
		arrTest.add(ele1);
		arrTest.add(ele2);
		arrTest.add(ele3);

		NestedIterator341 nestedIterator = new NestedIterator341(arrTest);
		int test = 0;
		while (nestedIterator.hasNext()) {
			System.out.println(nestedIterator.next());
		}
	}

	Stack<List<NestedInteger>> stack = new Stack<>();
	Stack<Integer> indexStack = new Stack<>();
	List<Integer> flatList = new ArrayList<>();
	int currentFlatIndex = 0;

	public NestedIterator341(List<NestedInteger> nestedList) {
		stack.push(nestedList);
		indexStack.push(0);
	}

	@Override
	public Integer next() {
		if (currentFlatIndex < flatList.size()) {
			return flatList.get(currentFlatIndex++);
		} else {
			return step();
		}
	}

	@Override
	public boolean hasNext() {
		if (currentFlatIndex < flatList.size()) {
			return flatList.get(currentFlatIndex) != null;
		} else {
			return step() != null;
		}
	}

	public Integer step() {
		Integer nextInt = null;
		while (nextInt == null) {
			if (stack.empty()) {
				break;
			}
			nextInt = traverse();
		}
		flatList.add(nextInt);
		return nextInt;
	}

	public Integer traverse() {
		//处理调用栈缓存
		List<NestedInteger> currentList = stack.peek();
		int currentIndex = indexStack.peek();

		//让子元素优先入栈
		Integer resVal = null;
		if (currentIndex < currentList.size()) {
			NestedInteger curVal = currentList.get(currentIndex);
			indexStack.pop();
			indexStack.push(currentIndex + 1);
			if (curVal.isInteger()) {
				resVal = curVal.getInteger();
			} else {
				stack.push(curVal.getList());
				indexStack.push(0);
				return null;
			}
		} else {
			stack.pop();
			indexStack.pop();
		}
		return resVal;
	}
}

