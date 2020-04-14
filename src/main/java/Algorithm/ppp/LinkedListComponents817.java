package Algorithm.ppp;

import Algorithm.Utils.ListNode;
import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents817 {

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next;
	 * ListNode(int x) { val = x; } }
	 */
	public static void main(String[] args) {
		LinkedListComponents817 linkedListComponents817 = new LinkedListComponents817();
		ListNode node = ListNode.createListByArr(new int[]{0, 1, 2, 3});
		int i = linkedListComponents817.numComponents(node, new int[]{0, 1, 3});
	}

	public int numComponents(ListNode head, int[] G) {
		Set<Integer> curSet = new HashSet<>();
		for (int i = 0; i < G.length; i++) {
			curSet.add(G[i]);
		}
		int count = 0;
		while (head != null) {
			if (curSet.contains(head.val) && (head.next == null || !curSet
				.contains(head.next.val))) {
				count++;
			}
			head = head.next;
		}
		return count;
	}
}
