package algorithm.categories.linkedList;


import algorithm.Utils.ListNode;

/**
 * Created by 祁连山 on 2019/4/14.
 */


public class MergeTwoList21 {


    public static void main(String[] args) {
        MergeTwoList21 mergeTwoList21 = new MergeTwoList21();
        ListNode listNode = mergeTwoList21
            .mergeTwoLists(ListNode.createListByArr(new int[]{1, 2, 4}),
                ListNode.createListByArr(new int[]{1, 3, 4}));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode ptr = head;
        while (!(l1 == null && l2 == null)) {
            if (l1 == null) {
                ptr.next = l2;
                break;
            }
            if (l2 == null) {
                ptr.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        head = head.next;
        return head;
    }
}
