package Algorithm.ppp;

/**
 * Created by 祁连山 on 2019/3/16.
 */
public class WordSearch79 {
    public static void main(String[] args) {
        WordSearch79 wordSearch79 = new WordSearch79();
        wordSearch79.exist(new char[][]{
                {'a'}
        }, "ab");
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (scan(board, i, j, 0, word)) return true;
                }
            }
        }
        return false;
    }

    int[][] directs = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public boolean scan(char[][] board, int row, int column, int currentIndex, String word) {
        if (currentIndex == word.length()) {
            return true;
        }
        if (row < 0 || row == board.length || column < 0
                || column == board[0].length || board[row][column]
                != word.charAt(currentIndex))
            return false;


        board[row][column] = '-';
        for (int i = 0; i < directs.length; i++) {
            if (scan(board, row + directs[i][0], column + directs[i][1], currentIndex + 1, word)) {
                return true;
            }
        }
        board[row][column] = word.charAt(currentIndex);
        return false;
    }
}

