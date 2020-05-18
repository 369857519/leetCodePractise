package algorithm.categories.array;

public class SetMatrixZeros73 {

    public static void main(String[] args) {
        SetMatrixZeros73 setMatrixZeros73 = new SetMatrixZeros73();
//        setMatrixZeros73.setZeroes(new int[][]{
//            {1, 1, 1},
//            {0, 1, 2},
//            {0, 2, 3}
//        });
//        setMatrixZeros73.setZeroes(new int[][]{
//            {0},
//            {1}
//        });
        setMatrixZeros73.setZeroes(new int[][]{
            {0, 0, 0, 5},
            {4, 3, 1, 4},
            {0, 1, 1, 4},
            {1, 2, 1, 3},
            {0, 0, 1, 1}
        });
    }

    public void setZeroes(int[][] matrix) {
        //先看第一行和第一列
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnHasZero = true;
            }
        }
        //记录有0的情况
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
//        ArrayPrintUtil.printArr(matrix);
        //非首行首列归零
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

//        ArrayPrintUtil.printArr(matrix);
        //处理首行首列
        if (firstColumnHasZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowHasZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

//        ArrayPrintUtil.printArr(matrix);
    }
}
