package ppp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListComponents817 {

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next;
	 * ListNode(int x) { val = x; } }
	 */
	public static void main(String[] args) {
		LinkedListComponents817 linkedListComponents817=new LinkedListComponents817();

	}
	class Solution {

		public int numComponents(ListNode head, int[] G) {
			Set<Integer> curSet = new HashSet<>();
			for (int i = 0; i < G.length; i++) {
				curSet.add(G[i]);
			}
			int count = 0;
			ListNode pre = null;
			while (head.next != null) {
				if (!curSet.contains(pre) && curSet.contains(head)) {
					count++;
				}
				pre = head;
				head = head.next;
			}
			return count;
		}
	}
}
