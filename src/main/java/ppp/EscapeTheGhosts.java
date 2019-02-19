package ppp;

public class EscapeTheGhosts {

	public static void main(String[] args) {
		EscapeTheGhosts escapeTheGhosts = new EscapeTheGhosts();
		escapeTheGhosts
			.escapeGhosts(new int[][]{{1, 8}, {-9, 0}, {-7, -6}, {4, 3}, {1, 3}}, new int[]{6, -9});
	}

	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		int distance = (int) (Math.abs(target[0]) + Math.abs(target[1]));
		for (int i = 0; i < ghosts.length; i++) {
			if (Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1])
				< distance) {
				return false;
			}
		}
		return true;
	}
}
