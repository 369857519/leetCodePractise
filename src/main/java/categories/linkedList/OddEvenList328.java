package categories.linkedList;

import Utils.ListNode;

public class OddEvenList328 {

	public static void main(String[] args) {
		OddEvenList328 oddEvenList328 = new OddEvenList328();
		ListNode res = oddEvenList328
			.oddEvenList(ListNode.CreateListByArr(new int[]{1, 2, 3, 4, 5}));
		res = oddEvenList328.oddEvenList(ListNode.CreateListByArr(new int[]{}));
	}

	public ListNode oddEvenList(ListNode head) {
		ListNode current = head, odd = null, even = null, oddHead = null, evenHead = null;
		int cursor = 0;
		while (current != null) {
			if (cursor++ % 2 == 0) {
				if (odd == null) {
					odd = current;
					oddHead = current;
				} else {
					odd.next = current;
					odd = odd.next;
				}
			} else {
				if (even == null) {
					even = current;
					evenHead = current;
				} else {
					even.next = current;
					even = even.next;
				}
			}
			current = current.next;
		}
		if (odd != null) {
			odd.next = evenHead;
		}
		if (even != null) {
			even.next = null;
		}
		return oddHead;
	}

}
