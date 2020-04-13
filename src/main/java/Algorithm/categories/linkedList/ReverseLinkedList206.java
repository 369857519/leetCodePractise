package Algorithm.categories.linkedList;

import Algorithm.Utils.ListNode;

public class ReverseLinkedList206 {

    public static void main(String[] args) {
        ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();
        reverseLinkedList206.reverseList(ListNode.CreateListByArr(new int[]{1, 2, 3, 4, 5}));
        reverseLinkedList206.reverseList(ListNode.CreateListByArr(new int[]{1}));
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
