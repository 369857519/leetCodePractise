package categories.linkedList;

import Utils.ListNode;

public class LinkedListCycleII142 {

	public static void main(String[] args) {
		ListNode listNode = ListNode.CreateListByArr(new int[]{3, 2, 0, -1});
		ListNode listNode1 = ListNode.CreateListByArr(new int[]{1, 2});
		listNode.next.next.next.next = listNode.next;
		LinkedListCycleII142 linkedListCycleII142 = new LinkedListCycleII142();
		ListNode res = linkedListCycleII142.detectCycle(listNode);
		res = linkedListCycleII142.detectCycle(listNode1);
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head, quick = head;
		boolean hasCycle = false;
		while (slow != null && quick != null && quick.next != null) {
			slow = slow.next;
			quick = quick.next.next;
			if (slow == quick) {
				hasCycle = true;
				break;
			}
		}
		if (!hasCycle) {
			return null;
		}
		slow = head;
		while (slow != quick) {
			slow = slow.next;
			quick = quick.next;
		}
		return slow;
	}
}
