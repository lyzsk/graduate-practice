package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 * @author sichu
 * @date 2022/05/21
 */
public class CodeTop0029 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, path, used, nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, boolean[] used, int[] nums, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(res, path, used, nums, depth + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}
