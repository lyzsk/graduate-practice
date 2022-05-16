package cn.sichu.graduate_practice.offer;

/**
 * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * <p>
 * same: {@link cn.sichu.graduate_practice.medium.WordSearch}
 * 
 * @author sichu
 * @date 2022/05/16
 */
public class Offer12 {
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

    private static boolean backtrack(char[][] board, String word, boolean[][] used, int startX, int startY,
        int wordIndex) {
        if (wordIndex >= word.length()) {
            return true;
        }
        if (startX < 0 || startY < 0 || startX > board.length - 1 || startY > board[0].length - 1) {
            return false;
        }
        if (!used[startX][startY]) {
            if (word.charAt(wordIndex) == board[startX][startY]) {
                used[startX][startY] = true;
                boolean left = backtrack(board, word, used, startX + 1, startY, wordIndex + 1);
                boolean right = backtrack(board, word, used, startX - 1, startY, wordIndex + 1);
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
