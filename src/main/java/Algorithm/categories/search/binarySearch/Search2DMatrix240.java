package Algorithm.categories.search.binarySearch;

public class Search2DMatrix240 {

	public static void main(String[] args) {
		Search2DMatrix240 search2DMatrix240 = new Search2DMatrix240();
		search2DMatrix240.searchMatrix(new int[][]
			{
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}}, 5
		);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}
		if (matrix[0].length == 0) {
			return false;
		}
		int row = 0, column = matrix[0].length - 1;
		while (row < matrix.length && column >= 0) {
			if (matrix[row][column] == target) {
				return true;
			}
			if (matrix[row][column] > target) {
				column--;
				continue;
			}
			row++;
		}
		return false;
	}

}
