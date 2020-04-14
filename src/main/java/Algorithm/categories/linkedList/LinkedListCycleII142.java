package Algorithm.categories.linkedList;

import Algorithm.Utils.ListNode;

public class LinkedListCycleII142 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListByArr(new int[]{3, 2, 0, -1});
        ListNode listNode1 = ListNode.createListByArr(new int[]{1, 2});
        listNode.next.next.next.next = listNode.next;
        LinkedListCycleII142 linkedListCycleII142 = new LinkedListCycleII142();
        ListNode res = linkedListCycleII142.detectCycle(listNode);
        res = linkedListCycleII142.detectCycle(listNode1);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        boolean hasCycle = false;
        while (ptr1 != null && ptr2 != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            if (ptr1 == ptr2) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        ptr1 = head;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
