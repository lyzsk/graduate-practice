package cn.sichu.graduate_practice.offerii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/M99OJA/
 * <p>
 * link: {@link cn.sichu.graduate_practice.medium.PalindromePartitioning}
 * 
 * @author sichu
 * @date 2022/04/30
 */
public class OfferII086 {
    public String[][] partition(String s) {
        int n = s.length();

        // 预处理
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];
            }
        }

        List<List<String>> res = new ArrayList<List<String>>();
        Deque<String> path = new ArrayDeque<String>();
        char[] arr = s.toCharArray();
        dfs(arr, 0, path, res, dp);

        // res -> String[][]
        String[][] ans = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new String[res.get(i).size()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }

    private void dfs(char[] arr, int index, Deque<String> path, List<List<String>> res, boolean[][] dp) {
        if (index == arr.length) {
            res.add(new ArrayList<String>(path));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (dp[index][i]) {
                path.add(new String(arr, index, i - index + 1));
                dfs(arr, i + 1, path, res, dp);
                path.removeLast();
            }
        }
    }

    /**
     * 比预处理快1ms，内存消耗少1ms,更优
     * 
     * @param s
     * @return
     */
    public String[][] partitionSolution2(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        Deque<String> path = new ArrayDeque<String>();
        char[] arr = s.toCharArray();
        dfs2(arr, 0, path, res);
        // List<List<String>> res -> String[][] ans
        String[][] ans = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new String[res.get(i).size()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }

    private void dfs2(char[] arr, int index, Deque<String> path, List<List<String>> res) {
        if (index == arr.length) {
            res.add(new ArrayList<String>(path));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (!isPalindrome(arr, index, i)) {
                continue;
            }
            path.add(new String(arr, index, i - index + 1));
            dfs2(arr, i + 1, path, res);
            path.removeLast();
        }
    }

    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
