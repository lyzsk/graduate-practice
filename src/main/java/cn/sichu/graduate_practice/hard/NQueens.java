package cn.sichu.graduate_practice.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/n-queens/
 * 
 * @author sichu
 * @date 2022/05/16
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> cols = new HashSet<Integer>();
        Set<Integer> diag1 = new HashSet<Integer>();
        Set<Integer> diag2 = new HashSet<Integer>();
        backtrack(res, queens, n, cols, diag1, diag2, 0);
        return res;
    }

    private static void backtrack(List<List<String>> res, int[] queens, int n, Set<Integer> cols, Set<Integer> diag1,
        Set<Integer> diag2, int row) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (cols.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diag1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diag2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                cols.add(i);
                diag1.add(diagonal1);
                diag2.add(diagonal2);
                backtrack(res, queens, n, cols, diag1, diag2, row + 1);
                queens[row] = -1;
                cols.remove(i);
                diag1.remove(diagonal1);
                diag2.remove(diagonal2);
            }
        }
    }

    private static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    /**
     * 更好看的解法
     * 
     * @param n
     * @return
     */
    public List<List<String>> solveNQueensSolution2(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<Integer>();
        Set<Integer> col = new HashSet<Integer>();
        Set<Integer> diag1 = new HashSet<Integer>();
        Set<Integer> diag2 = new HashSet<Integer>();
        backtrack(res, path, n, col, diag1, diag2, 0);
        return res;
    }

    private static void backtrack(List<List<String>> res, Deque<Integer> path, int n, Set<Integer> col,
        Set<Integer> diag1, Set<Integer> diag2, int row) {
        if (row == n) {
            List<String> board = convert2board(path, n);
            res.add(board);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !diag1.contains(row - i) && !diag2.contains(row + i)) {
                path.addLast(i);
                col.add(i);
                diag1.add(row - i);
                diag2.add(row + i);
                backtrack(res, path, n, col, diag1, diag2, row + 1);
                path.removeLast();
                col.remove(i);
                diag1.remove(row - i);
                diag2.remove(row + i);
            }
        }
    }

    private static List<String> convert2board(Deque<Integer> path, int n) {
        List<String> board = new ArrayList<String>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(".".repeat(Math.max(0, n))); // JAVA11
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }
}
