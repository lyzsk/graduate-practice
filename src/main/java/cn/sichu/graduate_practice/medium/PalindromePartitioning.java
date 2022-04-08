package cn.sichu.graduate_practice.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 
 * @author sichu
 * @date 2022/04/07
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        Deque<String> path = new ArrayDeque<String>();
        char[] arr = s.toCharArray();
        dfs(arr, 0, path, res);
        return res;
    }

    private void dfs(char[] arr, int index, Deque<String> path, List<List<String>> res) {

        if (index == arr.length) {
            res.add(new ArrayList<String>(path));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (!isPalindrome(arr, index, i)) {
                continue;
            }
            path.add(new String(arr, index, i - index + 1));
            dfs(arr, i + 1, path, res);
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
