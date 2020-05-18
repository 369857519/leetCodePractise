package algorithm.ppp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathFromSourceToTarget {

	private Stack<Integer> stack = new Stack<Integer>();
	private List<List<Integer>> resList = new ArrayList<List<Integer>>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		getPath(graph,0);
		return resList;
	}

	public void getPath(int[][] graph, int x) {
		if (x < graph.length) {
			stack.push(x);
			if (stack.peek() == graph.length - 1) {
				List<Integer> list = new ArrayList<Integer>();
				for (int i : stack) {
					list.add(i);
				}
				resList.add(list);
			}
		}
		for (int i = 0; i < graph[x].length; i++) {
			int nextX = graph[x][i];
			getPath(graph, nextX);
		}
		if(!stack.empty()){
			stack.pop();
		}
	}
}
