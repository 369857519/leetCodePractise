package categories.linkedList;

import Utils.ListNode;

public class AddTwoNumbers2 {

	public static void main(String[] args) {
		AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
		addTwoNumbers2.addTwoNumbers(ListNode.CreateListByArr(new int[]{2, 4, 3}),
			ListNode.CreateListByArr(new int[]{5, 6, 4}));
		addTwoNumbers2.addTwoNumbers(ListNode.CreateListByArr(new int[]{5}),
			ListNode.CreateListByArr(new int[]{5}));
		addTwoNumbers2.addTwoNumbers(ListNode.CreateListByArr(new int[]{1}),
			ListNode.CreateListByArr(new int[]{9, 9}));
	}

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next;
	 * ListNode(int x) { val = x; } }
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = new ListNode(0);
		ListNode p3Pre = null;
		ListNode l3 = p3;
		int addToNext = 0;
		while (p1 != null || p2 != null) {
			int p1Val = 0;
			int p2Val = 0;
			if (p1 != null) {
				p1Val = p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				p2Val = p2.val;
				p2 = p2.next;
			}
			int val = p1Val + p2Val + addToNext;
			addToNext=0;
			if (val > 9) {
				addToNext = val / 10;
				val = val % 10;
			}
			p3.val += val;
			p3.next = new ListNode(0);
			p3Pre = p3;
			p3 = p3.next;
		}
		if (addToNext != 0) {
			p3.val += addToNext;
		}
		if (p3Pre.next.val == 0) {
			p3Pre.next = null;
		}

		return l3;
	}
}
