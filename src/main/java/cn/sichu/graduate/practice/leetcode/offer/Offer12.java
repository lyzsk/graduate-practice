package cn.sichu.graduate.practice.leetcode.offer;

/**
 * 
 * @author sichu
 * @date 2022/06/03
 */
public class Offer12 {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res = backtrack(used, board, word, i, j, 0);
                if (res) {
                    return true;
                }
            }
        }
        return res;
    }

    private static boolean backtrack(boolean[][] used, char[][] board, String word, int x, int y, int wordIndex) {
        if (wordIndex >= word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) {
            return false;
        }
        if (!used[x][y]) {
            if (word.charAt(wordIndex) == board[x][y]) {
                used[x][y] = true;
                boolean up = backtrack(used, board, word, x - 1, y, wordIndex + 1);
                boolean down = backtrack(used, board, word, x + 1, y, wordIndex + 1);
                boolean left = backtrack(used, board, word, x, y - 1, wordIndex + 1);
                boolean right = backtrack(used, board, word, x, y + 1, wordIndex + 1);
                if (up || down || left || right) {
                    return true;
                }
                used[x][y] = false;
            }
        }
        return false;
    }
}
