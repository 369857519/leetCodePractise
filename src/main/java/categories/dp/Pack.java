package categories.dp;

public class Pack {

	public void pack(int capacity) {
		int[] v = new int[]{};
		int[] w = new int[]{};
		int count = v.length;
		int[][] route = new int[count + 1][capacity + 1];
		for (int i = 1; i < count + 1; i++) {
			for (int j = 1; j < count + 1; j++) {
				if (j < w[i]) {
					route[i][j] = route[i - 1][j];
				} else {
					route[i][j] = Math.max(route[i - 1][j], v[i] + route[i - 1][j - w[i]]);
				}
			}
		}
	}
}
