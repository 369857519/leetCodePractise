package algorithm.categories.linkedList;

import algorithm.Utils.ListNode;

public class ReverseLinkedList206 {

    public static void main(String[] args) {
        ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();
        reverseLinkedList206.reverseList(ListNode.createListByArr(new int[]{1, 2, 3, 4, 5}));
        reverseLinkedList206.reverseList(ListNode.createListByArr(new int[]{1}));
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode nextPtr = head;
        while (nextPtr != null) {
            ListNode cur = nextPtr;
            nextPtr = nextPtr.next;
            cur.next = newHead;
            newHead = cur;
        }
        return newHead;
    }

}
