package algorithm.categories.linkedList;

import algorithm.Utils.ListNode;

public class RMNthEnd19 {

	public static void main(String[] args) {
		RMNthEnd19 rmNthEnd19 = new RMNthEnd19();
		rmNthEnd19.removeNthFromEnd(ListNode.createListByArr(new int[] {1, 2, 3, 4, 5}), 2);
		rmNthEnd19.removeNthFromEnd(ListNode.createListByArr(new int[] {1}), 1);

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head, q = head;
		while (p != null) {
			if (n < 0) {
				q = q.next;
			}
			n--;
			p = p.next;
		}
		if (n == 0) {
			return head.next;
		}
		q.next = q.next.next;
		return head;
	}

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode ptr = head;
//        int length = 0;
//        while (ptr != null) {
//            length++;
//            ptr = ptr.next;
//        }
//        int pos = length - n;
//        if (pos == 0) {
//            return head.next;
//        }
//        ptr = head;
//        int counter = 1;
//        while (counter < pos) {
//            ptr = ptr.next;
//            counter++;
//        }
//        ptr.next = ptr.next.next;
//        return head;
//    }
}
