package algorithm.categories.linkedList;

import algorithm.Utils.ListNode;

public class PalindromeLinkedList234 {

    public static void main(String[] args) {
        PalindromeLinkedList234 palindromeLinkedList234 = new PalindromeLinkedList234();
//		palindromeLinkedList234.isPalindrome(ListNode.CreateListByArr(new int[]{1, 2, 2, 1}));
        palindromeLinkedList234.isPalindrome(ListNode.createListByArr(new int[]{1, 2, 2}));
        palindromeLinkedList234.isPalindrome(ListNode.createListByArr(new int[]{}));
    }

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }
        ListNode slow;
        return false;
    }


}
