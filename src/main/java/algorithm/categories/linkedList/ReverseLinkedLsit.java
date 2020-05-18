package algorithm.categories.linkedList;

import algorithm.Utils.ListNode;

public class ReverseLinkedLsit {
    public ListNode reverseList(ListNode head) {
        ListNode newHead=null;
        ListNode cur=head;
        ListNode nextCur=head;
        while(cur!=null){
            nextCur=cur.next;
            cur.next=newHead;
            newHead=cur;
            cur=nextCur;
        }
        return newHead;
    }
}
