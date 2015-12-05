/**
 * @see <a href="https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 */

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        boolean[][][] status= new boolean[3][len][len];
        // status[0][i]: the status of ith row.
        // status[1][i]: the status of ith column.
        // status[2][i]: the status of ith grid.
        // status[i][j][k]: means whether the kth digit has already appeared.
        // status[i][j][0]: for 1.
        // status[i][j][1]: for 2. etc.
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == '.') ;
                else {
                    if (status[0][i][board[i][j] - '1'] || status[1][j][board[i][j] - '1']
                        || status[2][(i/3)*3 + j/3][board[i][j] - '1'])
                        return false;
                    else {
                        status[0][i][board[i][j] - '1'] = true;
                        status[1][j][board[i][j] - '1'] = true;
                        status[2][(i/3)*3 + j/3][board[i][j] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}
