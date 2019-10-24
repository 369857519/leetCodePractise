package categories.linkedList;

import Utils.ListNode;

public class LinkedListCycleII142 {

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, quick = head;
		while (slow != null && quick != null && quick.next != null) {
			slow = slow.next;
			quick = quick.next.next;
			if (slow == quick) {
				break;
			}
		}
		slow = head;
		while (slow != head) {
			slow = slow.next;
			head = head.next;
		}
		return slow;
	}
}
