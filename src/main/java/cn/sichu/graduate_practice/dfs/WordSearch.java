package cn.sichu.graduate_practice.dfs;

/**
 * https://leetcode.cn/problems/word-search/
 * 
 * @author sichu
 * @date 2022/05/17
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                flag = backtrack(board, word, used, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
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
                boolean up = backtrack(board, word, used, x - 1, y, wordIndex + 1);
                boolean down = backtrack(board, word, used, x + 1, y, wordIndex + 1);
                boolean left = backtrack(board, word, used, x, y - 1, wordIndex + 1);
                boolean right = backtrack(board, word, used, x, y + 1, wordIndex + 1);
                if (up || down || left || right) {
                    return true;
                }
                used[x][y] = false;
            }
        }
        return false;
    }
}
