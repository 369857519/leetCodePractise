package categories.linkedList;

import Utils.ListNode;
import java.util.Stack;

public class PalindromeLinkedList234 {

	public static void main(String[] args) {
		PalindromeLinkedList234 palindromeLinkedList234 = new PalindromeLinkedList234();
//		palindromeLinkedList234.isPalindrome(ListNode.CreateListByArr(new int[]{1, 2, 2, 1}));
		palindromeLinkedList234.isPalindrome(ListNode.CreateListByArr(new int[]{1, 2, 2}));
		palindromeLinkedList234.isPalindrome(ListNode.CreateListByArr(new int[]{}));
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode midNode = findMidNode(head);
		ListNode reversed = reverse(midNode);
		while (reversed != null) {
			if (head.val != reversed.val) {
				return false;
			}
			head = head.next;
			reversed = reversed.next;
		}
		return true;
	}

	public ListNode findMidNode(ListNode node) {
		return node;
	}

	public ListNode reverse(ListNode node) {
		return node;
	}

	public boolean isPalindromeSelf(ListNode head) {
		int length = 0;
		ListNode headP = head;
		while (head != null) {
			length++;
			head = head.next;
		}
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		head = headP;
		while (head != null) {
			count++;
			if (length % 2 == 0) {
				if (count <= length / 2) {
					stack.push(head.val);
				} else {
					if (stack.pop() != head.val) {
						return false;
					}
				}
			} else {
				if (count <= length / 2) {
					stack.push(head.val);
				} else if (count == length / 2 + 1) {
					head = head.next;
					continue;
				} else {
					if (stack.pop() != head.val) {
						return false;
					}
				}
			}
			head = head.next;
		}
		return true;
	}

}
