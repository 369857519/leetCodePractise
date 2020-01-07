package categories.dp;

public class MinimumFallingPathSum931 {

    public static void main(String[] args) {
        MinimumFallingPathSum931 minimumFallingPathSum931=new MinimumFallingPathSum931();
        minimumFallingPathSum931.minFallingPathSum(new int[][]{
            {17,82},
            {1,-44}
        });
    }

    public int minFallingPathSum(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int one = j - 1 >= 0 ? A[i - 1][j - 1] : Integer.MAX_VALUE;
                int two = A[i - 1][j];
                int three = j + 1 < A.length ? A[i - 1][j + 1] : Integer.MAX_VALUE;
                A[i][j] = Math.min(Math.min(one, two), three) + A[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int count : A[A.length - 1]) {
            min = Math.min(min, count);
        }
        return min;
    }

}
