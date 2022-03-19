package cn.sichu.graduate_practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href = "https://leetcode-cn.com/problems/permutations-ii/">47. 全排列 II</a>
 * @see <a href = "https://leetcode.com/problems/permutations-ii/">47. Permutations II</a>
 * @author sichu
 * @date 2022/03/19
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, used, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used, int depth) {
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
            path.remove(path.size() - 1);
            used[i] = false;

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
