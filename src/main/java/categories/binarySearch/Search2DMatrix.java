package categories.binarySearch;

public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] testMat = new int[][]{
			{1}
		};
		Search2DMatrix search2DMatrix = new Search2DMatrix();
		boolean res = search2DMatrix.searchMatrix(testMat, 6);
		res = search2DMatrix.searchMatrix(testMat, 7);
		res = search2DMatrix.searchMatrix(testMat, 1);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int length = matrix.length * matrix[0].length;
		int l = 0;
		int r = length - 1;
		while (l < r) {
			int mid = l + r >>> 1;
			int cur = getEle(matrix, mid);
			if (cur < target) {
				l = mid + 1;
			} else if (cur > target) {
				r = mid;
			} else if (cur == target) {
				return true;
			}
		}
		if(l==r&&getEle(matrix,l)==target){
			return true;
		}
		return false;
	}

	public int getEle(int[][] matrix, int i) {
		int row = i / matrix[0].length;
		int column = i % matrix[0].length;
		return matrix[row][column];
	}

}
