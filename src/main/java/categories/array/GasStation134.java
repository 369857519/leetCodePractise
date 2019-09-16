package categories.array;

import java.util.ArrayList;
import java.util.List;

public class GasStation134 {

	public static void main(String[] args) {
		GasStation134 gasStation134 = new GasStation134();
		gasStation134.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
		gasStation134.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
		gasStation134.canCompleteCircuit(new int[]{1}, new int[]{0});
		gasStation134.canCompleteCircuit(new int[]{}, new int[]{});
		gasStation134.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1});
		gasStation134.canCompleteCircuit(new int[]{2}, new int[]{2});
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		List<Integer> testPoints = new ArrayList<>();
		for (int i = 0; i < gas.length; i++) {
			gas[i] = gas[i] - cost[i];
			if (gas[i] >= 0) {
				testPoints.add(i);
			}
		}
		int res = -1;
		for (Integer testPoint : testPoints) {
			int i = testPoint;
			int counter = 0;
			for (int k = 0; k < gas.length; k++, i++) {
				if (i == gas.length) {
					i = 0;
				}
				counter += gas[i];
				if (counter < 0) {
					break;
				}
				if (k == gas.length - 1) {
					res = testPoint;
					break;
				}
			}
			if (res != -1) {
				break;
			}
		}
		return res;
	}
}
