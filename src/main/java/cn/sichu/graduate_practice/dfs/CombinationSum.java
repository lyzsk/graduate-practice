package cn.sichu.graduate_practice.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/
 * 
 * @author sichu
 * @date 2022/05/16
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        backtrack(res, path, candidates, target, 0, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] candidates, int target,
        int pathSum, int startIndex) {
        if (pathSum == target) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (pathSum + candidates[i] <= target) {
                path.add(candidates[i]);
                // 可以复用，所以从 i 再开始
                backtrack(res, path, candidates, target, pathSum + candidates[i], i);
                path.removeLast();
            }
        }
    }
}
