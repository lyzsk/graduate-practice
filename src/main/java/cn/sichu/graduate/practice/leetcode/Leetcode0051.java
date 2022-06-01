package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078, Leetcode0090,
 * <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079, Leetcode0017,
 * <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * @author sichu
 * @date 2022/05/31
 */
public class Leetcode0051 {
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
        Set<Integer> diag2, int rowIndex) {
        if (rowIndex == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols.contains(i)) {
                continue;
            }
            int diagonal1 = rowIndex - i;
            if (diag1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = rowIndex + i;
            if (diag2.contains(diagonal2)) {
                continue;
            }
            queens[rowIndex] = i;
            cols.add(i);
            diag1.add(diagonal1);
            diag2.add(diagonal2);
            backtrack(res, queens, n, cols, diag1, diag2, rowIndex + 1);
            queens[rowIndex] = -1;
            cols.remove(i);
            diag1.remove(diagonal1);
            diag2.remove(diagonal2);
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
}
