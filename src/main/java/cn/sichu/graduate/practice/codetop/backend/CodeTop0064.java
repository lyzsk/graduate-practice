package cn.sichu.graduate.practice.codetop.backend;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import cn.sichu.graduate.practice.codetop.utils.TreeNode;

/**
 * 
 * @author sichu
 * @date 2022/05/23
 */
public class CodeTop0064 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(res, path, root, targetSum);
        return res;
    }

    private static void dfs(List<List<Integer>> res, Deque<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(res, path, root.left, targetSum);
        dfs(res, path, root.right, targetSum);
        path.removeLast();
    }
}
