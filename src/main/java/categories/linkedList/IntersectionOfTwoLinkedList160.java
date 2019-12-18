package categories.linkedList;

import Utils.ListNode;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedList160 {

	public ListNode getIntersectionNodeOn(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		while (headB != null) {
			if (set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0, lenB = 0;
		ListNode headAP = headA, headBP = headB;
		while (headA != null) {
			lenA++;
			headA = headA.next;
		}
		while (headB != null) {
			lenB++;
			headB = headB.next;
		}
		int distance = lenA - lenB;
		if (distance > 0) {
			while (distance > 0) {
				distance--;
				headAP = headAP.next;
			}
		} else {
			distance = Math.abs(distance);
			while (distance > 0) {
				distance--;
				headBP = headBP.next;
			}
		}
		while (headAP != headBP) {
			headAP = headAP.next;
			headBP = headBP.next;
		}
		return headAP;
	}
}
