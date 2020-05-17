package algorithm.ppp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstruction {

	public static void main(String[] args) {
		QueueReconstruction queueReconstruction = new QueueReconstruction();
		int[][] tes = new int[][]{
			{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
		};
		queueReconstruction.reconstructQueue(tes);
	}

	//	Input:
//		[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//	Output:
//		[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	public int[][] reconstructQueue(int[][] people) {
		if(people.length==0){
			return people;
		}
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < people.length; i++) {
			list.add(people[i]);
		}
		list.sort(Comparator.comparing((int[] arr) -> arr[1]));
		list.sort(Comparator.comparing((int[] arr) -> arr[0]).reversed());
		LinkedList<int[]> res = new LinkedList<>();
		//init
		int currentIndex = 0;
		res.add(list.get(0));
		while (res.size() < people.length) {
			int[] current = list.get(++currentIndex);
			int count = 0;
			for (int i = 0; i < res.size(); ++i) {
				if (current[1] == 0) {
					res.add(0, current);
					break;
				}
				if (res.get(i)[0] >= current[0]) {
					count++;
				}
				if (count == current[1]) {
					res.add(i + 1, current);
					break;
				}
			}
		}
		return res.toArray(new int[][]{});
	}
}
