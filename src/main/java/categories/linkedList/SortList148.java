package categories.linkedList;

import Utils.ListNode;

public class SortList148 {

	public static void main(String[] args) {
		SortList148 sortList = new SortList148();
		ListNode listNode1 = sortList
			.sortList(ListNode.CreateListByArr(new int[]{3, 1, 2, 20, 9, 7, 4}));
		listNode1 = sortList.sortList(ListNode.CreateListByArr(new int[]{}));
		listNode1 = sortList.sortList(ListNode.CreateListByArr(new int[]{123}));
		listNode1 = sortList.sortList(ListNode.CreateListByArr(new int[]{1, 22}));
	}

	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}

	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		int counter = 0;
		ListNode left = null, leftHead = null, right = null, rightHead = null, prev = null;
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
			prev = head;
			head = head.next;
			prev.next = null;
		}
		leftHead = mergeSort(leftHead);
		rightHead = mergeSort(rightHead);
		return merge(leftHead, rightHead);
	}

	public ListNode merge(ListNode left, ListNode right) {
		ListNode start = null, pointer = null;

		while (true) {
			if (left == null) {
				if (pointer == null) {
					pointer = right;
				} else {
					pointer.next = right;
				}
				break;
			}
			if (right == null) {
				if (pointer == null) {
					pointer = left;
				} else {
					pointer.next = left;
				}
				break;
			}
			if (left.val < right.val) {
				if (pointer == null) {
					pointer = left;
					left = left.next;
				} else {
					pointer.next = left;
					pointer = pointer.next;
					left = left.next;
				}
			} else {
				if (pointer == null) {
					pointer = right;
					right = right.next;
				} else {
					pointer.next = right;
					pointer = pointer.next;
					right = right.next;
				}
			}
			if (start == null) {
				start = pointer;
			}
		}
		return start;
	}

	public ListNode sortListAns(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head, slow = head, pre = null;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		return mergeAns(sortListAns(head), sortList(slow));
	}

	public ListNode mergeAns(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeAns(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeAns(l1, l2.next);
			return l2;
		}
	}

}
