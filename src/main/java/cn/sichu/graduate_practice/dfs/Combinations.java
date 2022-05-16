package cn.sichu.graduate_practice.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/combinations/
 * 
 * @author sichu
 * @date 2022/05/16
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        backtrack(res, path, n, k, 1);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        // 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        // 即 搜索起点的上界 = n - (k - path.size()) + 1
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(res, path, n, k, i + 1);
            path.removeLast();
        }
    }
}
