package cn.sichu.graduate_practice.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @see <a href = "https://leetcode-cn.com/problems/permutations/">46. 全排列</a>
 * @see <a href = "https://leetcode.com/problems/permutations/">46. Permutations</a>
 * @author sichu
 * @date 2022/03/19
 */
public class Permutations {
    /**
     * Time: O(n * n!)
     * <p>
     * Space: O(n * n!)
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        // boolean 初始就是false
        boolean[] used = new boolean[nums.length];
        backtrack(res, new ArrayDeque<Integer>(), nums, used, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums, boolean[] used, int depth) {
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
