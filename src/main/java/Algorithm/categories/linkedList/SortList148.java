package Algorithm.categories.linkedList;

import Algorithm.Utils.ListNode;

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
		return null;
	}
}
