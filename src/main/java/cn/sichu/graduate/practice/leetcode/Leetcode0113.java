package cn.sichu.graduate.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 这题要注意，添加 res.add()的时候，不能return;
 * <p>
 * 有可能有负数，题目没保证所有数都大于0 不能加 判断>sum的剪枝
 * 
 * @author sichu
 * @date 2022/06/04
 */
public class Leetcode0113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        backtrack(res, path, root, targetSum);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        backtrack(res, path, root.left, targetSum);
        backtrack(res, path, root.right, targetSum);
        path.removeLast();
    }
}
