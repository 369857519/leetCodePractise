package categories.linkedList;

import Utils.ListNode;

public class LinkedListCycle141 {

    public static void main(String[] args) {
        ListNode.CreateListByArr(new int[]{1});
    }

    public boolean hasCycle(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while (ptr1 != null && ptr2 != null && ptr2.next!=null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            if (ptr1 == ptr2) {
                return true;
            }
        }
        return false;
    }

}
