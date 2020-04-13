package Algorithm.categories.linkedList;

import Algorithm.Utils.ListNode;

public class IntersectionOfTwoLinkedList160 {

    public static void main(String[] args) {
        IntersectionOfTwoLinkedList160 intersectionOfTwoLinkedList160 = new IntersectionOfTwoLinkedList160();
        ListNode common = ListNode.CreateListByArr(new int[]{1, 2, 3, 4});
        ListNode headA = ListNode.CreateListByArr(new int[]{5, 7});
        ListNode headB = ListNode.CreateListByArr(new int[]{7, 9, 0});
        headA.next.next = common;
        headB.next.next.next = common;
        intersectionOfTwoLinkedList160.getIntersectionNode(headA, headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode ptr = headA;
        while (ptr != null) {
            lengthA++;
            ptr = ptr.next;
        }
        ptr = headB;
        while (ptr != null) {
            lengthB++;
            ptr = ptr.next;
        }
        if (lengthA < lengthB) {
            ptr = headA;
            headA = headB;
            headB = ptr;
        }
        int sub = Math.abs(lengthA - lengthB);
        while (sub > 0) {
            sub--;
            headA = headA.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
