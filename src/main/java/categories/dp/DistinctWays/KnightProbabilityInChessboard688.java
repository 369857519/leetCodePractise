package categories.dp.DistinctWays;

import Utils.ArrayPrintUtil;

public class KnightProbabilityInChessboard688 {

    public static void main(String[] args) {
        KnightProbabilityInChessboard688 knightProbabilityInChessboard688 = new KnightProbabilityInChessboard688();
        double probability = knightProbabilityInChessboard688.knightProbability(3, 2, 0, 0);
        probability = knightProbabilityInChessboard688.knightProbability(8, 30, 6, 4);
    }

    public double knightProbability(int N, int K, int r, int c) {
        double[][] records = new double[N][N];
        double[][] recordsSwap = new double[N][N];
        records[r][c] = 1;
        for (; K > 0; K--) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir : directions) {
                        int newi = dir[0] + i;
                        int newj = dir[1] + j;
                        if (newi >= 0 && newi < N && newj >= 0 && newj < N) {
                            recordsSwap[newi][newj] += records[i][j] / 8.0;
                        }
                    }
                }
            }
            records = recordsSwap;
            recordsSwap=new double[N][N];
            ArrayPrintUtil.printArr(records);
        }
        double prob = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                prob += records[i][j];
            }
        }
        return prob;
    }

    private int[][] directions = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2},
        {-1, -2}};

}
