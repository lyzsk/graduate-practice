package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 类似的题： Leetcode0046， Leetcode0047, Leetcode0039, Leetcode0040, <b>Leetcode0077</b>, Leetcode0078, Leetcode0090,
 * <b>Leetcode0060</b>, Leetcode0093, Leetcode0733, Leetcode0200, Leetcode0130, Leetcode0079, Leetcode0017,
 * <b>Leetcode0784</b>, Leetcode0022, Leetcode0051, Leetcode0037, Leetcode0488, Leetcode0529
 * 
 * 
 * @author sichu
 * @date 2022/05/30
 */
public class Leetcode0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(res, path, nums, used, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums, boolean[] used, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(res, path, nums, used, depth + 1);
            used[i] = false;
            path.removeLast();
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
    }
}
