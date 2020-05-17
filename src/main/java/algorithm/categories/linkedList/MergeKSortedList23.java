package algorithm.categories.linkedList;

import algorithm.Utils.ListNode;

public class MergeKSortedList23 {

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.createListByArr(new int[]{1, 3, 5});
        ListNode listnode2 = ListNode.createListByArr(new int[]{2, 4, 6});
        ListNode listNode3 = ListNode.createListByArr(new int[]{10});
        ListNode[] listNodes = {listNode1, listnode2,listNode3};
        MergeKSortedList23 mergeKSortedList23 = new MergeKSortedList23();
        mergeKSortedList23.mergeKLists(listNodes);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length);
    }

    public ListNode merge(ListNode[] listNodes, int start, int end) {
        if (end - start == 1) {
            return listNodes[start];
        }
        int mid = start + end >> 1;
        ListNode left = merge(listNodes, start, mid);
        ListNode right = merge(listNodes, mid, end);
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while (!(left == null && right == null)) {
            if(left==null) {
                ptr.next=right;
                break;
            }
            if(right==null) {
                ptr.next = left;
                break;
            }
            if (left.val < right.val) {
                ptr.next = left;
                left = left.next;
            }else{
                ptr.next = right;
                right = right.next;
            }
            ptr = ptr.next;
        }
        ptr = head;
        head = head.next;
        ptr.next = null;
        return head;
    }

}
