package algorithm.ppp;


import algorithm.Utils.DSU;

public class RegionsCutBySlashes {

	public static void main(String[] args) {

		String[] grid = new String[]{
			"/\\", "\\/"
		};
		RegionsCutBySlashes regionsCutBySlashes = new RegionsCutBySlashes();
		int count = regionsCutBySlashes.regionsBySlashes(grid);
	}

	public int regionsBySlashes(String[] grid) {
		int N = grid.length;
		DSU dsu = new DSU(4 * N * N);
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				int root = 4 * (r * N + c);
				char val = grid[r].charAt(c);
				if (val != '\\') {
					dsu.union(root + 0, root + 1);
					dsu.union(root + 2, root + 3);
				}
				if (val != '/') {
					dsu.union(root + 0, root + 2);
					dsu.union(root + 1, root + 3);
				}
				//south
				if (r + 1 < N) {
					dsu.union(root + 3, (root + 4 * N) + 0);
				}
				//north
				if (r - 1 >= 0) {
					dsu.union(root + 0, (root - 4 * N) + 3);
				}
				//east
				if (c + 1 < N) {
					dsu.union(root + 2, (root + 4) + 1);
				}
				//west
				if (c - 1 >= 0) {
					dsu.union(root + 1, (root - 4) + 2);
				}
			}
		}
		int ans = 0;
		for (int x = 0; x < 4 * N * N; ++x) {
			if (dsu.find(x) == x) {
				ans++;
			}
		}
		return ans;
	}

}

