package algorithm.categories.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedunConnec684 {

	public static void main(String[] args) {
		RedunConnec684 redunConnec684 = new RedunConnec684();
		int[] res = redunConnec684.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
	}

	public int[] findRedundantConnection(int[][] edges) {
		//转临接矩阵
		HashMap<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			map.putIfAbsent(edges[i][0], new HashSet<>());
			map.get(edges[i][0]).add(edges[i][1]);
		}
		return draw(edges[0][0], map, new HashSet<>());
	}

	//找到环，
	public int[] draw(int current, Map<Integer, Set<Integer>> edges, Set<Integer> nodes) {
		nodes.add(current);
		Set<Integer> nextNodes = edges.get(current);
		int[] res = null;
		if (nextNodes != null) {
			for (int i : nextNodes) {
				if (nodes.contains(i)) {
					//说明有环
					return new int[]{current, i};
				}
				int[] temp = draw(i, edges, nodes);
				if (temp != null) {
					res = temp;
				}
			}
		}
		return res;
	}
}
