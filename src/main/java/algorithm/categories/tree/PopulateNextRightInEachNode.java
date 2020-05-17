package algorithm.categories.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightInEachNode {

	class Node {

		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public Node connect(Node root) {
		if (root == null) {
			return root;
		}
		Queue<Node> queue = new LinkedList<>();
		Queue<Node> cacheQueue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node preNode = null;
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				if (preNode != null && node != null) {
					preNode.next = node;
				}
				if (node.left != null) {
					cacheQueue.offer(node.left);
				}
				if (node.right != null) {
					cacheQueue.offer(node.right);
				}
				preNode = node;
			}
			while (!cacheQueue.isEmpty()) {
				queue.offer(cacheQueue.poll());
			}
		}
		return root;
	}

}
