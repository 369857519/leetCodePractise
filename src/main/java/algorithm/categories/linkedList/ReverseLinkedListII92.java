package algorithm.categories.linkedList;

import algorithm.Utils.ListNode;

public class ReverseLinkedListII92 {

    public static void main(String[] args) {
        ReverseLinkedListII92 reverseLinkedListII92 = new ReverseLinkedListII92();
        ListNode node = reverseLinkedListII92
            .reverseBetween(ListNode.createListByArr(new int[]{1, 2, 3, 4, 5}), 2, 4);
        node = reverseLinkedListII92.reverseBetween(ListNode.createListByArr(new int[]{1}), 1, 1);
        node = reverseLinkedListII92
            .reverseBetween(ListNode.createListByArr(new int[]{1, 2}), 1, 1);
        node = reverseLinkedListII92
            .reverseBetween(ListNode.createListByArr(new int[]{3, 4}), 1, 2);

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode leftPartTail = null;
        ListNode middlePartHead = null;
        ListNode middlePartTail = null;
        ListNode rightPartHead = null;
        ListNode ptr = head;
        //get pointer
        int counter = 0;
        while (ptr != null) {
            counter++;
            if (counter == m - 1) {
                leftPartTail = ptr;
            }
            if (counter == m) {
                middlePartHead = ptr;
            }
            if (counter == n) {
                middlePartTail = ptr;
            }
            if (counter == n + 1) {
                rightPartHead = ptr;
            }
            ptr = ptr.next;
        }
        //reverse
        ptr = null;
        ListNode next = middlePartHead;
        while (next != rightPartHead) {
            ListNode tmp = next;
            next = next.next;
            tmp.next = ptr;
            ptr = tmp;
        }
        //connect
        middlePartHead.next = rightPartHead;
        if (leftPartTail != null) {
            leftPartTail.next = middlePartTail;
            return head;
        } else {
            return middlePartTail;
        }
    }

}
