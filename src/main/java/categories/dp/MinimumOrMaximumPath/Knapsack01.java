package categories.dp.MinimumOrMaximumPath;

import static sun.swing.MenuItemLayoutHelper.max;

public class Knapsack01 {

	public static void main(String[] args) {
		int[] weight = {3, 8, 6};
		int[] value = {5, 7, 12};
		int capacity = 10;
		Knapsack01 knapsack01 = new Knapsack01();
		int res = knapsack01.pack(weight, value, capacity);
	}

	int[][] memoi;

	public int pack(int[] weight, int[] value, int capacity) {
		if (weight.length == 0 || capacity == 0) {
			return 0;
		}
		memoi = new int[weight.length][capacity + 1];
		for (int i = 0; i < memoi.length; i++) {
			for (int j = 0; j < capacity + 1; j++) {
				memoi[i][j] = -1;
			}
		}
		return bestValue(weight, value, weight.length - 1, capacity);
	}

	//0到index的所有包，能在capacity下填出的最大值
	public int bestValue(int[] weight, int[] value, int index, int capacity) {
		//如果放不下或者没有这个物品，返回0
		if (capacity <= 0 || index < 0) {
			return 0;
		}
		//如果已经求过最大值了，就直接返回最大值
		if (memoi[index][capacity] != -1) {
			return memoi[index][capacity];
		}
		//不放这个
		int res = bestValue(weight, value, index - 1, capacity);
		if (capacity >= weight[index]) {
			//放这个
			res = max(res,
				value[index] + bestValue(weight, value, index - 1, capacity - weight[index]));
		}
		//求最大值
		memoi[index][capacity] = res;
		return res;
	}
}
