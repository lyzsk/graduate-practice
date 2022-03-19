package cn.sichu.graduate_practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href = "https://leetcode-cn.com/problems/combination-sum-ii/">40. 组合总和 II</a>
 * @see <a href = "https://leetcode.com/problems/combination-sum-ii/">40. Combination Sum II</a>
 * @author sichu
 * @date 2022/03/19
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(res, candidates, target, new ArrayList<Integer>(), 0, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, List<Integer> path, int pathSum,
        int startIndex) {
        if (pathSum == target) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {

            if (pathSum + candidates[i] <= target) {
                path.add(candidates[i]);
                backtrack(res, candidates, target, path, pathSum + candidates[i], i + 1);
                path.remove(path.size() - 1);
            }

            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
