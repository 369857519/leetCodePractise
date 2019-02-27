package ppp;


public class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode CreateListByArr(int[] arr) {
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
		for (int i = 1; i < arr.length; i++) {
			current.next = new ListNode(arr[i]);
			current = current.next;
		}
		return head;
	}
}
