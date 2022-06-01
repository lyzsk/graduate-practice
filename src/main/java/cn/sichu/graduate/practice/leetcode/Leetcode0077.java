package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 这题可以套用backtrack模板，但是因为有限制条件 k, 很多部分需要剪枝，降低时间复杂度
 * <p>
 * 剪枝部分 就是 {@code i <= n - (k - path.size()) + 1}, 手写的时候 是想象 [1,2,3,4,5] 取 3 个数(n=5,k=3)： 此时 path.size() == 0 到下标为 3
 * 的时候不能取， 即到 n - (k - path.size()) + 1 的时候就不能再取了, 实际理论应该是：
 * <ul>
 * <li>搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
 * <p>
 * 即： 接下来要选择的元素个数 = k - path.size()
 * <p>
 * 即： 搜索起点的上界 = n - (k - path.size()) + 1
 * <p>
 * 即： 把 i <= n 改成 i <= n - (k - path.size()) + 1</li>
 * </ul>
 * <p>
 * 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078, Leetcode0090,
 * <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079, Leetcode0017,
 * <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * 
 * @author sichu
 * @date 2022/05/30
 */
public class Leetcode0077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        backtrack(res, path, n, k, 1);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(res, path, n, k, i + 1);
            path.removeLast();
        }
    }

    /**
     * 未剪枝，纯暴力backtrack
     * 
     * @param n
     * @param k
     * @return res
     */
    // public List<List<Integer>> combine(int n, int k) {
    // List<List<Integer>> res = new ArrayList<List<Integer>>();
    // Deque<Integer> path = new ArrayDeque<Integer>();
    // backtrack(res, path, n, k, 1);
    // return res;
    // }
    //
    // private static void backtrack(List<List<Integer>> res, Deque<Integer> path, int n, int k, int startIndex) {
    // if (path.size() == k) {
    // res.add(new ArrayList<>(path));
    // return;
    // }
    // for (int i = startIndex; i <= n; i++) {
    // path.add(i);
    // backtrack(res, path, n, k, i + 1);
    // path.removeLast();
    // }
    // }
}
