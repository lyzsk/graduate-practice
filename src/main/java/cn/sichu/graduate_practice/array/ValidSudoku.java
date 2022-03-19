package cn.sichu.graduate_practice.array;

/**
 * @see <a href = "https://leetcode-cn.com/problems/valid-sudoku/">36. 有效的数独</a>
 * @see <a href = "https://leetcode.com/problems/valid-sudoku/">36. Valid Sudoku</a>
 * @author sichu
 * @date 2022/03/19
 */
public class ValidSudoku {
    /**
     * Time: O(1) 只遍历一遍
     * <p>
     * Space O(1)
     * 
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        // 小九宫格内，最多出现次数为9
        int[][][] subbox = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    // 数字 -1 化成索引下标
                    int index = c - '1';
                    row[i][index]++;
                    column[j][index]++;
                    subbox[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || column[j][index] > 1 || subbox[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
