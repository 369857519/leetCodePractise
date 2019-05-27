package categories.linkedList;

import Utils.ListNode;
import Utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class RMNthEnd19 {

	public static void main(String[] args) {
		ListNode listNode = ListNode.CreateListByArr(new int[]{1, 2});
		new RMNthEnd19().removeNthFromEnd(listNode, 2);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ptr = head;
		List<ListNode> list = new ArrayList<>();
		while (ptr != null) {
			list.add(ptr);
			ptr = ptr.next;
		}
		int len = list.size();
		//删的是头节点
		if (n == list.size()) {
			return head.next;
		}

		list.get(len - (n + 1)).next = list.get(len - (n)).next;
		return head;
	}
}
