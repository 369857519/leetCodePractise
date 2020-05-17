package algorithm.categories.linkedList;

import algorithm.Utils.ListNode;

public class AddTwoNumbers2 {

    public static void main(String[] args) {
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        addTwoNumbers2.addTwoNumbers(ListNode.createListByArr(new int[]{2, 4, 3}),
            ListNode.createListByArr(new int[]{5, 6, 4}));
        addTwoNumbers2.addTwoNumbers(ListNode.createListByArr(new int[]{5}),
            ListNode.createListByArr(new int[]{5}));
        addTwoNumbers2.addTwoNumbers(ListNode.createListByArr(new int[]{1}),
            ListNode.createListByArr(new int[]{9, 9}));
    }

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next;
     * ListNode(int x) { val = x; } }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1ptr = l1;
        ListNode l2ptr = l2;
        int sum = 0, carry = 0;
        ListNode l3 = new ListNode(0);
        ListNode l3ptr = l3;
        while (!(l1ptr == null && l2ptr == null)) {
            if (l1ptr == null) {
                sum = l2ptr.val + carry;
                l2ptr = l2ptr.next;
            } else if (l2ptr == null) {
                sum = l1ptr.val + carry;
                l1ptr = l1ptr.next;
            } else {
                sum = l1ptr.val + l2ptr.val + carry;
                l1ptr = l1ptr.next;
                l2ptr = l2ptr.next;
            }
            carry = sum / 10;
            l3ptr.next = new ListNode(sum % 10);
            l3ptr = l3ptr.next;
        }
        if (carry != 0) {
            l3ptr.next = new ListNode(carry);
        }
        l3ptr = l3.next;
        l3 = l3ptr;
        return l3;
    }
}
