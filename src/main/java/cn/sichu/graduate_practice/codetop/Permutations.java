package cn.sichu.graduate_practice.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 频率22
 * <p>
 * https://leetcode-cn.com/problems/permutations/
 * 
 * @author sichu
 * @date 2022/05/06
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, path, nums, used, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums, boolean[] used, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(res, path, nums, used, depth + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
