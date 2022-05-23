package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 * @author sichu
 * @date 2022/05/22
 */
public class CodeTop0053 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(res, path, nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(res, path, nums, i + 1);
            path.removeLast();
        }
    }
}
