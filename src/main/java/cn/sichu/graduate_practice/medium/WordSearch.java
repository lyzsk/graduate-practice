package cn.sichu.graduate_practice.medium;

/**
 * https://leetcode.cn/problems/word-search/
 * <p>
 * Offer link: {@link cn.sichu.graduate_practice.offer.Offer12}
 * 
 * @author sichu
 * @date 2022/05/10
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                flag = backtrack(board, word, used, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return flag;
    }

    private static boolean backtrack(char[][] board, String word, boolean[][] used, int startX, int startY,
        int wordIndex) {
        if (wordIndex >= word.length()) {
            return true;
        }
        if (startX < 0 || startX > board.length - 1 || startY < 0 || startY > board[0].length - 1) {
            return false;
        }
        if (!used[startX][startY]) {
            if (word.charAt(wordIndex) == board[startX][startY]) {
                used[startX][startY] = true;
                boolean left = backtrack(board, word, used, startX - 1, startY, wordIndex + 1);
                boolean right = backtrack(board, word, used, startX + 1, startY, wordIndex + 1);
                boolean up = backtrack(board, word, used, startX, startY - 1, wordIndex + 1);
                boolean down = backtrack(board, word, used, startX, startY + 1, wordIndex + 1);
                if (left || right || up || down) {
                    return true;
                }
                used[startX][startY] = false;
            }
        }
        return false;
    }
}
