package categories.tree;

import Utils.MyNestedInteger;
import Utils.NestedInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NestedIteratorByQueue341 implements Iterator<Integer> {

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

		NestedIteratorByQueue341 nestedIterator = new NestedIteratorByQueue341(arrTest);
		int test = 0;
		while (nestedIterator.hasNext()) {
			System.out.println(nestedIterator.next());
		}
	}

	Queue<Integer> queue = new LinkedList<>();

	public NestedIteratorByQueue341(List<NestedInteger> nestedList) {
		addToQueue(nestedList);
	}

	@Override
	public Integer next() {
		return queue.poll();
	}

	@Override
	public boolean hasNext() {
		return queue.isEmpty();
	}

	public void addToQueue(List<NestedInteger> list) {
		for (NestedInteger nestedInteger : list) {
			if (nestedInteger.isInteger()) {
				queue.offer(nestedInteger.getInteger());
			} else {
				addToQueue(nestedInteger.getList());
			}
		}
	}
}

