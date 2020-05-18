package algorithm.categories.tree;

import algorithm.Utils.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryLevelOrder429 {

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		if (null != root) {
			queue.offer(root);
		}
		while(!queue.isEmpty()){
			res.add(new ArrayList<>());
			List<Integer> cur=res.get(res.size()-1);
			int size=queue.size();
			for(int i=0;i<size;i++){
				Node node=queue.poll();
				cur.add(node.val);
				((LinkedList<Node>) queue).addAll(node.neighbors);
			}
		}
		return res;
	}
}
