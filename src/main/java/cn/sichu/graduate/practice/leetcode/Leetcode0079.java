package cn.sichu.graduate.practice.leetcode;

/**
 * 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078, Leetcode0090,
 * <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079, Leetcode0017,
 * <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * 
 * @author sichu
 * @date 2022/05/31
 */
public class Leetcode0079 {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res = backtrack(board, word, used, i, j, 0);
                if (res) {
                    return true;
                }
            }
        }
        return res;
    }

    private static boolean backtrack(char[][] board, String word, boolean[][] used, int x, int y, int wordIndex) {
        if (wordIndex >= word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) {
            return false;
        }
        if (!used[x][y]) {
            if (word.charAt(wordIndex) == board[x][y]) {
                used[x][y] = true;
                boolean up = backtrack(board, word, used, x, y - 1, wordIndex + 1);
                boolean down = backtrack(board, word, used, x, y + 1, wordIndex + 1);
                boolean left = backtrack(board, word, used, x - 1, y, wordIndex + 1);
                boolean right = backtrack(board, word, used, x + 1, y, wordIndex + 1);
                if (up || down || left || right) {
                    return true;
                }
                used[x][y] = false;
            }
        }
        return false;
    }
}
