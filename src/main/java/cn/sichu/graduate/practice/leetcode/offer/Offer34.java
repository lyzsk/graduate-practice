package cn.sichu.graduate.practice.leetcode.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cn.sichu.graduate.practice.leetcode.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/06/04
 */
public class Offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        backtrack(res, path, root, target);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(path));
        }
        backtrack(res, path, root.left, target);
        backtrack(res, path, root.right, target);
        path.removeLast();
    }
}
