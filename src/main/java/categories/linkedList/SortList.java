package categories.linkedList;

import Utils.ListNode;

public class SortList {

	public static void main(String[] args) {
		ListNode listNode = ListNode.CreateListByArr(new int[]{3, 1, 2, 20, 9, 1});
		SortList sortList = new SortList();
		sortList.sortList(listNode);
	}

	public ListNode sortList(ListNode head) {
		if (head.next == null) {
			return head;
		}
		return partition(head);
	}

	public ListNode partition(ListNode head) {
		if (head.next == null) {
			return head;
		}
		int counter = 0;
		ListNode left = null, leftHead = null, right = null, rightHead = null;
		while (head != null) {
			if (counter % 2 == 0) {
				if (left == null) {
					left = head;
					leftHead = head;
				} else {
					left.next = head;
					left = left.next;
				}
			} else {
				if (right == null) {
					right = head;
					rightHead = head;
				} else {
					right.next = head;
					right = right.next;
				}
			}
			counter++;
			head = head.next;
		}
		partition(leftHead);
		partition(rightHead);
		return merge(leftHead, rightHead);
	}

	public ListNode merge(ListNode left, ListNode right) {
		ListNode start, pointer;
		if (left.val < right.val) {
			pointer = left;
			start = left;
		} else {
			pointer = right;
			start = right;
		}
		while (left == null && right == null) {
			if (left == null) {
				pointer.next = right;
				break;
			}
			if (right == null) {
				pointer.next = left;
				break;
			}
			if (left.val < right.val) {
				pointer.next = left;
				pointer = pointer.next;
				left = left.next;
			} else {
				pointer.next = right;
				pointer = pointer.next;
				left = left.next;
			}
		}
		return start;
	}

}
