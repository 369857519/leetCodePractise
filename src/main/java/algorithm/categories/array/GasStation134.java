package algorithm.categories.array;

import java.util.ArrayList;
import java.util.List;

public class GasStation134 {

	public static void main(String[] args) {
//		GasStation134 gasStation134 = new GasStation134();
//		gasStation134.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
//		gasStation134.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
//		gasStation134.canCompleteCircuit(new int[]{1}, new int[]{0});
//		gasStation134.canCompleteCircuit(new int[]{}, new int[]{});
//		gasStation134.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1});
//		gasStation134.canCompleteCircuit(new int[]{2}, new int[]{2});

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.stream().filter(a -> a == 1);
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			gas[i] = gas[i] - cost[i];
		}
		int res = -1;
		int testPoint = 0;

		while (testPoint < gas.length) {
			int i = testPoint;
			int counter = 0;
			for (int k = 0; k < gas.length; k++, i++) {
				if (i == gas.length) {
					i = 0;
				}
				counter += gas[i];
				if (counter < 0) {
					testPoint = i;
					break;
				}
				if (k == gas.length - 1) {
					res = testPoint;
					break;
				}
			}
		}
		return res;
	}
}
