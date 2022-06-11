package cn.sichu.graduate.practice.leetcode.tencent50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sichu
 * @date 2022/06/11
 */
public class Tencent17 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, path, used, nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, boolean[] used, int[] nums, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(res, path, used, nums, depth + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
