package cn.sichu.graduate_practice.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href = "https://leetcode-cn.com/problems/combination-sum/">39. 组合总和</a>
 * @see <a href = "https://leetcode.com/problems/combination-sum/">39. Combination Sum</a>
 * @author sichu
 * @date 2022/03/19
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(res, new ArrayList<Integer>(), 0, target, candidates, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int pathSum, int target, int[] candidates,
        int startIndex) {
        if (pathSum == target) {
            // 注意加 path 要new出来，因为 path 是在堆上创建的的对象，不new的话会一直加同一个
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (pathSum + candidates[i] <= target) {
                path.add(candidates[i]);
                backtrack(res, path, pathSum + candidates[i], target, candidates, i);
                path.remove(path.size() - 1);
            }
        }
    }

}
